package com.zhw.domain;

/**
 * 对应数据表字段
 * PK_ID, AREA_TYPE, TOUR_ITEM, CREATE_MAN, CREATE_TIME
 * @author 张三
 *
 */
public class TourItem {
	private Integer pkId;
	
	private Integer areaType;//地域类型，1表示国内，2表示国外
	
	private String tourItem;//旅游行程项目
	
	private String createMan;//创建人工号
	
	private String createTime;//创建时间

	//以下为非数据库字段
	private String areaTypeName;
	
	public Integer getPkId() {
		return pkId;
	}

	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}

	public String getTourItem() {
		return tourItem;
	}

	public void setTourItem(String tourItem) {
		this.tourItem = tourItem;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAreaTypeName() {
		return areaTypeName;
	}

	public void setAreaTypeName(String areaTypeName) {
		this.areaTypeName = areaTypeName;
	}

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}
	
	
}
