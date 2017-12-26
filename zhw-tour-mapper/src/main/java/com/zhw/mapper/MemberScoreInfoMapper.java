package com.zhw.mapper;

import com.zhw.domain.MemberScoreInfo;

public interface MemberScoreInfoMapper {
	//通过会员编号获取对应的积分信息
	MemberScoreInfo selectScoreInfoByCode(String hyCode);
	
	//通过推荐人编码获取推荐人积分信息
	MemberScoreInfo selectTjScoreInfoByTjCode(String tjCode);
	
	//插入新的积分信息
	int insertNewScoreInfo(MemberScoreInfo scoreInfo);
	
	//更新会员积分信息
	int updateScoreInfo(MemberScoreInfo scoreInfo);
}
