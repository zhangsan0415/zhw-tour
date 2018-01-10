package com.zhw.service;

import com.zhw.domain.MemberScoreChangeInfo;
import com.zhw.domain.MemberScoreInfo;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;

public interface ScoreService {

	/**
	 * 根据会员编号查询数据（借方或贷方是当前登录人）
	 * @param hyCode
	 * @return
	 */
	PageResult queryInfo(String hyCode,int status,int currentPage)throws Exception;
	
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
	/**
	 * 积分充值
	 * @param info
	 * @param scoreInfo
	 * @return
	 * @throws Exception
	 */
	BaseResult rechargeScore(MemberScoreInfo info,MemberScoreChangeInfo scoreInfo)throws Exception;
}
