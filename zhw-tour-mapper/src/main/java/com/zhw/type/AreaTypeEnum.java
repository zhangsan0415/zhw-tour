package com.zhw.type;

public enum AreaTypeEnum {
	INNER(1,"国内"),OUTER(2,"国外");
	
	private int typeCode;
	
	private String typeName;
	
	private AreaTypeEnum(int typeCode,String typeName) {
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
		for(AreaTypeEnum obj:values()) {
			if(obj.typeCode == typeCode)	return obj.typeName;
		}
		return null;
	}
}
