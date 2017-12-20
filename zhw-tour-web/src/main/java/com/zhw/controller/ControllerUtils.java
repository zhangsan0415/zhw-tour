package com.zhw.controller;

import javax.servlet.http.HttpServletRequest;

import com.zhw.domain.MemberInfo;

public class ControllerUtils {

	public static final String USER_INFO_SESSION_KEY = "userInfo";
	
	
	public static MemberInfo getUserInfo(HttpServletRequest request) {
		return (MemberInfo)request.getSession().getAttribute(USER_INFO_SESSION_KEY);
	}
	
	public static boolean isNotLoggedIn(HttpServletRequest request) {
		return getUserInfo(request) == null;
	}
}
