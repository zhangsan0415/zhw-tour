package com.zhw.type;

/**
 * 是否为报单中心枚举
 * @author zsl
 *
 */
public enum IfBdCenterEnum {
	Y_BD_CENTER(0,"是","已为报单中心"),N_BD_CENTER(1,"否","尚未开通报单中心"),WILL_BD_CENTER(2,"申请中","正在申请中");
	
	private int typeCode;
	
	private String typeName;
	
	private String tagName;
	
	private IfBdCenterEnum(int typeCode,String typeName,String tagName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
		this.tagName = tagName;
	}
	
	public String getTagName() {
		return this.tagName;
	}
	
	public int getTypeCode() {	return this.typeCode;	}
	
	public String getTypeName() {	return this.typeName;	}
	
	public static String getNameByCode(int typeCode) {
		for(IfBdCenterEnum obj:values()) {
			if(obj.typeCode == typeCode)	return obj.typeName;
		}
		return null;
	}
	
	public static String getTagByCode(int typeCode) {
		for(IfBdCenterEnum obj:values()) {
			if(obj.typeCode == typeCode)	return obj.tagName;
		}
		return null;
	}
	public static boolean checkTypeCode(int typeCode) {
		for(IfBdCenterEnum obj:values()) {
			if(obj.typeCode == typeCode)	return true;
		}
		return false;
	}

	public static boolean isBdCenter(int typeCode){
		return Y_BD_CENTER.getTypeCode() == typeCode;
	}
}


