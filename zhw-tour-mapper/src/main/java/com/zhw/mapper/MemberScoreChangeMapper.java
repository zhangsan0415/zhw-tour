package com.zhw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhw.domain.MemberScoreChangeInfo;


public interface MemberScoreChangeMapper {

	//查询积分互转记录,积分提现记录
	List<MemberScoreChangeInfo> queryInfoByHycode(@Param("hyCode")String hycode,@Param("zzStatus")int status,@Param("start")int start,@Param("pageSize")int pageSize);
	
	//积分操作插入
	int insertScoreInfo(MemberScoreChangeInfo info);
	
	int selectCount(@Param("hyCode")String hycode,@Param("zzStatus")int status);
	
	//积分提现、充值管理查询
	List<MemberScoreChangeInfo>	queryScoreByAdmin(@Param("hyCode")String hycode,@Param("zzStatus")int status,@Param("txStatus")String txStatus,
			@Param("czStatus")String czStatus,@Param("start")int start,@Param("pageSize")int pageSize);
	
	//积分 提现、充值删除
	int delScoreByAnmin(String pkId);
	
	//积分提现确认
	int conWithdrawByAnmin(String pkId);
	
	//积分充值确认
	int conRechargeByAnmin(String pkId);
	//根据主键查询信息
	MemberScoreChangeInfo queryInfo(String pkId);
}
