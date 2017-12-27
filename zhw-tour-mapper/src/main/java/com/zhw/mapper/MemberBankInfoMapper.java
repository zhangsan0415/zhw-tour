package com.zhw.mapper;

import com.zhw.domain.MemberBankInfo;

public interface MemberBankInfoMapper {
	
	//插入会员银行卡信息
	int insertNewBankInfo(MemberBankInfo bankInfo);
	
	//修改资料（关于银行的）
	int modifyBankInfo(MemberBankInfo bankInfo);
	//查询银行卡信息
	MemberBankInfo queryBankInfo(String hyCode);
}
