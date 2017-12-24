package com.zhw.mapper;

import com.zhw.domain.MemberBankInfo;

public interface MemberBankInfoMapper {
	
	//插入会员银行卡信息
	int insertNewBankInfo(MemberBankInfo bankInfo);
}
