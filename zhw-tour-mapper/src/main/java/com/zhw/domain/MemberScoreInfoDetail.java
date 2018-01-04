package com.zhw.domain;

import java.math.BigDecimal;

public class MemberScoreInfoDetail {

	private int pkId;
	
	private String hyCode;//会员编码
	
	private BigDecimal scScore;//市场积分
	
	
	private BigDecimal ywScore;//业务积分

	private BigDecimal geScore;//感恩积分
	
	private BigDecimal bzScore;//补助积分
	
	private BigDecimal glScore;//管理积分

	private BigDecimal dhScore;//兑换积分
	
	private String jsTime;//结算时间
	
	private String czCode;//操作人

	private String czTime;//操作时间
	
	private int czMoney;//操作金额
	
	private String czRemark;//操作备注
	
	private int totalScore;//总计
	
	private int sfScore;//实发
	
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
	public BigDecimal getScScore() {
		return scScore;
	}
	public void setScScore(BigDecimal scScore) {
		this.scScore = scScore;
	}
	public BigDecimal getYwScore() {
		return ywScore;
	}
	public void setYwScore(BigDecimal ywScore) {
		this.ywScore = ywScore;
	}
	public BigDecimal getGeScore() {
		return geScore;
	}
	public void setGeScore(BigDecimal geScore) {
		this.geScore = geScore;
	}
	public BigDecimal getBzScore() {
		return bzScore;
	}
	public void setBzScore(BigDecimal bzScore) {
		this.bzScore = bzScore;
	}
	public BigDecimal getGlScore() {
		return glScore;
	}
	public void setGlScore(BigDecimal glScore) {
		this.glScore = glScore;
	}
	public BigDecimal getDhScore() {
		return dhScore;
	}
	public void setDhScore(BigDecimal dhScore) {
		this.dhScore = dhScore;
	}
	public String getJsTime() {
		return jsTime;
	}
	public void setJsTime(String jsTime) {
		this.jsTime = jsTime;
	}
	public String getCzCode() {
		return czCode;
	}
	public void setCzCode(String czCode) {
		this.czCode = czCode;
	}
	public String getCzTime() {
		return czTime;
	}
	public void setCzTime(String czTime) {
		this.czTime = czTime;
	}
	public int getCzMoney() {
		return czMoney;
	}
	public void setCzMoney(int czMoney) {
		this.czMoney = czMoney;
	}
	public String getCzRemark() {
		return czRemark;
	}
	public void setCzRemark(String czRemark) {
		this.czRemark = czRemark;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getSfScore() {
		return sfScore;
	}
	public void setSfScore(int sfScore) {
		this.sfScore = sfScore;
	}

	
	
}
