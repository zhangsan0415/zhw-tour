package com.zhw.controller;

import javax.annotation.Resource;

import com.zhw.response.BaseResult;
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

	@RequestMapping(value="/doLogin.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult doLogin(String memberCode,String password){

		return null;
	}
	
}
