package com.zhw.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.zhw.controller.ControllerUtils;
import com.zhw.domain.MemberInfo;

public class LoginListener implements HttpSessionAttributeListener{

	private Map<String,HttpSession> map = new HashMap<>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = event.getName();
		if(ControllerUtils.USER_INFO_SESSION_KEY.equals(name)) {
			MemberInfo info = (MemberInfo)event.getValue();
			HttpSession session = map.get(info.getHyCode());
			if(session != null) {
				session.removeAttribute(ControllerUtils.USER_INFO_SESSION_KEY);
				session.removeAttribute(ControllerUtils.USER_SCORE_SESSION_KEY);
				session.invalidate();
			}
			
			map.put(info.getHyCode(), event.getSession());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name = event.getName();
		
		if(ControllerUtils.USER_INFO_SESSION_KEY.equals(name)) {
			MemberInfo info = (MemberInfo)event.getValue();
			map.remove(info.getHyCode());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
