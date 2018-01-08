package com.zhw.type;

public enum OuterTourTypeEnum {
	GAO_FIVE_FOUR(1,"港澳5天4晚"),GAO_THREE_TWO(2,"港澳纯玩豪华游3天2晚");
	
	private int typeCode;
	
	private String typeName;
	
	private OuterTourTypeEnum(int typeCode,String typeName) {
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
		for(OuterTourTypeEnum obj:values()) {
			if(obj.typeCode == typeCode)	return obj.typeName;
		}
		return null;
	}
}
