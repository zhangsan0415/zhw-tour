package com.zhw.type;

public enum ConfirmStatusEnum {
	CONFIRMED(0,"已确认"),UNCONFIRMED(1,"未确认");
	
	private int typeCode;
	
	private String typeName;
	
	private ConfirmStatusEnum(int typeCode,String typeName) {
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
		for(ConfirmStatusEnum obj:values()) {
			if(obj.typeCode == typeCode)	return obj.typeName;
		}
		return null;
	}
}
