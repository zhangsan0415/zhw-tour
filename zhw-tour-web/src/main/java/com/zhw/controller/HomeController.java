package com.zhw.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhw.component.AreaComponent;
import com.zhw.domain.Area;
import com.zhw.domain.BdApply;
import com.zhw.domain.MemberInfo;
import com.zhw.service.BdApplyService;
import com.zhw.service.HomeService;
import com.zhw.service.PersonService;
import com.zhw.service.ScoreService;
import com.zhw.type.AreaTypeEnum;
import com.zhw.type.BankEnum;
import com.zhw.type.IfBdCenterEnum;
import com.zhw.type.JHStatusEnum;
import com.zhw.type.ZZTypeEnum;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Resource
	private HomeService homeService;
	
	@Resource
	private AreaComponent areaComponent;
	
	@Resource
	private ScoreService scoreService;
	@Resource
	private PersonService personService;
	
	@Resource
	private BdApplyService bdService;

	//跳转修改资料页面
	@RequestMapping(value="/toModifyHyInfo.do")
	public String toHyInfo(HttpServletRequest request) {
		//查询一下银行卡数据
		request.setAttribute("MemberBankInfo",homeService.queryBankInfo(ControllerUtils.getUserInfo(request).getHyCode()) );
		//向前台输出支持的银行卡列表
		request.setAttribute("bankList", BankEnum.values());
		//向前台输出省份信息
		List<Area> areas = areaComponent.getProvinces();
		request.setAttribute("provinces",areas );
		request.setAttribute("cities",areaComponent.getCities(areas.get(0).getPkId()));
		return "modifyHyInfo";
	}
	
	//跳转修改密码页面
	@RequestMapping(value="/toModifyPwd.do")
	public String toModifyPwd() {
		return "modifyPwd";
	}
	
	
	//跳转注册会员页面
	@RequestMapping(value="/toSignIn.do")
	public String toSignIn(HttpServletRequest request) {
		
		MemberInfo info = ControllerUtils.getUserInfo(request);
		//计算所属报单中心，如果当前登录人为报单中心，则为当前登录人，如果不是，取当前登录人的开通人
		if(IfBdCenterEnum.isBdCenter(info.getIfBdCenter()))
			request.setAttribute("ownedBdCenter", info.getHyCode());
		else
			request.setAttribute("ownedBdCenter", info.getKtMan());
		
		//向前台推送接点人信息
		request.setAttribute("tjMan",homeService.getJDManHyCode(info.getHyCode()));
		
		//向前台输出支持的银行卡列表
		request.setAttribute("bankList", BankEnum.values());
		
		//向前台输出省份信息
		List<Area> areas = areaComponent.getProvinces();
		request.setAttribute("provinces",areas );
		request.setAttribute("cities",areaComponent.getCities(areas.get(0).getPkId()));
		return "signIn";
	}
	
	//跳转到关系图页面
	@RequestMapping(value="/toRelation.do")
	public String toRelation() {
		return "relation";
	}
	//跳转系统图
	@RequestMapping(value="toSystem.do")
	public String toSystem(HttpServletRequest request){
		return "system";
	}
	//跳转到查看页面
	@RequestMapping(value="/toView.do")
	public String toView(HttpServletRequest request) {
		return "view";
	}
	
	//跳转到未开通会员页面
	@RequestMapping(value="/toUnActiveHyList.do")
	public String toUnActiveHyList(HttpServletRequest request) {
		return "unActiveHyList";
	}
	
	//跳转到已开通会员页面
	@RequestMapping(value="/toUnConfirmHyList.do")
	public String toUnConfirmHyList(HttpServletRequest request) {
		return "unConfirmHyList";
	}
	
	//跳转到已开通未审核会员页面
	@RequestMapping(value="/toActiveHyList.do")
	public String toActiveHyList(HttpServletRequest request) {
		return "activeHyList";
	}
	
	//跳转到国内旅游报名页面
	@RequestMapping(value="/toInnerTourEntry.do")
	public String toInnerTourEntry(HttpServletRequest request) {
		request.setAttribute("tourItems", homeService.queryTourItems(AreaTypeEnum.INNER.getTypeCode()));
		return "innerTourEntry";
	}
	
	//跳转到国外旅游报名页面
	@RequestMapping(value="/toOuterTourEntry.do")
	public String toOuterTourEntry(HttpServletRequest request) {
		request.setAttribute("tourItems", homeService.queryTourItems(AreaTypeEnum.OUTER.getTypeCode()));
		return "outerTourEntry";
	}
	
	//跳转查看旅游报名记录页面
	@RequestMapping(value="/toViewTourRecord.do")
	public String toViewTourRecord(HttpServletRequest request) {
		request.setAttribute("tourItems", homeService.queryTourItems(AreaTypeEnum.INNER.getTypeCode()));
		return "viewTourRecord";
	}
	
	//跳转到新闻中心页面
	@RequestMapping(value="/toNewsCenter.do")
	public String toNewsCenter() {
		return "newsCenter";
	}
	
//	//跳转到积分查询页面（暂时去掉）
//	@RequestMapping(value="/toScoreList.to")
//	public String toScoreSearch() {
//		return "scoreSearch";
//	}
//	
	//跳转到积分明细页面
	@RequestMapping(value="/toScoreDetail.do")
	public String toScoreDetail(HttpServletRequest request) {
		String hyCode = ControllerUtils.getScoreInfo(request).getHyCode();
		request.setAttribute("scoreList", homeService.queryScoreList(hyCode));
		return "scoreDetail";
	}
	
	//跳转到积分互转页面
	@RequestMapping(value="/toScoreTransfer.do")
	public String toScoreTransfer(HttpServletRequest request) {
		//向前台输出支持的转换关系
		request.setAttribute("zzTypeList", ZZTypeEnum.values());
//		String hyCode = ControllerUtils.getUserInfo(request).getHyCode();
//		int status = JHStatusEnum.UNACTIVED.getTypeCode();
//		request.setAttribute("zzList", scoreService.queryInfo(hyCode,status));
		return "scoreTransfer";
	}
	
	//跳转的积分充值页面
	@RequestMapping(value="/toScoreRecharge.do")
	public String toScoreRecharge() {
		return "scoreRecharge";
	}
	
	//跳转到积分提现页面
	@RequestMapping(value="/toScoreWithdraw.do")
	public String toScoreWithdraw(HttpServletRequest request) {
		//String hyCode = ControllerUtils.getUserInfo(request).getHyCode();
		//int status = JHStatusEnum.ACTIVED.getTypeCode();
		//request.setAttribute("txList", scoreService.queryInfo(hyCode,status));
		return "scoreWithdraw";
	}
	
	
	//*************************************************************************
	
	//下面页面为只有报单中心才可见
	
	//*************************************************************************
	
	//跳思考到积分充值页面，可审批
	@RequestMapping(value="/toScoreRechargeAdmin.do")
	public String toScoreRechargeAdmin() {
		return "scoreRechargeAdmin";
	}
	
	//跳转到积分提现页面，可审批
	@RequestMapping(value="/toScoreWithdrawAdmin.do")
	public String toScoreWithdrawAdmin() {
		return "scoreWithdrawAdmin";
	}
	
	//跳转到注册会员页面，可审批
	@RequestMapping(value="/toBdAdmin.do")
	public String toBdAdmin() {
		return "bdCenterAdmin";
	}
	
	//跳转到管理员会员查询
	@RequestMapping(value="/toHyInfoAdmin.do")
	public String toHyInfoAdmin(HttpServletRequest request) {
		request.setAttribute("ktStatuses", JHStatusEnum.values());
		request.setAttribute("bdCenters", IfBdCenterEnum.values());
		return "hyInfoAdmin";
	}
	
	//跳转到管理员添加会员页面
	@RequestMapping(value="/addBodanCenter.do")
	public String toAddBdCenterAdmin(HttpServletRequest request) throws Exception {
		MemberInfo info = ControllerUtils.getUserInfo(request);
		BdApply data = bdService.queryBdApplyByCode(info.getHyCode());
		if(data == null) {
			data = new BdApply();
			data.setHyCode(info.getHyCode());
			data.setIfBdCenter(info.getIfBdCenter());
		}	
		
		data.setIfBdCenterName(IfBdCenterEnum.getTagByCode(info.getIfBdCenter()));
		request.setAttribute("data", data);
		return "addBodanCenter";
	}
	
	//跳转到开通会员页面，可审批
	@RequestMapping(value="/toActiveHyAdmin.do")
	public String toActiveHyAdmin() {
		return "activeHyAdmin";
	}
	
	//跳转到旅游报名管理员页面
	@RequestMapping(value="/tourEntryAdmin.do")
	public String toTourEntryAdmin(HttpServletRequest request) {
		request.setAttribute("tourItems", homeService.queryTourItems(AreaTypeEnum.INNER.getTypeCode()));
		return "tourEntryAdmin";
	}
	
	@RequestMapping(value="/toTourItemAdmin.do")
	public String toTourItemAdmin() {
		return "tourItemAdmin";
	}
	
	//跳转到新闻中心管理员页面
	@RequestMapping(value="/toNewsCenterAdmin.do")
	public String toNewCenterAdmin() {
		return "newsCenterAdmin";
	}
	
}
