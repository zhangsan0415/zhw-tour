package com.zhw.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhw.pojo.HyInfoPo;
import com.zhw.response.BaseResult;
import com.zhw.service.HyManagerService;
import com.zhw.type.HyLevelEnum;
import com.zhw.type.ZYAreaEnum;
import com.zhw.utils.StringUtils;

@Controller
@RequestMapping("/hyManager")
public class HyManagerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private HyManagerService managerService;
	
	//添加会员
	@RequestMapping(value="/addHy.do",method=RequestMethod.POST)
	@ResponseBody
	public BaseResult addHy(HyInfoPo infoPo,HttpServletRequest request) {
		BaseResult check = this.checkHyInfoPo(infoPo);
		if(check.isFailed())	return check;
		
		try {
			return managerService.addHy(infoPo);
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
