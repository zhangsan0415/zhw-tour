package com.zhw.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhw.domain.MemberInfo;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;
import com.zhw.service.PersonService;
import com.zhw.utils.StringUtils;

/**
 * 个人资料相关
 * @author zsl
 */
@Controller
@RequestMapping(value="/person")
public class PersonInfoController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private PersonService personService;
	/**
	 * 修改资料
	 * @return
	 */
	@RequestMapping(value="/doModifyInfo.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult modifyInfo(String hyCode,String khBankName,String khCardCode,String khName,String khProvince,
			String khCity,String sfzCardCode,String yxEmail,String sjMobile,HttpServletRequest request){
		try {
			if (StringUtils.isEmpty(hyCode,khBankName,khCardCode,khCity,khName,khProvince,sfzCardCode,sjMobile,yxEmail)) {
				return BaseResult.conditionErrorInstance();
			}
			int num = personService.modifyInfo(hyCode, khBankName, khCardCode, khName, khProvince, khCity, sfzCardCode, yxEmail, sjMobile);
			if (num>0) {
				//设置session信息
				MemberInfo memberInfo = ControllerUtils.getUserInfo(request);
				memberInfo.setSfzCardCode(sfzCardCode);
				memberInfo.setSjMobile(sjMobile);
				memberInfo.setYxEmail(yxEmail);
				ControllerUtils.setUserInfo(request, memberInfo);
				return BaseResult.sucessInstance().setMsg("修改成功！");
			}else{
				return BaseResult.exceptionInstance();
			}
			
		} catch (Exception e) {
			logger.error("用户"+hyCode+"修改资料异常"+e);
			return BaseResult.exceptionInstance();
		}
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	@RequestMapping(value="/doModifyPwd.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult modifyPwd(String hyCode,String yjPwd,String confimYjPwd,String ejPwd,String confirmEjPwd,HttpServletRequest request){
		try {
			if(StringUtils.isEmpty(hyCode,yjPwd,confimYjPwd,ejPwd,confirmEjPwd))return BaseResult.conditionErrorInstance();
			if(!yjPwd.equals(confimYjPwd))return BaseResult.failedInstance("一级密码不一致，请重新输入！");
			if(!ejPwd.equals(confirmEjPwd))return BaseResult.failedInstance("二级密码不一致，请重新输入！");
			int num =  personService.modifyPwd(hyCode,yjPwd,ejPwd);
			if(num>0){
				//设置session信息
				MemberInfo memberInfo = ControllerUtils.getUserInfo(request);
				memberInfo.setYjPwd(yjPwd);
				memberInfo.setEjPwd(ejPwd);
				ControllerUtils.setUserInfo(request, memberInfo);
				return BaseResult.sucessInstance();
			}else{return BaseResult.exceptionInstance();}
		} catch (Exception e) {
			logger.error("用户"+hyCode+"更新密码失败"+e);
			return BaseResult.exceptionInstance();
		}
		
	}
	/**
	 * 查看界面，根据当前登录人(推荐人)查询推荐的所有人信息
	 * @param hyCode
	 * @param currentPage
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getMemeberList.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult getMemberInfo(String hyCode,int jhStatus,int currentPage,HttpServletRequest request){
		try {
			String tjMan = ControllerUtils.getUserInfo(request).getHyCode();//推荐人
			return personService.getMemberInfo(tjMan, currentPage, hyCode,jhStatus);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("分页获取推荐会员列表失败，当前会员编号：",ControllerUtils.getUserInfo(request).getHyCode(),",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
}
