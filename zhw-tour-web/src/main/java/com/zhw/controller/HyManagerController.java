package com.zhw.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhw.component.AreaComponent;
import com.zhw.domain.Area;
import com.zhw.pojo.HyInfoPo;
import com.zhw.response.BaseResult;
import com.zhw.service.HyManagerService;
import com.zhw.type.HyLevelEnum;
import com.zhw.type.JHStatusEnum;
import com.zhw.type.ZYAreaEnum;
import com.zhw.utils.StringUtils;

@RestController
@RequestMapping("/hyManager")
public class HyManagerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private HyManagerService managerService;
	
	@Resource
	private AreaComponent component;
	
	@RequestMapping(value="/delHyAction.do",method=RequestMethod.POST)
	public BaseResult delHyAction(String hyCode) {
		try {
			if(StringUtils.isEmpty(hyCode))	return BaseResult.conditionErrorInstance();
			return managerService.delHy(hyCode);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("删除会员失败，所删除会员编号：",hyCode,",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/ktHyAction.do",method=RequestMethod.POST)
	public BaseResult ktHyAction(String hyCode,HttpServletRequest request) {
		try {
			if(StringUtils.isEmpty(hyCode))	return BaseResult.conditionErrorInstance();
			return managerService.ktHy(hyCode, ControllerUtils.getUserInfo(request).getHyCode());
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("开通会员失败，所开通会员编号：",hyCode,",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/getUnActivedList.do",method=RequestMethod.POST)
	public BaseResult getUnActivedList(String hyCode,int currentPage,HttpServletRequest request) {
		try {
			String currentUser  =  ControllerUtils.getUserInfo(request).getHyCode();
			return managerService.getActivedOrNotListPage(hyCode, JHStatusEnum.UNACTIVED.getTypeCode(), currentPage,currentUser);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("分页获取已激活会员列表失败，当前会员编号：",ControllerUtils.getUserInfo(request).getHyCode(),",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}

	@RequestMapping(value="/getActivedList.do",method=RequestMethod.POST)
	public BaseResult getActivedList(String hyCode,int currentPage,HttpServletRequest request) {
		try {
			String currentUser  =  ControllerUtils.getUserInfo(request).getHyCode();
			return managerService.getActivedOrNotListPage(hyCode, JHStatusEnum.ACTIVED.getTypeCode(), currentPage,currentUser);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("分页获取已激活会员列表失败，当前会员编号：",ControllerUtils.getUserInfo(request).getHyCode(),",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/getUnConfirmList.do",method=RequestMethod.POST)
	public BaseResult getUnConfirmList(String hyCode,int currentPage,HttpServletRequest request) {
		try {
			String currentUser  =  ControllerUtils.getUserInfo(request).getHyCode();
			return managerService.getActivedOrNotListPage(hyCode, JHStatusEnum.ACTIVED_UNFIRMED.getTypeCode(), currentPage,currentUser);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("分页获取已激活会员列表失败，当前会员编号：",ControllerUtils.getUserInfo(request).getHyCode(),",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	//开通会员
	@RequestMapping(value="/ktHy.do",method=RequestMethod.POST)
	public BaseResult ktHy(String hyCode,HttpServletRequest request) {
		try {
			if(StringUtils.isEmpty(hyCode))	return BaseResult.failedInstance("会员编码为空！");
			return managerService.ktHy(hyCode,ControllerUtils.getUserInfo(request).getHyCode());
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("开通会员异常，会员编号：",hyCode,",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	//获取省对应的城市
	@RequestMapping(value="/getCities.do",method=RequestMethod.POST)
	public BaseResult getCities(String provinceId) {
		try {
			if(StringUtils.isEmpty(provinceId))	return BaseResult.failedInstance("省编码不能为空！");
			List<Area> dataList = component.getCities(provinceId);
			if(dataList == null || dataList.size() == 0)	return BaseResult.failedInstance("错误的省编码");
			return BaseResult.sucessInstance().setObj(dataList);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("获取城市列表失败，省ID：",provinceId,",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	//添加会员
	@RequestMapping(value="/addHy.do",method=RequestMethod.POST)
	public BaseResult addHy(HyInfoPo infoPo,HttpServletRequest request) {
		try {
			BaseResult check = this.checkHyInfoPo(infoPo);
			if(check.isFailed())	return check;
			return managerService.addHy(infoPo,ControllerUtils.getUserInfo(request));
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("添加会员失败：",infoPo.getHyCode(),":",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	private BaseResult checkHyInfoPo(HyInfoPo obj) {
		if(obj == null)	return BaseResult.failedInstance("客户端参数错误！");
		
		if(StringUtils.isEmpty(obj.getFwCenter()))		return BaseResult.failedInstance("所属服务中心不能为空！");
		if(StringUtils.isEmpty(obj.getTjMan()))			return BaseResult.failedInstance("推荐人不能为空！");
		if(StringUtils.isEmpty(obj.getJdMan()))			return BaseResult.failedInstance("接点人不能为空！");
		if(StringUtils.isEmpty(obj.getHyCode()))		return BaseResult.failedInstance("会员编码不能为空！");
		if(StringUtils.isEmpty(obj.getYjPwd()))			return BaseResult.failedInstance("一级密码不能为空！");
		if(StringUtils.isEmpty(obj.getEjPwd()))			return BaseResult.failedInstance("二级密码不能为空！");
		if(StringUtils.isEmpty(obj.getSfzCardCode()))	return BaseResult.failedInstance("身份证号码不能为空！");
		if(StringUtils.isEmpty(obj.getKhBankName()))	return BaseResult.failedInstance("开户银行名称不能为空！");
		if(StringUtils.isEmpty(obj.getKhCardCode()))	return BaseResult.failedInstance("银行卡号不能为空！");
		if(StringUtils.isEmpty(obj.getKhName()))		return BaseResult.failedInstance("开户人姓名不能为空！");
		if(StringUtils.isEmpty(obj.getKhProvince()))	return BaseResult.failedInstance("开户省不能为空！");
		if(StringUtils.isEmpty(obj.getKhCity()))		return BaseResult.failedInstance("开户市 不能为空！");
		if(StringUtils.isEmpty(obj.getYxEmail()))		return BaseResult.failedInstance("邮箱不能为空！");
		if(StringUtils.isEmpty(obj.getSjMobile()))		return BaseResult.failedInstance("手机号不能为空！");
		
		if(!HyLevelEnum.checkTypeCodeOk(obj.getHyLevel()))	return BaseResult.failedInstance("申请级别不合法！");
		if(!ZYAreaEnum.checkTypeCodeOk(obj.getZyArea()))	return BaseResult.failedInstance("所属区域不合法！");
		
		if(!StringUtils.isEqual(obj.getYjPwd(), obj.getConfimYjPwd()))	return BaseResult.failedInstance("两次一级密码不匹配！");
		if(!StringUtils.isEqual(obj.getEjPwd(),obj.getConfirmEjPwd()))	return BaseResult.failedInstance("两次二级密码不匹配！");
		
		return BaseResult.sucessInstance();
	}
	
}
