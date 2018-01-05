package com.zhw.service;

import com.zhw.domain.MemberScoreInfo;

public interface LoginInterceptorService {
	
	MemberScoreInfo queryScoreInfo(String hyCode);
}
