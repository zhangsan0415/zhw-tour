package com.zhw.domain;

/**
 * 会员信息表ZHW_MEM
 * @author zsl
 *
 */
public class MemberInfo {

	private int pkId;
	
	private String fwCenter;//所属服务中心
	
	private String tjMan;//推荐人
	
	private String jdMan;//接点人
	
	private String hyCode;//会员编号
	
	private int zyArea; //所属区域，左区或者右区，0为左区，1为右区
	
	private String yjPwd;//一级密码,登录时使用
	
	private String ejPwd;//二级密码，积分操作时需要二给密码
	
	private String sfzCardCode;//身份证号码
	
	private String yxEmail;//邮箱
	
	private String sjMobile;//手机号
	
	private int hyLevel;//申请级别，1为普通会员，2为金卡代理，3为钻石代理
	
	private String zcTime;//注册时间
	
	private int jhStatus;//激活状态，0为已激活，1为未激活
	
	private String ktTime;//开通时间，审批时间
	
	private String xgTime;//修改时间
	
	private int ifAdmin;// 是否报单中心，是的都为管理员，0为是，1 为否

	public int getPkId() {
		return pkId;
	}

	public void setPkId(int pkId) {
		this.pkId = pkId;
	}

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

	public String getEjPwd() {
		return ejPwd;
	}

	public void setEjPwd(String ejPwd) {
		this.ejPwd = ejPwd;
	}

	public String getSfzCardCode() {
		return sfzCardCode;
	}

	public void setSfzCardCode(String sfzCardCode) {
		this.sfzCardCode = sfzCardCode;
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

	public String getZcTime() {
		return zcTime;
	}

	public void setZcTime(String zcTime) {
		this.zcTime = zcTime;
	}

	public int getJhStatus() {
		return jhStatus;
	}

	public void setJhStatus(int jhStatus) {
		this.jhStatus = jhStatus;
	}

	public String getKtTime() {
		return ktTime;
	}

	public void setKtTime(String ktTime) {
		this.ktTime = ktTime;
	}

	public String getXgTime() {
		return xgTime;
	}

	public void setXgTime(String xgTime) {
		this.xgTime = xgTime;
	}

	public int getIfAdmin() {
		return ifAdmin;
	}

	public void setIfAdmin(int ifAdmin) {
		this.ifAdmin = ifAdmin;
	}

	public int getHyLevel() {
		return hyLevel;
	}

	public void setHyLevel(int hyLevel) {
		this.hyLevel = hyLevel;
	}
	
	
	
}
