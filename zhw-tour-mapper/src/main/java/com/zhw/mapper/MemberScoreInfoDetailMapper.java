package com.zhw.mapper;

import java.util.List;

import com.zhw.domain.MemberScoreInfoDetail;

public interface MemberScoreInfoDetailMapper {

	List<MemberScoreInfoDetail> queryScoreInfoByHyCode(String hyCode);
}
