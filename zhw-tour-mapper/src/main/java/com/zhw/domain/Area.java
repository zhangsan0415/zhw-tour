package com.zhw.domain;

/**
 * 地域实体
 * @author zsl
 *
 */
public class Area {
	private String pkId;
	
	private String areaName;
	
	private String parentId;
	
	private int status;//状态，0为启用，1为禁用

	public String getPkId() {
		return pkId;
	}

	public void setPkId(String pkId) {
		this.pkId = pkId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
