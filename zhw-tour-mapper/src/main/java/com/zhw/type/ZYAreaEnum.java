package com.zhw.type;

/**
 * 所属区域，左右区域
 * @author zsl
 *
 */
public enum ZYAreaEnum {
	LEFT_AREA(0,"左区"),RIGHT_AREA(1,"右区");
	
	private int typeCode;
	private String typeName;
	
	private ZYAreaEnum(int typeCode,String typeName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
	}
	
	public int getTypeCode() {	return this.typeCode;	}
	
	public String getTypeName() {	return this.typeName;	}
	
	public static String getNameByCode(int typeCode) {
		for(ZYAreaEnum obj:values()) {
			if(obj.typeCode == typeCode)	return obj.typeName;
		}
		return null;
	}
	
	public static boolean checkTypeCodeOk(int typeCode) {
		for(ZYAreaEnum obj:values()) {
			if(obj.typeCode == typeCode)	return true;
		}
		return false;
	}
}
