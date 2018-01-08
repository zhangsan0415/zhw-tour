package com.zhw.type;

public enum InnerTourTypeEnum {
	BJ_TJ_FOUR_THREE(1,"北京+天津4天3晚"),YN_SIX_FIVE(2,"云南6天5晚常规"),HN_FIVE_FOUR(3,"海南5天4晚");
	
	private int typeCode;
	
	private String typeName;
	
	private InnerTourTypeEnum(int typeCode,String typeName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
	}
	
	public int getTypeCode() {
		return this.typeCode;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public static String getNameByCode(int typeCode) {
		for(InnerTourTypeEnum obj:values()) {
			if(obj.typeCode == typeCode)	return obj.typeName;
		}
		return null;
	}
}
