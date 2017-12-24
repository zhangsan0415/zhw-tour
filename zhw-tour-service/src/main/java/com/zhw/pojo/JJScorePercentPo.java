package com.zhw.pojo;

import java.math.BigDecimal;

/**
 * 存放奖励积分时的比例
 * @author zsl
 *
 */
public class JJScorePercentPo {
	
	//直推时奖励比率，相对新注册会员报单积分
	public static final BigDecimal DIRECT_TJ_PERCENT = new BigDecimal("0.1"); 
	
	//开通会员时奖励比率，相对新注册会员报单积分
	public static final BigDecimal ACTIVE_HY_PERCENT = new BigDecimal("0.05");
	
	//碰对时推荐人拿到的奖励比率，相对新注册会员报单积分
	public static final BigDecimal HIT_AREA_PERCENT = new BigDecimal("0.15");
	
	//碰对时直接推荐人第一级上级所拿到的奖励比率，相对直接推荐人所拿到的奖励积分
	public static final BigDecimal HIT_ONE_PERCENT = new BigDecimal("0.5");
	
	//碰对时直接推荐人第二级上级所拿到的奖励比率，相对直接推荐人所拿到的奖励积分
	public static final BigDecimal HIT_TWO_PERCENT = new BigDecimal("0.3");
	
	//碰对时直接推荐人第三级上级所拿到的奖励比率，相对直接推荐人所拿到的奖励积分
	public static final BigDecimal HIT_THREE_PERCENT = new BigDecimal("0.1");
}
