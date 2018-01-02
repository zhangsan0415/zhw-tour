package com.zhw.domain;

import java.math.BigDecimal;

/**
 * 会员积分表ZHW_MEM_SCORE
 * @author zsl
 *
 */
public class MemberScoreInfo {
	private String hyCode;//会员编号(借方)
	
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
	/**
	 * 积分互转字段（4个）
	 */
	private String zzType;//转账类型

	private String zzTime;//互转时间
	
	private String dfCode;//贷方会员编号
	
	private BigDecimal zzMoney;//金额
	

	public BigDecimal getZzMoney() {
		return zzMoney;
	}

	public void setZzMoney(BigDecimal zzMoney) {
		this.zzMoney = zzMoney;
	}

	//用于显示使用的字段
	private String hyLevelName;
	
	//用于计算碰撞积分
	private String tjMan;
	

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

	public String getHyLevelName() {
		return hyLevelName;
	}

	public void setHyLevelName(String hyLevelName) {
		this.hyLevelName = hyLevelName;
	}

	public String getTjMan() {
		return tjMan;
	}

	public void setTjMan(String tjMan) {
		this.tjMan = tjMan;
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

}
