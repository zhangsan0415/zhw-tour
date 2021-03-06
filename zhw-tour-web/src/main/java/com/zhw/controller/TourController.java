package com.zhw.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhw.pojo.TourRegisterPo;
import com.zhw.response.BaseResult;
import com.zhw.service.TourService;
import com.zhw.type.AreaTypeEnum;
import com.zhw.utils.StringUtils;


@RestController
@RequestMapping(value="/tour")
public class TourController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private TourService tourService;
	
	@RequestMapping(value="/getTourItems.do",method=RequestMethod.POST)
	public BaseResult getTourItems(int areaType) {
		try {
			return tourService.getTourItemList(areaType);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("获取旅 游行程项目异常，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/getTourList.do",method= RequestMethod.POST)
	public BaseResult getTourList(int areaType,int tourType,String cfDate,int currentPage,HttpServletRequest request){
		try {
			String hyCode = ControllerUtils.getUserInfo(request).getHyCode();
			return tourService.queryTourList(hyCode,areaType,tourType,cfDate,currentPage);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("分页获取报名列表失败，当前会员编号：",ControllerUtils.getUserInfo(request).getHyCode(),",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/saveInnerTour.do",method=RequestMethod.POST)
	public BaseResult saveInnerTour(@RequestBody TourRegisterPo infoPo,HttpServletRequest request) {
		try {
			
			BaseResult check = this.checkRegisterPo(infoPo);
			if(check.isFailed())	return check;
			return tourService.saveTourList(infoPo.getTourType(), AreaTypeEnum.INNER.getTypeCode(), infoPo.getCfDate(), infoPo.getTourors()
					,ControllerUtils.getUserInfo(request).getHyCode());
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("保存国内旅游信息异常：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/saveOuterTour.do",method=RequestMethod.POST)
	public BaseResult saveOuterTour(@RequestBody TourRegisterPo infoPo,HttpServletRequest request) {
		try {
			BaseResult check = this.checkRegisterPo(infoPo);
			if(check.isFailed())	return check;
			
			return tourService.saveTourList(infoPo.getTourType(), AreaTypeEnum.OUTER.getTypeCode(), infoPo.getCfDate(), infoPo.getTourors()
					,ControllerUtils.getUserInfo(request).getHyCode());
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("保存国外旅游信息异常：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	private BaseResult checkRegisterPo(TourRegisterPo infoPo) {
		if(infoPo == null)	return BaseResult.failedInstance("报名信息不能为空！");
		if(StringUtils.isEmpty(infoPo.getCfDate()))	return BaseResult.failedInstance("出发日期 不能为空！");
		if(infoPo.getTourType() == null)	return BaseResult.failedInstance("行程不能为空！");
		return BaseResult.sucessInstance();
	}
}
