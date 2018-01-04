package com.zhw.controller;

import javax.servlet.http.HttpServletRequest;

import com.zhw.domain.MemberInfo;
import com.zhw.domain.MemberScoreInfo;

public class ControllerUtils {

	public static final String USER_INFO_SESSION_KEY = "userInfo";
	
	public static final String USER_SCORE_SESSION_KEY = "scoreInfo";
	
	public static MemberInfo getUserInfo(HttpServletRequest request) {
		return (MemberInfo)request.getSession().getAttribute(USER_INFO_SESSION_KEY);
	}
	
	public static void setUserInfo(HttpServletRequest request,MemberInfo obj) {
		request.getSession().setAttribute(USER_INFO_SESSION_KEY, obj);
	}
	
	public static void removeUserInfo(HttpServletRequest request) {
		request.getSession().removeAttribute(USER_INFO_SESSION_KEY);
		request.getSession().removeAttribute(USER_SCORE_SESSION_KEY);
	}
	
	public static MemberScoreInfo getScoreInfo(HttpServletRequest request) {
		return (MemberScoreInfo)request.getSession().getAttribute(USER_SCORE_SESSION_KEY);
	}
	public static void setScoreInfo(HttpServletRequest request,MemberScoreInfo obj) {
		request.getSession().setAttribute(USER_SCORE_SESSION_KEY, obj);
	}
	
	public static boolean isNotLoggedIn(HttpServletRequest request) {
		return getUserInfo(request) == null;
	}
}
