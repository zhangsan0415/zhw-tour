package com.zhw.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhw.response.BaseResult;
import com.zhw.service.ManagerService;

@Controller
@RequestMapping(value="/manager")
public class AdminManagerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private ManagerService managerService;
	
	@RequestMapping(value="/scoreWithdraw.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult scoreWithdraw(String hyCode,String txStatus,int currentPage){
		
		try {
			return managerService.queryWithdraw(hyCode,txStatus,currentPage);
		}  catch (Exception e) {
			logger.error("积分提现审核查询失败"+e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/delScoreWithdraw.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult delScoreWithdraw(String pkId){
		
		try {
			return managerService.delWithdraw(pkId);
		}  catch (Exception e) {
			logger.error("积分提现审核删除失败"+e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/conScoreWithdraw.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult conScoreWithdraw(String pkId){
		
		try {
			return managerService.confirmWithdraw(pkId);
		}  catch (Exception e) {
			logger.error("积分提现审核确认失败"+e);
			return BaseResult.exceptionInstance();
		}
	}
	
	
	@RequestMapping(value="/scoreRecharge.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult scoreRecharge(String hyCode,String txStatus,int currentPage){
		
		try {
			return managerService.queryRecharge(hyCode,txStatus,currentPage);
		}  catch (Exception e) {
			logger.error("积分充值审核查询失败"+e);
			return BaseResult.exceptionInstance();
		}
	}
	@RequestMapping(value="/delScoreRecharge.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult delScoreRecharge(String pkId){
		
		try {
			return managerService.delWithdraw(pkId);
		}  catch (Exception e) {
			logger.error("积分提现审核删除失败"+e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/conScoreRecharge.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult conScoreRecharge(String pkId){
		
		try {
			return managerService.confirmRecharge(pkId);
		}  catch (Exception e) {
			logger.error("积分提现审核确认失败"+e);
			return BaseResult.exceptionInstance();
		}
	}
}
