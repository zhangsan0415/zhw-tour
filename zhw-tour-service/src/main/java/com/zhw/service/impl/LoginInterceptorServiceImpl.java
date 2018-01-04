package com.zhw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhw.domain.MemberScoreInfo;
import com.zhw.mapper.MemberScoreInfoMapper;
import com.zhw.service.LoginInterceptorService;

@Service("loginInterceptorService")
public class LoginInterceptorServiceImpl implements LoginInterceptorService {

	@Autowired
	private MemberScoreInfoMapper scoreInfoMapper;
	
	@Override
	public MemberScoreInfo queryScoreInfo(String hyCode) {
		return scoreInfoMapper.selectScoreInfoByCode(hyCode);
	}

}
