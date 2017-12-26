package com.zhw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhw.domain.MemberInfo;
import com.zhw.domain.MemberScoreInfo;
import com.zhw.mapper.MemberInfoMapper;
import com.zhw.mapper.MemberScoreInfoMapper;
import com.zhw.service.LoginService;
import com.zhw.type.HyLevelEnum;

@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	private MemberInfoMapper userInfoMapper;
	
	@Resource
	private MemberScoreInfoMapper scoreInfoMapper;
	
	@Override
	public MemberInfo checkLogin(String hyCode, String password) throws Exception {
		return userInfoMapper.selectForLogin(hyCode, password);
	}

	@Override
	public boolean isHyExsists(String hyCode) throws Exception {
		return userInfoMapper.selectCountByHyCode(hyCode) > 0;
	}

	@Override
	public MemberScoreInfo getScoreInfoByHyCode(String hyCode) throws Exception {
		MemberScoreInfo obj = scoreInfoMapper.selectScoreInfoByCode(hyCode);
		obj.setHyLevelName(HyLevelEnum.getNameByCode(obj.getHyLevel()));
		return obj;
	}
}
