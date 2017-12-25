package com.zhw.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhw.domain.MemberBankInfo;
import com.zhw.domain.MemberInfo;
import com.zhw.domain.MemberScoreInfo;
import com.zhw.mapper.MemberBankInfoMapper;
import com.zhw.mapper.MemberInfoMapper;
import com.zhw.mapper.MemberScoreInfoMapper;
import com.zhw.pojo.HyInfoPo;
import com.zhw.pojo.JJScorePercentPo;
import com.zhw.response.BaseResult;
import com.zhw.service.HyManagerService;
import com.zhw.type.IfAdminEnum;
import com.zhw.type.IfDisabledEnum;
import com.zhw.type.JHStatusEnum;
import com.zhw.type.ZYAreaEnum;
import com.zhw.utils.DateUtils;
import com.zhw.utils.StringUtils;

@Service
public class HyManagerServiceImpl implements HyManagerService {
	
	@Resource
	private MemberInfoMapper infoMapper;
	
	@Resource 
	private MemberBankInfoMapper bankInfoMapper;
	
	@Resource
	private MemberScoreInfoMapper scoreInfoMapper;

	@Override
	public BaseResult addHy(HyInfoPo infoPo) throws Exception {
		String currentDate = DateUtils.formatCurrentDate();
		
		//会员信息
		MemberInfo userInfo = new MemberInfo();
		BeanUtils.copyProperties(infoPo, userInfo);
		userInfo.setZcTime(currentDate);
		userInfo.setXgTime(currentDate);
		userInfo.setJhStatus(JHStatusEnum.UNACTIVED.getTypeCode());
		userInfo.setIfAdmin(IfAdminEnum.N_ADMIN.getTypeCode());
		
		//会员对应很行信息
		MemberBankInfo bankInfo = new MemberBankInfo();
		BeanUtils.copyProperties(infoPo, bankInfo);
		bankInfo.setCjTime(currentDate);
		bankInfo.setXgTime(currentDate);
		bankInfo.setIfDisabled(IfDisabledEnum.UNDISABLED.getTypeCode());
		
		//对应积分信息
		MemberScoreInfo scoreInfo = new MemberScoreInfo();
		scoreInfo.setHyCode(infoPo.getHyCode());
		scoreInfo.setHyLevel(infoPo.getHyLevel());
		scoreInfo.setTjCount(0);
		scoreInfo.setIfAdmin(IfAdminEnum.N_ADMIN.getTypeCode());
		scoreInfo.setLjTotalScore(BigDecimal.ZERO);
		scoreInfo.setJjScore(BigDecimal.ZERO);
		scoreInfo.setXjScore(BigDecimal.ZERO);
		scoreInfo.setLyScore(BigDecimal.ZERO);
		scoreInfo.setGwScore(BigDecimal.ZERO);
		scoreInfo.setBdScore(BigDecimal.ZERO);
		scoreInfo.setPdBalance(BigDecimal.ZERO);
		scoreInfo.setPdOverArea(ZYAreaEnum.LEFT_AREA.getTypeCode());
		scoreInfo.setGxTime(currentDate);
		
		return this.saveHyInfo(userInfo,bankInfo,scoreInfo,currentDate);
	}
	
	//判断新添加会员编码是否存在
	private boolean isExist(String hyCode) {
		return infoMapper.selectCountByHyCode(hyCode)>0;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public BaseResult saveHyInfo(MemberInfo userInfo,MemberBankInfo bankInfo,MemberScoreInfo scoreInfo,String currentDate)throws Exception{
		//判断是否已存在会员编号，如果存在，保存失败
		if(this.isExist(userInfo.getHyCode()))	return BaseResult.failedInstance("会员编号已存在，请重新输入！");
		
		//插入会员表、会员银行信息表、积分表
		int userResult = infoMapper.insertNewHyInfo(userInfo);
		int bankResult = bankInfoMapper.insertNewBankInfo(bankInfo);
		int scoreResult = scoreInfoMapper.insertNewScoreInfo(scoreInfo);
		
		if(userResult == 0 || bankResult == 0 || scoreResult == 0) throw new Exception(StringUtils.putTogether("更新数据库异常：",userInfo.getHyCode()));
		
		//获取推荐人积分
		MemberScoreInfo tjManScoreInfo = scoreInfoMapper.selectTjScoreInfoByTjCode(userInfo.getTjMan());
		tjManScoreInfo.setTjCount(tjManScoreInfo.getTjCount()+1);
		tjManScoreInfo.setGxTime(currentDate);
		
		//添加直推奖金积分
		this.addJJScore(tjManScoreInfo, scoreInfo.getBdScore().multiply(JJScorePercentPo.DIRECT_TJ_PERCENT));
		
		//获取此次注册会员的报单积分和所注册区域和推荐人上次碰撞剩余的积分
		BigDecimal bdScore = scoreInfo.getBdScore();
		BigDecimal pdBalance = tjManScoreInfo.getPdBalance();
		int newZyArea = userInfo.getZyArea();
		
		
		if(!this.checkHitHappen(tjManScoreInfo, newZyArea)) {//未发生碰撞
			tjManScoreInfo.setPdOverArea(newZyArea);
			tjManScoreInfo.setPdBalance(pdBalance.add(bdScore));
			int tjResult = scoreInfoMapper.updateScoreInfo(tjManScoreInfo);
			if(tjResult == 0) throw new Exception(StringUtils.putTogether("更新数据库异常：",userInfo.getHyCode()));
		}else {//发生了碰撞
			tjManScoreInfo.setPdOverArea(bdScore.compareTo(pdBalance)>0?newZyArea:tjManScoreInfo.getPdOverArea());
			tjManScoreInfo.setPdBalance(bdScore.compareTo(pdBalance)>0?bdScore.subtract(pdBalance):pdBalance.subtract(bdScore));
			
			BigDecimal hitJjScore = (bdScore.compareTo(pdBalance)>0?pdBalance:bdScore).multiply(JJScorePercentPo.HIT_AREA_PERCENT);//发生碰撞的积分
			this.addJJScore(tjManScoreInfo, hitJjScore);//给直接推荐人添加碰撞奖金积分

			if(scoreInfoMapper.updateScoreInfo(tjManScoreInfo)==0){
				throw new Exception(StringUtils.putTogether("更新数据库异常：",userInfo.getHyCode()));
			}

			//给一级上级添加碰撞奖金积分
			MemberScoreInfo oneScoreInfo = scoreInfoMapper.selectTjScoreInfoByTjCode(tjManScoreInfo.getTjMan());
			if(oneScoreInfo == null)	BaseResult.sucessInstance().setMsg("注册会员成功！");

			this.addJJScore(oneScoreInfo, hitJjScore.multiply(JJScorePercentPo.HIT_ONE_PERCENT));
			if( scoreInfoMapper.updateScoreInfo(oneScoreInfo)==0){
				throw new Exception(StringUtils.putTogether("更新数据库异常：",userInfo.getHyCode()));
			}

			//给再上线级添加碰撞奖金积分
			MemberScoreInfo twoScoreInfo = scoreInfoMapper.selectTjScoreInfoByTjCode(oneScoreInfo.getTjMan());
			if(twoScoreInfo == null)	BaseResult.sucessInstance().setMsg("注册会员成功！");


			this.addJJScore(twoScoreInfo, hitJjScore.multiply(JJScorePercentPo.HIT_TWO_PERCENT));
			if( scoreInfoMapper.updateScoreInfo(twoScoreInfo)==0){
				throw new Exception(StringUtils.putTogether("更新数据库异常：",userInfo.getHyCode()));
			}

			//给再再上线级添加碰撞奖金积分
			MemberScoreInfo threeScoreInfo = scoreInfoMapper.selectTjScoreInfoByTjCode(twoScoreInfo.getTjMan());
			if(threeScoreInfo == null)	BaseResult.sucessInstance().setMsg("注册会员成功！");

			this.addJJScore(threeScoreInfo, hitJjScore.multiply(JJScorePercentPo.HIT_THREE_PERCENT));
			if( scoreInfoMapper.updateScoreInfo(threeScoreInfo)==0){
				throw new Exception(StringUtils.putTogether("更新数据库异常：",userInfo.getHyCode()));
			}
		}
		return BaseResult.sucessInstance().setMsg("注册会员成功！");
	}
	
	//添加奖金积分
	private void addJJScore(MemberScoreInfo scoreInfo,BigDecimal jjScore) {
		scoreInfo.setJjScore(scoreInfo.getJjScore().add(jjScore));
		scoreInfo.setLjTotalScore(scoreInfo.getLjTotalScore().add(jjScore));
	}

	//检查 是否发生碰撞
	private boolean checkHitHappen(MemberScoreInfo scoreInfo,int newZyArea) {
		if(BigDecimal.ZERO.compareTo(scoreInfo.getPdBalance()) == 0)	return false;
		if(scoreInfo.getPdOverArea() == newZyArea)		return false;
		return true;
	}
	
	
	
	

}
