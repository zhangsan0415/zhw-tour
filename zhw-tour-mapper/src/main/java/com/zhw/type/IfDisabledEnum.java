package com.zhw.type;

public enum IfDisabledEnum {
	DISABLED(1,"是"),UNDISABLED(0,"否");
	
	private int typeCode;
	private String typeName;
	
	private IfDisabledEnum(int typeCode,String typeName) {
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
		for(IfDisabledEnum obj:values()) {
			if(obj.typeCode == typeCode) 	return obj.typeName;
		}
		return null;
	}
	
	public static boolean checkedOk(int typeCode) {
		for(IfDisabledEnum obj:values()) {
			if(obj.typeCode == typeCode)	return true;
		}
		return false;
	}
	
}
