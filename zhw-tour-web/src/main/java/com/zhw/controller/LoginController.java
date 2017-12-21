package com.zhw.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.zhw.domain.MemberInfo;
import com.zhw.response.BaseResult;
import com.zhw.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhw.service.LoginService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private LoginService loginService;
	
	
	@RequestMapping("/index.do")
	public String index() {
		return "login";
	}

	/**
	 * 登录操作
	 * @param memberCode
	 * @param password
     * @return
     */
	@RequestMapping(value="/doLogin.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult doLogin(String hyCode, String password, String checkCode, HttpServletRequest request){
		if(StringUtils.isEmpty(hyCode,password,checkCode)) return BaseResult.conditionErrorInstance();

		String valideCode = (String) request.getSession().getAttribute("validate_code");
		request.getSession().removeAttribute("validate_code");
		if(!StringUtils.isEqual(valideCode,checkCode)) return BaseResult.failedInstance("验证码错误！");

		try {
			MemberInfo check = loginService.checkLogin(hyCode,password);
			if(check == null) return BaseResult.failedInstance("密码错误！");
			
			//设置session信息
			request.getSession().setAttribute(ControllerUtils.USER_INFO_SESSION_KEY, check);
			return BaseResult.sucessInstance().setMsg("登录成功！");
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("用户",hyCode,"登录失败：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}

	/**
	 * 验证用户（会员编号）名是否存在
	 * @param memberCode
	 * @return
     */
	@RequestMapping("/checkUserName.do")
	@ResponseBody
	public BaseResult checkMemberCode(String hyCode){
		if(StringUtils.isEmpty(hyCode))  return BaseResult.conditionErrorInstance();

		try {
			boolean check = loginService.isHyExsists(hyCode);
			if(!check)	return BaseResult.failedInstance("会员编码不存在！");
			return BaseResult.sucessInstance();
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("用户",hyCode,"验证失败：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	
	/**
	 * 修改用户（会员）密码
	 * @param request
	 * @param pwd
	 * @param confirmPwd
	 * @return
	 */
	@RequestMapping(value="/changePwd.do",method=RequestMethod.POST)
	@ResponseBody
	public BaseResult changePwd(HttpServletRequest request,String pwd,String confirmPwd) {
		if(StringUtils.isEmpty(pwd, confirmPwd))	return BaseResult.conditionErrorInstance();
		
		MemberInfo userInfo = ControllerUtils.getUserInfo(request);
		if(userInfo == null)	return BaseResult.failedInstance("用户已登出，请重新登录！");
		
		try {
			boolean isChanged = loginService.changePwd(userInfo.getHyCode(), pwd);
			if(!isChanged) return BaseResult.failedInstance("修改密码失败，请稍候重试！");
			return BaseResult.sucessInstance();
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("用户",userInfo.getHyCode(),"修改密码失败：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		} 
	}
	
	
	@RequestMapping(value="/forgetPwd.do")
	public String forgetPwd() {
		return "forgetPwd";
	}
	
	
}
