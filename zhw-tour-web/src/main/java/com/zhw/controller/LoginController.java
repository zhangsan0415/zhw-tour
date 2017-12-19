package com.zhw.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhw.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource
	private LoginService loginService;
	
	
	@RequestMapping("/index.do")
	public String index() {
		return "login";
	}
	
}
