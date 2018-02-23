package com.zhw.domain;

import java.math.BigDecimal;

public class BdApply {
	
	private String hyCode;
	
	private String sqTime;//申请 时间
	
	private String ktTime;//开通报单中心时间
	
	private String hkAmount;//汇款金额
	
	private String hkAccount;//汇款帐户
	
	private String hkTime;//汇款时间
	
	private String comment;//备注
	
	private Integer ifBdCenter;//是否报单中心
	
	private Integer hyLevel;//会员级别
	
	private String ifBdCenterName;
	
	private BigDecimal hyAmount;
	
	private String levelName;

	public String getIfBdCenterName() {
		return ifBdCenterName;
	}

	public void setIfBdCenterName(String ifBdCenterName) {
		this.ifBdCenterName = ifBdCenterName;
	}

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

	public Integer getHyLevel() {
		return hyLevel;
	}

	public void setHyLevel(Integer hyLevel) {
		this.hyLevel = hyLevel;
	}

	public BigDecimal getHyAmount() {
		return hyAmount;
	}

	public void setHyAmount(BigDecimal hyAmount) {
		this.hyAmount = hyAmount;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	
}
