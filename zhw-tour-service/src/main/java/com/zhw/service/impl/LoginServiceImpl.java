package com.zhw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhw.domain.MemberInfo;
import com.zhw.mapper.MemberInfoMapper;
import com.zhw.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	private MemberInfoMapper userInfoMapper;
	
	@Override
	public MemberInfo checkLogin(String hyCode, String password) throws Exception {
		return userInfoMapper.selectForLogin(hyCode, password);
	}

	@Override
	public boolean isHyExsists(String hyCode) throws Exception {
		return userInfoMapper.selectCountByHyCode(hyCode) > 0;
	}

	@Override
	public boolean changePwd(String hyCode, String pwd) throws Exception {
		return userInfoMapper.updatePwdByHyCode(hyCode, pwd) > 0;
	}
}
