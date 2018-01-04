package com.zhw.mapper;

import java.util.List;

import com.zhw.domain.MemberScoreInfo;

public interface MemberScoreInfoMapper {
	//通过会员编号获取对应的积分信息
	MemberScoreInfo selectScoreInfoByCode(String hyCode);
	
	//插入新的积分信息
	int insertNewScoreInfo(MemberScoreInfo scoreInfo);
	
	//更新会员积分信息
	int updateScoreInfo(MemberScoreInfo scoreInfo);
	//查询积分互转记录
	List<MemberScoreInfo> queryInfoByHycode(String hycode);
}
