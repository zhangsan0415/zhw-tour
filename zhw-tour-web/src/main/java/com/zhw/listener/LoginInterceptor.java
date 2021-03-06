package com.zhw.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhw.controller.ControllerUtils;
import com.zhw.domain.MemberInfo;
import com.zhw.domain.MemberScoreInfo;
import com.zhw.service.LoginInterceptorService;
import com.zhw.type.HyLevelEnum;
import com.zhw.utils.StringUtils;

public class LoginInterceptor implements HandlerInterceptor{

	private static String[] IGNORE_URIS = {"/login/index.do","/login/checkHyCode.do","/login/createCheckCode.do","/login/doLogin.do","/login/forgetPwd.do"};
	
	private LoginInterceptorService loginInterceptorService;
	
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
		
		//时时更新积分信息
		MemberScoreInfo scoreInfo = loginInterceptorService.queryScoreInfo(memberInfo.getHyCode());
		scoreInfo.setHyLevelName(HyLevelEnum.getNameByCode(scoreInfo.getHyLevel()));
		ControllerUtils.setScoreInfo(request, scoreInfo);
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

	public LoginInterceptorService getLoginInterceptorService() {
		return loginInterceptorService;
	}

	public void setLoginInterceptorService(LoginInterceptorService loginInterceptorService) {
		this.loginInterceptorService = loginInterceptorService;
	}

}
