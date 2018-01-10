package com.zhw.controller;

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
	public BaseResult addTourItem(TourItem obj) {
		try {
			if(obj == null)	return BaseResult.failedInstance("添加数据不能为空！");
			return BaseResult.sucessInstance().setMsg("添加成功！");
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("添加旅游行程异常，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	

	
}
