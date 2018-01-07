package com.zhw.type;

public enum SexEnum {
	MAN(0,"男"),WOMAN(1,"女");
	
	private int typeCode;
	
	private String typeName;
	
	private SexEnum(int typeCode,String typeName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
	}
	
	public int getTypeCode() {
		return typeCode;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public static String getNameByCode(int typeCode) {
		for(SexEnum obj:values()) {
			if(obj.typeCode == typeCode)	return obj.typeName;
		}
		return null;
	}
}
