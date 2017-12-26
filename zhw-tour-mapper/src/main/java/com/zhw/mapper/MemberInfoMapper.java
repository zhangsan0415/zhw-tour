package com.zhw.mapper;

import org.apache.ibatis.annotations.Param;

import com.zhw.domain.MemberInfo;

public interface MemberInfoMapper {

	//登录时通过用户名密码查询用户
	MemberInfo selectForLogin(@Param("hyCode")String hyCode,@Param("yjPwd")String yjPwd);
	
	//验证会员编号是否存在时查询指定会员编号的会员个数
	int selectCountByHyCode(String hyCode);
	
	//插入新的会员信息
	int insertNewHyInfo(MemberInfo obj);
}
