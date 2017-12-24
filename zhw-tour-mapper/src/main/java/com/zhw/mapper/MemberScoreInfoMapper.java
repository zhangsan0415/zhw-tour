package com.zhw.mapper;

import com.zhw.domain.MemberScoreInfo;

public interface MemberScoreInfoMapper {
	MemberScoreInfo selectScoreInfoByCode(String hyCode);
}
