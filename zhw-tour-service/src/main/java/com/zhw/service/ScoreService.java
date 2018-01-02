package com.zhw.service;

import java.math.BigDecimal;
import java.util.List;

import com.zhw.domain.MemberScoreInfo;

public interface ScoreService {

	/**
	 * 根据会员编号查询数据（借方或贷方是当前登录人）
	 * @param hyCode
	 * @return
	 */
	List<MemberScoreInfo> queryInfo(String hyCode);
	
	/**
	 * 确认转账（积分互转）
	 * @param hyCode 贷方（当前登录人）
	 * @param dfCode 借方
	 * @param type  转账类型
	 * @param money 金额
	 * @return
	 */
	MemberScoreInfo zzScore(MemberScoreInfo info)throws Exception;
}
