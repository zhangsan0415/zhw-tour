package com.zhw.domain;

import java.math.BigDecimal;

public class MemberScoreChangeInfo {

	private int pkId;
	
	private String hyCode;//会员编号
	
	private String zzType;//转账类型

	private String zzTime;//互转时间
	
	private String dfCode;//贷方会员编号
	
	private BigDecimal zzMoney;//金额
	
	private int zzStatus;//操作状态（0提现，1互转,2充值）
	
	/*
	 * 用于积分提现显示
	 */
	private String khCardCode;//银行卡号
	
	private BigDecimal realMoney;//实发金额

	private String txStatus;//提现状态，1确认，0未确认
	
	private String czStatus;//充值状态，1确认，0未确认
	
	private int dr;//作废标识
	
	public String getCzStatus() {
		return czStatus;
	}

	public void setCzStatus(String czStatus) {
		this.czStatus = czStatus;
	}

	public int getPkId() {
		return pkId;
	}

	public void setPkId(int pkId) {
		this.pkId = pkId;
	}

	public String getHyCode() {
		return hyCode;
	}

	public void setHyCode(String hyCode) {
		this.hyCode = hyCode;
	}

	public int getZzStatus() {
		return zzStatus;
	}

	public void setZzStatus(int zzStatus) {
		this.zzStatus = zzStatus;
	}

	public BigDecimal getZzMoney() {
		return zzMoney;
	}

	public void setZzMoney(BigDecimal zzMoney) {
		this.zzMoney = zzMoney;
	}
	public String getZzType() {
		return zzType;
	}

	public void setZzType(String zzType) {
		this.zzType = zzType;
	}

	public String getZzTime() {
		return zzTime;
	}

	public void setZzTime(String zzTime) {
		this.zzTime = zzTime;
	}

	public String getDfCode() {
		return dfCode;
	}

	public void setDfCode(String dfCode) {
		this.dfCode = dfCode;
	}
	
	public String getKhCardCode() {
		return khCardCode;
	}

	public void setKhCardCode(String khCardCode) {
		this.khCardCode = khCardCode;
	}

	public BigDecimal getRealMoney() {
		return realMoney;
	}

	public void setRealMoney(BigDecimal realMoney) {
		this.realMoney = realMoney;
	}

	public String getTxStatus() {
		return txStatus;
	}

	public void setTxStatus(String txStatus) {
		this.txStatus = txStatus;
	}

	public int getDr() {
		return dr;
	}

	public void setDr(int dr) {
		this.dr = dr;
	}
}
