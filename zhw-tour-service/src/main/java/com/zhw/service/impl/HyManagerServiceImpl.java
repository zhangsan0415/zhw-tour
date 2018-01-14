package com.zhw.service.impl;

import java.math.BigDecimal;
import java.util.List;

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
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;
import com.zhw.service.HyManagerService;
import com.zhw.type.HyLevelEnum;
import com.zhw.type.HyLevelScoreEnum;
import com.zhw.type.IfAdminEnum;
import com.zhw.type.IfBdCenterEnum;
import com.zhw.type.IfDisabledEnum;
import com.zhw.type.JHStatusEnum;
import com.zhw.type.ZYAreaEnum;
import com.zhw.utils.DateUtils;

@Service
public class HyManagerServiceImpl implements HyManagerService {
	
	@Resource
	private MemberInfoMapper infoMapper;
	
	@Resource 
	private MemberBankInfoMapper bankInfoMapper;
	
	@Resource
	private MemberScoreInfoMapper scoreInfoMapper;

	@Override
	public BaseResult addHy(HyInfoPo infoPo,MemberInfo sessionUser) throws Exception {
		String currentDate = DateUtils.formatCurrentDate();
		
		//会员信息
		MemberInfo userInfo = new MemberInfo();
		BeanUtils.copyProperties(infoPo, userInfo);
		userInfo.setZcTime(currentDate);
		userInfo.setXgTime(currentDate);
		userInfo.setJhStatus(JHStatusEnum.UNACTIVED.getTypeCode());
		userInfo.setIfAdmin(IfAdminEnum.N_ADMIN.getTypeCode());
		userInfo.setIfBdCenter(IfBdCenterEnum.N_BD_CENTER.getTypeCode());

		//给注册用户添加开通人
		if(IfBdCenterEnum.isBdCenter(sessionUser.getIfBdCenter()))	userInfo.setKtMan(sessionUser.getHyCode());
		else userInfo.setKtMan(sessionUser.getKtMan());
		
		
		
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
		
		return this.registerHyInfo(userInfo,bankInfo,scoreInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public BaseResult registerHyInfo(MemberInfo userInfo,MemberBankInfo bankInfo,MemberScoreInfo scoreInfo) throws Exception{
		//判断是否已存在会员编号，如果存在，保存失败
		if(this.isExist(userInfo.getHyCode()))	return BaseResult.failedInstance("会员编号已存在，请重新输入！");
		
		//插入会员表、会员银行信息表、积分表
		infoMapper.insertNewHyInfo(userInfo);
		bankInfoMapper.insertNewBankInfo(bankInfo);
		scoreInfoMapper.insertNewScoreInfo(scoreInfo);
		
		return BaseResult.sucessInstance().setMsg("注册会员成功！");
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public BaseResult ktHy(String hyCode,String ktMan) throws Exception {
		MemberInfo hyInfo = infoMapper.selectHyInfoByCode(hyCode);
		if(hyInfo == null)	return BaseResult.failedInstance("会员不存在！");
		
		String currentDate = DateUtils.formatCurrentDate();

		infoMapper.updateJhStatus(hyCode,currentDate,JHStatusEnum.ACTIVED_UNFIRMED.getTypeCode());
		return BaseResult.sucessInstance().setMsg("开通会员成功！");
	}
	
	@Override
	public BaseResult delHy(String hyCode) throws Exception {
		MemberInfo info = infoMapper.selectHyInfoByCode(hyCode);
		if(info == null)	return BaseResult.failedInstance("会员不存！");
		if(JHStatusEnum.isActived(info.getJhStatus())) return BaseResult.failedInstance("已开通的会员不能删除！");
		return infoMapper.deleteHyByCode(hyCode) == 0
				?BaseResult.exceptionInstance():BaseResult.sucessInstance().setMsg("删除会员成功");
	}

	//判断新添加会员编码是否存在
	private boolean isExist(String hyCode) {
		return infoMapper.selectCountByHyCode(hyCode)>0;
	}
	

	@Override
	public PageResult getActivedOrNotListPage(String hyCode, int jhStatus, int currentPage,String currentUser) throws Exception {
		int totalCount = infoMapper.selectCountForActivedOrNot(hyCode, jhStatus,currentUser);
		if(totalCount == 0)	return PageResult.getOkInstance();
		
		int start =  PageResult.getStartNumber(currentPage);
		List<MemberInfo> dataList = infoMapper.selectActivedOrNotPageList(hyCode, jhStatus, start, PageResult.pageSize,currentUser);
		this.setMoneyAndFlag(dataList);
		
		return PageResult.getPageInstance(dataList, currentPage, totalCount);
	}
	
	private void setMoneyAndFlag(List<MemberInfo> list){
		list.forEach(obj->{
			obj.setMoney(HyLevelScoreEnum.getValueByCode(obj.getHyLevel()));
			obj.setFlag(JHStatusEnum.getNameByCode(obj.getJhStatus()));
			obj.setLevelName(HyLevelEnum.getNameByCode(obj.getHyLevel()));
		});
	}



}
