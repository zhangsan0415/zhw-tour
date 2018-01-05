package com.zhw.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhw.response.BaseResult;
import com.zhw.service.TourService;
import com.zhw.utils.StringUtils;


@Controller
@RequestMapping(value="/tour")
public class TourController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private TourService tourService;
	
	@RequestMapping(value="/getTourList.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult getTourList(String hyCode,int currentPage,HttpServletRequest request){
		try {
			if (hyCode==null || hyCode.equals("")) {
				hyCode = ControllerUtils.getUserInfo(request).getHyCode();//添加人
			}
			return tourService.queryTourList(hyCode,currentPage);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("分页获取报名列表失败，当前会员编号：",ControllerUtils.getUserInfo(request).getHyCode(),",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
}
