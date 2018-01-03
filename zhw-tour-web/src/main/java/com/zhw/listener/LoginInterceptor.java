package com.zhw.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhw.controller.ControllerUtils;
import com.zhw.domain.MemberInfo;
import com.zhw.utils.StringUtils;

public class LoginInterceptor implements HandlerInterceptor{

	private static String[] IGNORE_URIS = {"/login/index.do","/login/checkHyCode.do","/login/createCheckCode.do","/login/doLogin.do"};
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getServletPath();
		for(String uri:IGNORE_URIS) {
			if(url.contains(uri))	return true;
		}
		
		MemberInfo memberInfo = ControllerUtils.getUserInfo(request);
		if(memberInfo == null)	{
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			response.sendRedirect(StringUtils.putTogether(basePath,"login/index.do"));
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
