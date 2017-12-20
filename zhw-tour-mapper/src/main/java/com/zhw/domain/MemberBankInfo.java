package com.zhw.domain;

/**
 * 会员银行卡信息表ZHW_MEM_BANK
 * @author zsl
 *
 */
public class MemberBankInfo {
	
	private int pkId;
	
	private String hyCode;//会员编号
	
	private String khBankName;//开户银行名称
	
	private String khCardCode;//银行卡号
	
	private String khName;//开户人姓名
	
	private String khProvince;//开户省份
	
	private String khCity;//开户城市
	
	private String khSfCardCode;//开户身份证号码
	
	private String cjTime;//创建时间
	
	private String xgTime;//修改时间
	
	private int ifDisabled;//是否作废，1为是，0为否

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

	public String getKhBankName() {
		return khBankName;
	}

	public void setKhBankName(String khBankName) {
		this.khBankName = khBankName;
	}

	public String getKhCardCode() {
		return khCardCode;
	}

	public void setKhCardCode(String khCardCode) {
		this.khCardCode = khCardCode;
	}

	public String getKhName() {
		return khName;
	}

	public void setKhName(String khName) {
		this.khName = khName;
	}

	public String getKhProvince() {
		return khProvince;
	}

	public void setKhProvince(String khProvince) {
		this.khProvince = khProvince;
	}

	public String getKhCity() {
		return khCity;
	}

	public void setKhCity(String khCity) {
		this.khCity = khCity;
	}

	public String getKhSfCardCode() {
		return khSfCardCode;
	}

	public void setKhSfCardCode(String khSfCardCode) {
		this.khSfCardCode = khSfCardCode;
	}

	public String getCjTime() {
		return cjTime;
	}

	public void setCjTime(String cjTime) {
		this.cjTime = cjTime;
	}

	public String getXgTime() {
		return xgTime;
	}

	public void setXgTime(String xgTime) {
		this.xgTime = xgTime;
	}

	public int getIfDisabled() {
		return ifDisabled;
	}

	public void setIfDisabled(int ifDisabled) {
		this.ifDisabled = ifDisabled;
	}
	
}
