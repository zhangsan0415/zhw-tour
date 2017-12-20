package com.zhw.domain;

import java.math.BigDecimal;

/**
 * 旅游报名表ZHW_TOUR_REG
 * @author zsl
 *
 */
public class TourRegisterInfo {

	private int pkId;
	
	private String bmName;//姓名
	
	private String bmCardCode;//身份证号码
	
	private int bmSex;//性别，0表示男，1表示女
	
	private String bmHjAddress;//户藉
	
	private String bmCarCode;//航班号/列车号
	
	private String bmPhone;//电话
	
	private BigDecimal bmPrice;//收费
	
	private String bmComment;//备注

	public int getPkId() {
		return pkId;
	}

	public void setPkId(int pkId) {
		this.pkId = pkId;
	}

	public String getBmName() {
		return bmName;
	}

	public void setBmName(String bmName) {
		this.bmName = bmName;
	}

	public String getBmCardCode() {
		return bmCardCode;
	}

	public void setBmCardCode(String bmCardCode) {
		this.bmCardCode = bmCardCode;
	}

	public int getBmSex() {
		return bmSex;
	}

	public void setBmSex(int bmSex) {
		this.bmSex = bmSex;
	}

	public String getBmHjAddress() {
		return bmHjAddress;
	}

	public void setBmHjAddress(String bmHjAddress) {
		this.bmHjAddress = bmHjAddress;
	}

	public String getBmCarCode() {
		return bmCarCode;
	}

	public void setBmCarCode(String bmCarCode) {
		this.bmCarCode = bmCarCode;
	}

	public String getBmPhone() {
		return bmPhone;
	}

	public void setBmPhone(String bmPhone) {
		this.bmPhone = bmPhone;
	}

	public BigDecimal getBmPrice() {
		return bmPrice;
	}

	public void setBmPrice(BigDecimal bmPrice) {
		this.bmPrice = bmPrice;
	}

	public String getBmComment() {
		return bmComment;
	}

	public void setBmComment(String bmComment) {
		this.bmComment = bmComment;
	}
	
}
