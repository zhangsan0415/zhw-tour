package com.zhw.domain;

import java.math.BigDecimal;

/**
 * 会员积分表ZHW_MEM_SCORE
 * @author zsl
 *
 */
public class MemberScoreInfo {
	private String hyCode;//会员编号
	
	private int tjCount;//推荐人数
	
	private int hyLevel;//会员级别，1表示普通会员，2金卡代理，3钻石代理
	
	private int ifAdmin;//是否报单中心，0表示是，1表示否
	
	private BigDecimal ljTotalScore;//累计总积分
	
	private BigDecimal jjScore;//奖金积分
	
	private BigDecimal xjScore;//现金积分
	
	private BigDecimal lyScore;//旅游积分
	
	private BigDecimal gwScore;//购物积分
	
	private BigDecimal bdScore;//报单积分
	
	private BigDecimal pdBalance;//碰对后剩余积分
	
	private int pdOverArea;//碰对后剩余区域，0为左区，1为右区
	
	private String gxTime;//更新时间

	public String getHyCode() {
		return hyCode;
	}

	public void setHyCode(String hyCode) {
		this.hyCode = hyCode;
	}

	public int getTjCount() {
		return tjCount;
	}

	public void setTjCount(int tjCount) {
		this.tjCount = tjCount;
	}

	public int getHyLevel() {
		return hyLevel;
	}

	public void setHyLevel(int hyLevel) {
		this.hyLevel = hyLevel;
	}

	public int getIfAdmin() {
		return ifAdmin;
	}

	public void setIfAdmin(int ifAdmin) {
		this.ifAdmin = ifAdmin;
	}

	public BigDecimal getLjTotalScore() {
		return ljTotalScore;
	}

	public void setLjTotalScore(BigDecimal ljTotalScore) {
		this.ljTotalScore = ljTotalScore;
	}

	public BigDecimal getJjScore() {
		return jjScore;
	}

	public void setJjScore(BigDecimal jjScore) {
		this.jjScore = jjScore;
	}

	public BigDecimal getXjScore() {
		return xjScore;
	}

	public void setXjScore(BigDecimal xjScore) {
		this.xjScore = xjScore;
	}

	public BigDecimal getLyScore() {
		return lyScore;
	}

	public void setLyScore(BigDecimal lyScore) {
		this.lyScore = lyScore;
	}

	public BigDecimal getGwScore() {
		return gwScore;
	}

	public void setGwScore(BigDecimal gwScore) {
		this.gwScore = gwScore;
	}

	public BigDecimal getBdScore() {
		return bdScore;
	}

	public void setBdScore(BigDecimal bdScore) {
		this.bdScore = bdScore;
	}

	public BigDecimal getPdBalance() {
		return pdBalance;
	}

	public void setPdBalance(BigDecimal pdBalance) {
		this.pdBalance = pdBalance;
	}

	public int getPdOverArea() {
		return pdOverArea;
	}

	public void setPdOverArea(int pdOverArea) {
		this.pdOverArea = pdOverArea;
	}

	public String getGxTime() {
		return gxTime;
	}

	public void setGxTime(String gxTime) {
		this.gxTime = gxTime;
	}
	
	
	
	
}
