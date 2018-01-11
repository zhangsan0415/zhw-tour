package com.zhw.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhw.domain.TourItem;
import com.zhw.response.BaseResult;
import com.zhw.service.AdminService;
import com.zhw.utils.StringUtils;

@RequestMapping("/admin")
@RestController
public class AdminController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminService adminService;
	
	/***********************旅游管理****************************************/
	
	//分页查询管理员行程管理
	@RequestMapping(value="/tourItems.do",method=RequestMethod.POST)
	public BaseResult tourItems(Integer areaType,int currentPage) {
		try {
			return adminService.getTourItems(areaType,currentPage);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("获取旅游行程失败，原因：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	//删除旅游行程
	@RequestMapping(value="/delTourItem.do",method=RequestMethod.POST)
	public BaseResult delTourItem(int pkId) {
		try {
			return adminService.removeTourItem(pkId);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("删除旅游行程失败，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	//添加旅游行程
	@RequestMapping(value="/addTourItem.do",method=RequestMethod.POST)
	public BaseResult addTourItem(TourItem obj,HttpServletRequest request) {
		try {
			if(obj == null)	return BaseResult.failedInstance("添加数据不能为空！");
			return adminService.addOneTourItem(obj,ControllerUtils.getUserInfo(request).getHyCode());
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("添加旅游行程异常，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	//旅游报名查看
	@RequestMapping(value="/queryTourList.do",method= RequestMethod.POST)
	public BaseResult getTourList(String hyCode,int areaType,int tourType,String cfDate,int currentPage,HttpServletRequest request){
		try {
			return adminService.queryTourList(hyCode,areaType,tourType,cfDate,currentPage);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("分页获取报名列表失败，当前会员编号：",ControllerUtils.getUserInfo(request).getHyCode(),",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	//管理员删除报名记录
	@RequestMapping(value="/delTourInfo.do",method=RequestMethod.POST)
	public BaseResult delTourInfo(int pkId) {
		try {
			return adminService.delTourInfo(pkId);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("管理员删除报名记录，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	//管理员确认报名记录
	@RequestMapping(value="/confirmTourInfo.do",method=RequestMethod.POST)
	public BaseResult confirmTourInfo(int pkId) {
		try {
			return adminService.confirmTourInfo(pkId);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("管理员确认报名记录，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	
	/***********************会员管理****************************************/
	@RequestMapping(value="/auditList.do",method=RequestMethod.POST)
	public BaseResult auditList(String hyCode,int currentPage ){
		try {
			return adminService.getAuditList(hyCode, currentPage);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("分页获取已激活会员列表失败，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/auditHy.do",method=RequestMethod.POST)
	public BaseResult auditHy(String hyCode) {
		try {
			if(StringUtils.isEmpty(hyCode))	return BaseResult.conditionErrorInstance();
			return adminService.auditHy(hyCode);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("审核会员异常，编号：",hyCode,",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/delHy.do",method=RequestMethod.POST)
	public BaseResult delHy(String hyCode) {
		try {
			if(StringUtils.isEmpty(hyCode))	return BaseResult.conditionErrorInstance();
			return adminService.delHy(hyCode);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("删除会员异常，编号：",hyCode,",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/notBdList.do",method=RequestMethod.POST)
	public BaseResult notBdList(String hyCode,int currentPage) {
		try {
			return adminService.getNotBdList(hyCode, currentPage);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("分页获取非报单中心列表失败，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/ktBd.do",method=RequestMethod.POST)
	public BaseResult ktBd(String hyCode) {
		try {
			return adminService.ktBdCenter(hyCode);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("开通报单中心失败，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	

	
}
