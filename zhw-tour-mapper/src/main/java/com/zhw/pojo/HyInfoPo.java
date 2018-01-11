package com.zhw.pojo;

public class HyInfoPo {
	private String fwCenter;//所属服务中心
	
	private String tjMan;//推荐人

	private String jdMan;//接点人

	private String hyCode;//会员编号

	private int zyArea; //所属区域，左区或者右区，0为左区，1为右区

	private String yjPwd;//一级密码,登录时使用

	private String confimYjPwd;//确认一级密码
	
	private String ejPwd;//二级密码，积分操作时需要二给密码

	private String confirmEjPwd;//确认二级密码
	
	private String sfzCardCode;//身份证号码

	private String khBankName;//开户银行名称

	private String khCardCode;//银行卡号
	
	private String khName;//开户人姓名
	
	private String khProvince;//开户省份
	
	private String khCity;//开户城市

	private String yxEmail;//邮箱

	private String sjMobile;//手机号

	private int hyLevel;//申请级别，1为普通会员，2为金卡代理，3为钻石代理

	public String getFwCenter() {
		return fwCenter;
	}

	public void setFwCenter(String fwCenter) {
		this.fwCenter = fwCenter;
	}

	public String getTjMan() {
		return tjMan;
	}

	public void setTjMan(String tjMan) {
		this.tjMan = tjMan;
	}

	public String getJdMan() {
		return jdMan;
	}

	public void setJdMan(String jdMan) {
		this.jdMan = jdMan;
	}

	public String getHyCode() {
		return hyCode;
	}

	public void setHyCode(String hyCode) {
		this.hyCode = hyCode;
	}

	public int getZyArea() {
		return zyArea;
	}

	public void setZyArea(int zyArea) {
		this.zyArea = zyArea;
	}

	public String getYjPwd() {
		return yjPwd;
	}

	public void setYjPwd(String yjPwd) {
		this.yjPwd = yjPwd;
	}

	public String getConfimYjPwd() {
		return confimYjPwd;
	}

	public void setConfimYjPwd(String confimYjPwd) {
		this.confimYjPwd = confimYjPwd;
	}

	public String getEjPwd() {
		return ejPwd;
	}

	public void setEjPwd(String ejPwd) {
		this.ejPwd = ejPwd;
	}

	public String getConfirmEjPwd() {
		return confirmEjPwd;
	}

	public void setConfirmEjPwd(String confirmEjPwd) {
		this.confirmEjPwd = confirmEjPwd;
	}

	public String getSfzCardCode() {
		return sfzCardCode;
	}

	public void setSfzCardCode(String sfzCardCode) {
		this.sfzCardCode = sfzCardCode;
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

	public String getYxEmail() {
		return yxEmail;
	}

	public void setYxEmail(String yxEmail) {
		this.yxEmail = yxEmail;
	}

	public String getSjMobile() {
		return sjMobile;
	}

	public void setSjMobile(String sjMobile) {
		this.sjMobile = sjMobile;
	}

	public int getHyLevel() {
		return hyLevel;
	}

	public void setHyLevel(int hyLevel) {
		this.hyLevel = hyLevel;
	}
	
	

}
