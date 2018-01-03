package com.zhw.service;

import java.util.List;

import com.zhw.domain.MemberScoreChangeInfo;
import com.zhw.domain.MemberScoreInfo;

public interface ScoreService {

	/**
	 * 根据会员编号查询数据（借方或贷方是当前登录人）
	 * @param hyCode
	 * @return
	 */
	List<MemberScoreChangeInfo> queryInfo(String hyCode,int status);
	
	/**
	 * 确认转账（积分互转）
	 * @param hyCode 贷方（当前登录人）
	 * @param dfCode 借方
	 * @param type  转账类型
	 * @param money 金额
	 * @return
	 */
	MemberScoreInfo zzScore(MemberScoreInfo info,MemberScoreChangeInfo scoreInfo)throws Exception;
	
	/**
	 * 积分提现
	 * @param info 积分明细实体类
	 * @param scoreInfo 积分日志实体类
	 * @return
	 * @throws Exception
	 */
	MemberScoreInfo withdrawScore(MemberScoreInfo info,MemberScoreChangeInfo scoreInfo)throws Exception;
}
