package com.zhw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.zhw.domain.MemberScoreChangeInfo;


public interface MemberScoreChangeMapper {

	//查询积分互转记录,积分提现记录
	List<MemberScoreChangeInfo> queryInfoByHycode(@Param("hyCode")String hycode,@Param("zzStatus")int status);
	
	//积分操作插入
	int insertScoreInfo(MemberScoreChangeInfo info);
}
