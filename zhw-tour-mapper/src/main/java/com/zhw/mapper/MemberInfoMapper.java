package com.zhw.mapper;

import com.zhw.domain.MemberInfo;

public interface MemberInfoMapper {

	//登录时通过用户名密码查询用户
	MemberInfo selectForLogin(String hyCode,String yjPwd);
	
	//验证会员编号是否存在时查询指定会员编号的会员个数
	int selectCountByHyCode(String hyCode);
	
	//修改指定会员密码为指定密码
	int updatePwdByHyCode(String hyCode,String pwd);
}
