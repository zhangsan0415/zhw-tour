package com.zhw.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhw.domain.MemberBankInfo;
import com.zhw.domain.MemberInfo;
import com.zhw.domain.MemberScoreInfo;
import com.zhw.domain.NewsCenterInfo;
import com.zhw.domain.TourItem;
import com.zhw.domain.TourRegisterInfo;
import com.zhw.mapper.MemberBankInfoMapper;
import com.zhw.mapper.MemberInfoMapper;
import com.zhw.mapper.MemberScoreInfoMapper;
import com.zhw.mapper.NewsCenterMapper;
import com.zhw.mapper.TourItemMapper;
import com.zhw.mapper.TourRegisterInfoMapper;
import com.zhw.pojo.CommonConstants;
import com.zhw.pojo.HyInfoPo;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;
import com.zhw.service.AdminService;
import com.zhw.type.AreaTypeEnum;
import com.zhw.type.ConfirmStatusEnum;
import com.zhw.type.HyLevelScoreEnum;
import com.zhw.type.IfAdminEnum;
import com.zhw.type.IfBdCenterEnum;
import com.zhw.type.IfDisabledEnum;
import com.zhw.type.JHStatusEnum;
import com.zhw.type.SexEnum;
import com.zhw.type.ZYAreaEnum;
import com.zhw.utils.DateUtils;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private TourItemMapper itemMapper;
	
	@Autowired
    private TourRegisterInfoMapper tourMapper;
	
	@Autowired
	private MemberInfoMapper userInfoMapper;
	
	@Resource
	private MemberScoreInfoMapper scoreInfoMapper;
	
	@Resource
	private NewsCenterMapper newsCenterMapper;
	
	@Resource 
	private MemberBankInfoMapper bankInfoMapper;
	
	@Override
	public PageResult getTourItems(Integer areaType, int currentPage) throws Exception {
		int totalCount = itemMapper.selectTotalCountForPage(areaType);
		if(totalCount == 0)	return PageResult.getOkInstance();
		
		List<TourItem> tourItems = itemMapper.selectListForPage(areaType,PageResult.getStartNumber(currentPage),PageResult.pageSize);
		if(tourItems != null) {
			for(TourItem obj:tourItems){
				obj.setAreaTypeName(AreaTypeEnum.getNameByCode(obj.getAreaType()));
			}
		}
		return PageResult.getPageInstance(tourItems, currentPage, totalCount);
	}

	@Override
	public BaseResult removeTourItem(int pkId) throws Exception {
		//如果存在行程尚未确认，不能删除
		int count = itemMapper.selectUNConfirmBMNumByPkId(pkId);
		if(count>0)	return BaseResult.failedInstance("该行程还存在有未确认的报名，尚不能删除！");
		
		itemMapper.deleteOneItem(pkId);
		return BaseResult.sucessInstance().setMsg("删除成功！");
	}

	@Override
	public BaseResult addOneTourItem(TourItem obj,String hyCode) throws Exception {
		obj.setCreateMan(hyCode);
		obj.setCreateTime(DateUtils.formatCurrentDate());
		itemMapper.insertOneItem(obj);
		return BaseResult.sucessInstance().setMsg("添加成功！");
	}

	@Override
	public BaseResult delTourInfo(int pkId) throws Exception {
		int num = tourMapper.delTourInfo(pkId);
		if(num == 0)return BaseResult.exceptionInstance();
		return BaseResult.sucessInstance().setMsg("删除成功！");
	}

	@Override
	public BaseResult confirmTourInfo(int pkId) throws Exception {
		int num = tourMapper.ConfirmInfo(pkId);
		if(num == 0)return BaseResult.exceptionInstance();
		return BaseResult.sucessInstance().setMsg("确认成功！");
	}

	@Override
	public PageResult queryTourList(String hyCode, int areaType, int tourType,
			String cfDate, int currentPage) {
		int count = tourMapper.selectTourListPageCount(hyCode,areaType,tourType,cfDate);
		if (count==0) return 	PageResult.getOkInstance();
		int start = PageResult.getStartNumber(currentPage);
		List<TourRegisterInfo> list = tourMapper.selectTourListPage(hyCode,areaType,tourType,cfDate,start,	PageResult.pageSize);
		if(list != null) {
			for(TourRegisterInfo obj:list){
				obj.setSexName(SexEnum.getNameByCode(obj.getBmSex()));
				obj.setConfirmStatusName(ConfirmStatusEnum.getNameByCode(obj.getConfirmStatus()));
			}
		}
		return PageResult.getPageInstance(list, currentPage, count);
	}

	@Override
	public PageResult getAuditList(String hyCode, int currentPage) throws Exception {
		int total = userInfoMapper.selectUnAuditCount(hyCode);
		if(total == 0)	return PageResult.getOkInstance();
		
		int start = PageResult.getStartNumber(currentPage);
		List<MemberInfo> list = userInfoMapper.selectUnAuditList(hyCode,start,PageResult.pageSize);
		if(list != null) {
			for(MemberInfo obj:list) {
				obj.setFlag(JHStatusEnum.getNameByCode(obj.getJhStatus()));
				obj.setMoney(HyLevelScoreEnum.getValueByCode(obj.getHyLevel()));
			}
		}
		return PageResult.getPageInstance(list, currentPage, total);
	}
	
	@Override
	public BaseResult addHy(HyInfoPo infoPo,String currentUser) throws Exception {
		String currentDate = DateUtils.formatCurrentDate();
		
		//会员信息
		MemberInfo userInfo = new MemberInfo();
		BeanUtils.copyProperties(infoPo, userInfo);
		userInfo.setZcTime(currentDate);
		userInfo.setXgTime(currentDate);
		userInfo.setJhStatus(JHStatusEnum.ACTIVED.getTypeCode());
		userInfo.setIfAdmin(IfAdminEnum.N_ADMIN.getTypeCode());
		userInfo.setIfBdCenter(IfBdCenterEnum.Y_BD_CENTER.getTypeCode());

		//给注册用户添加开通人
		userInfo.setKtMan(currentUser);
		userInfo.setTjMan(currentUser);
		userInfo.setJdMan(currentUser);
		
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
		userInfoMapper.insertNewHyInfo(userInfo);
		bankInfoMapper.insertNewBankInfo(bankInfo);
		scoreInfoMapper.insertNewScoreInfo(scoreInfo);
		return BaseResult.sucessInstance().setMsg("注册会员成功！");
		
	}
	
	//判断新添加会员编码是否存在
	private boolean isExist(String hyCode) {
		return userInfoMapper.selectCountByHyCode(hyCode)>0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public BaseResult auditHy(String hyCode) throws Exception {
		MemberInfo hyInfo = userInfoMapper.selectHyInfoByCode(hyCode);
		if(hyInfo == null)	return BaseResult.failedInstance("会员不存在！");
		if(JHStatusEnum.isActived(hyInfo.getJhStatus()))	return BaseResult.failedInstance("已审核过的会员不能再次开通！");
		
		String currentDate = DateUtils.formatCurrentDate();
		userInfoMapper.updateJhStatus(hyCode,currentDate,JHStatusEnum.ACTIVED.getTypeCode());

		String ktMan = hyInfo.getKtMan();
		
		BigDecimal bdScore = HyLevelScoreEnum.getValueByCode(hyInfo.getHyLevel());
		
		//给直推10%的奖励
		MemberScoreInfo tjManScoreInfo = scoreInfoMapper.selectScoreInfoByCode(hyInfo.getTjMan());
		tjManScoreInfo.setTjCount(tjManScoreInfo.getTjCount()+1);
		tjManScoreInfo.setGxTime(currentDate);
		this.addJJScore(tjManScoreInfo, bdScore.multiply(CommonConstants.DIRECT_TJ_PERCENT));
		
		//开通者自身得5%奖励
		MemberScoreInfo ktScoreInfo = scoreInfoMapper.selectScoreInfoByCode(ktMan);
		ktScoreInfo.setGxTime(currentDate);
		this.addJJScore(ktScoreInfo, bdScore.multiply(CommonConstants.ACTIVE_HY_PERCENT));
		
		// 获取此次注册会员的报单积分和所注册区域和推荐人上次碰撞剩余的积分
		BigDecimal pdBalance = tjManScoreInfo.getPdBalance();
		int newZyArea = hyInfo.getZyArea();

		if (!this.checkHitHappen(tjManScoreInfo, newZyArea)) {// 未发生碰撞
			tjManScoreInfo.setPdOverArea(newZyArea);
			tjManScoreInfo.setPdBalance(pdBalance.add(bdScore));
			scoreInfoMapper.updateScoreInfo(tjManScoreInfo);
		} else {// 发生了碰撞
			tjManScoreInfo.setPdOverArea(bdScore.compareTo(pdBalance) > 0 ? newZyArea : tjManScoreInfo.getPdOverArea());
			tjManScoreInfo.setPdBalance(
					bdScore.compareTo(pdBalance) > 0 ? bdScore.subtract(pdBalance) : pdBalance.subtract(bdScore));

			BigDecimal hitJjScore = (bdScore.compareTo(pdBalance) > 0 ? pdBalance : bdScore)
					.multiply(CommonConstants.HIT_AREA_PERCENT);// 发生碰撞的积分
			this.addJJScore(tjManScoreInfo, hitJjScore);// 给直接推荐人添加碰撞奖金积分
			scoreInfoMapper.updateScoreInfo(tjManScoreInfo);

			// 给一级上级添加碰撞奖金积分
			MemberScoreInfo oneScoreInfo = scoreInfoMapper.selectScoreInfoByCode(tjManScoreInfo.getTjMan());
			if (oneScoreInfo == null)
				BaseResult.sucessInstance().setMsg("操作成功！");

			this.addJJScore(oneScoreInfo, hitJjScore.multiply(CommonConstants.HIT_ONE_PERCENT));
			scoreInfoMapper.updateScoreInfo(oneScoreInfo);

			// 给再上线级添加碰撞奖金积分
			MemberScoreInfo twoScoreInfo = scoreInfoMapper.selectScoreInfoByCode(oneScoreInfo.getTjMan());
			if (twoScoreInfo == null)
				BaseResult.sucessInstance().setMsg("操作成功！");

			this.addJJScore(twoScoreInfo, hitJjScore.multiply(CommonConstants.HIT_TWO_PERCENT));
			scoreInfoMapper.updateScoreInfo(twoScoreInfo);

			// 给再再上线级添加碰撞奖金积分
			MemberScoreInfo threeScoreInfo = scoreInfoMapper.selectScoreInfoByCode(twoScoreInfo.getTjMan());
			if (threeScoreInfo == null)
				BaseResult.sucessInstance().setMsg("操作成功！");

			this.addJJScore(threeScoreInfo, hitJjScore.multiply(CommonConstants.HIT_THREE_PERCENT));
			scoreInfoMapper.updateScoreInfo(threeScoreInfo);
		}
		return BaseResult.sucessInstance().setMsg("操作成功！");
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

	@Override
	public BaseResult delHy(String hyCode)throws Exception {
		userInfoMapper.deleteHyByCode(hyCode);
		return BaseResult.sucessInstance().setMsg("删除成功！");
	}

	@Override
	public BaseResult getNotBdList(String hyCode, int currentPage) throws Exception {
		int total = userInfoMapper.selectNotBdCount(hyCode);
		if(total == 0)	return PageResult.getOkInstance();
		
		int start = PageResult.getStartNumber(currentPage);
		List<MemberInfo> list = userInfoMapper.selectNotBdList(hyCode,start,PageResult.pageSize);
		if(list != null) {
			for(MemberInfo obj:list) {
				obj.setFlag(IfBdCenterEnum.getNameByCode(obj.getJhStatus()));
				obj.setMoney(HyLevelScoreEnum.getValueByCode(obj.getHyLevel()));
			}
		}
		return PageResult.getPageInstance(list, currentPage, total);
	}

	@Override
	public BaseResult ktBdCenter(String hyCode) throws Exception {
		userInfoMapper.setBdCenter(hyCode);
		return BaseResult.sucessInstance().setMsg("开通成功！");
	}
	
	@Override
	public BaseResult queryHyInfoPage(String hyCode, Integer jhStatus, Integer ifBdCenter, int currentPage)
			throws Exception {
		int total = userInfoMapper.selectHyCountAdmin(hyCode,jhStatus,ifBdCenter);
		if(total ==0)	return PageResult.getOkInstance();
		
		int start = PageResult.getStartNumber(currentPage);
		List<MemberInfo> list = userInfoMapper.selectHyListAdmin(hyCode,jhStatus,ifBdCenter,start,PageResult.pageSize);
		for(MemberInfo obj:list) {
			obj.setJhStatusName(JHStatusEnum.getNameByCode(obj.getJhStatus()));
			obj.setFlag(IfBdCenterEnum.getNameByCode(obj.getIfBdCenter()));
		}
		return PageResult.getPageInstance(list, currentPage, total);
	}

	@Override
	public PageResult getNewsList(String newsTitle,int currentPage) throws Exception {
		int count = newsCenterMapper.selectCount(newsTitle);
		if(count == 0) return PageResult.getOkInstance();
		int start = PageResult.getStartNumber(currentPage);
		List<NewsCenterInfo> list = newsCenterMapper.selectList(newsTitle,start,PageResult.pageSize);
		return PageResult.getPageInstance(list, currentPage, count);
	}

	@Override
	public BaseResult delNews(int pkId) throws Exception {
		return null;
	}

	@Override
	public BaseResult addNews(NewsCenterInfo info) throws Exception {
		//存数据库表
		int num = newsCenterMapper.insertOneNews(info);
		if (num==0)return BaseResult.exceptionInstance();
		return BaseResult.sucessInstance().setMsg("添加成功！");
	}

}
