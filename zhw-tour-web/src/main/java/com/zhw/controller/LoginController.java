package com.zhw.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	public BaseResult doLogin(String memberCode, String password, String checkCode, HttpServletRequest request){
		if(StringUtils.isEmpty(memberCode,password,checkCode)) return BaseResult.failedInstance("存在必要条件为空！");

		String valideCode = (String) request.getSession().getAttribute("validate_code");
		request.getSession().removeAttribute("validate_code");
		if(!StringUtils.isEqual(valideCode,checkCode)) return BaseResult.failedInstance("验证码错误！");

		try {
			boolean check = loginService.checkLogin(memberCode,password);
			if(!check) return BaseResult.failedInstance("密码错误！");
			return BaseResult.sucessInstance().setMsg("登录成功！");
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("用户",memberCode,"登录失败：",e.getMessage()),e);
			return BaseResult.failedInstance("系统繁忙，请稍候重试！");
		}
	}

	/**
	 * 验证用户名是否存在
	 * @param memberCode
	 * @return
     */
	@RequestMapping("/checkUserName.do")
	@ResponseBody
	public BaseResult checkMemberCode(String memberCode){
		if(StringUtils.isEmpty(memberCode)) return BaseResult.failedInstance("会员编码不能为空！");

		try {
			boolean check = loginService.checkMemberCode(memberCode);
			if(!check)	return BaseResult.failedInstance("会员编码不存在！");
			return
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
