package com.zhw.domain;

public class BdApply {
	
	private String hyCode;
	
	private String sqTime;//申请 时间
	
	private String ktTime;//开通报单中心时间
	
	private String hkAmount;//汇款金额
	
	private String hkAccount;//汇款帐户
	
	private String hkTime;//汇款时间
	
	private String comment;//备注
	
	private Integer ifBdCenter;//是否报单中心

	public String getHyCode() {
		return hyCode;
	}

	public void setHyCode(String hyCode) {
		this.hyCode = hyCode;
	}

	public String getSqTime() {
		return sqTime;
	}

	public void setSqTime(String sqTime) {
		this.sqTime = sqTime;
	}

	public String getKtTime() {
		return ktTime;
	}

	public void setKtTime(String ktTime) {
		this.ktTime = ktTime;
	}

	public String getHkAmount() {
		return hkAmount;
	}

	public void setHkAmount(String hkAmount) {
		this.hkAmount = hkAmount;
	}

	public String getHkAccount() {
		return hkAccount;
	}

	public void setHkAccount(String hkAccount) {
		this.hkAccount = hkAccount;
	}

	public String getHkTime() {
		return hkTime;
	}

	public void setHkTime(String hkTime) {
		this.hkTime = hkTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getIfBdCenter() {
		return ifBdCenter;
	}

	public void setIfBdCenter(Integer ifBdCenter) {
		this.ifBdCenter = ifBdCenter;
	}
	
	
}
