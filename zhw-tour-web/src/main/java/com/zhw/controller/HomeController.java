package com.zhw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	//跳转修改资料页面
	@RequestMapping(value="/toModifyHyInfo.do")
	public String toHyInfo() {
		return "modifyHyInfo";
	}
	
	//跳转修改密码页面
	@RequestMapping(value="/toModifyPwd.do")
	public String toModifyPwd() {
		return "modifyPwd";
	}
	
	
	//跳转注册会员页面
	@RequestMapping(value="/toSignIn.do")
	public String toSignIn() {
		return "signIn";
	}
	
	//跳转到关系图页面
	@RequestMapping(value="/toRelation.do")
	public String toRelation() {
		return "relation";
	}
	
	//跳转到查看页面
	@RequestMapping(value="/toView.do")
	public String toView() {
		return "view";
	}
	
	//跳转到未开通会员页面
	@RequestMapping(value="/toUnActiveHyList.do")
	public String toUnActiveHyList(HttpServletRequest request,int type) {
		return "unActiveHyList";
	}
	
	//跳转到已开通会员页面
	@RequestMapping(value="/toActiveHyList.do")
	public String toActiveHyList() {
		return "activeHyList";
	}
	
	//跳转到国内旅游报名页面
	@RequestMapping(value="/toInnerTourEntry.do")
	public String toInnerTourEntry() {
		return "innerTourEntry";
	}
	
	//跳转到国外旅游报名页面
	@RequestMapping(value="/toOuterTourEntry.do")
	public String toOuterTourEntry() {
		return "outerTourEntry";
	}
	
	//跳转查看旅游报名记录页面
	@RequestMapping(value="/toViewTourRecord.do")
	public String toViewTourRecord() {
		return "viewTourRecord";
	}
	
	//跳转到新闻中心页面
	@RequestMapping(value="/toNewsCenter.do")
	public String toNewsCenter() {
		return "newsCenter";
	}
	
	//跳转到积分查询页面
	@RequestMapping(value="/toScoreList.to")
	public String toScoreSearch() {
		return "scoreSearch";
	}
	
	//跳转到积分明细页面
	@RequestMapping(value="/toScoreDetail.do")
	public String toScoreDetail() {
		return "scoreDetail";
	}
	
	//跳转到积分互转页面
	@RequestMapping(value="/toScoreTransfer.do")
	public String toScoreTransfer() {
		return "scoreTransfer";
	}
	
	//跳转的积分充值页面
	@RequestMapping(value="/toScoreRecharge.do")
	public String toScoreRecharge() {
		return "scoreRecharge";
	}
	
	//跳转到积分提现页面
	@RequestMapping(value="/toScoreWithdraw.do")
	public String toScoreWithdraw() {
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
		return "scoreRechargeAmdin";
	}
	
	//跳转到注册会员页面，可审批
	@RequestMapping(value="/toSignInAdmin.do")
	public String toSignInAdmin() {
		return "signInAdmin";
	}
	
	//跳转到开通会员页面，可审批
	@RequestMapping(value="/toActiveHyAdmin.do")
	public String toActiveHyAdmin() {
		return "activeHyAdmin";
	}
	
	//跳转到旅游报名管理员页面
	@RequestMapping(value="/tourEntryAdmin.do")
	public String toTourEntryAdmin() {
		return "tourEntryAdmin";
	}
	
	//跳转到新闻中心管理员页面
	@RequestMapping(value="/toNewsCenterAdmin.do")
	public String toNewCenterAdmin() {
		return "newsCenterAdmin";
	}
	
}
