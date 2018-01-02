package com.zhw.domain;

public class MemberScoreInfoDetail {

	private int pkId;
	
	private String hyCode;//会员编码
	
	private int scScore;//市场积分
	
	private int ywScore;//业务积分

	private int geScore;//感恩积分
	
	private int bzScore;//补助积分
	
	private int glScore;//管理积分

	private int dhScore;//兑换积分
	
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
	public int getScScore() {
		return scScore;
	}
	public void setScScore(int scScore) {
		this.scScore = scScore;
	}
	public int getYwScore() {
		return ywScore;
	}
	public void setYwScore(int ywScore) {
		this.ywScore = ywScore;
	}
	public int getGeScore() {
		return geScore;
	}
	public void setGeScore(int geScore) {
		this.geScore = geScore;
	}
	public int getBzScore() {
		return bzScore;
	}
	public void setBzScore(int bzScore) {
		this.bzScore = bzScore;
	}
	public int getGlScore() {
		return glScore;
	}
	public void setGlScore(int glScore) {
		this.glScore = glScore;
	}
	public int getDhScore() {
		return dhScore;
	}
	public void setDhScore(int dhScore) {
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
