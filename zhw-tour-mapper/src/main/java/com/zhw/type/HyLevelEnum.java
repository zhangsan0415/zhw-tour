package com.zhw.type;

/**
 * 会员级别
 * @author zsl
 *
 */
public enum HyLevelEnum {
	PROXY_HY(1,"普通代理商"),GOLD_HY(2,"金卡代理商"),DIAMOND_HY(3,"钻石代理商");
	
	private int typeCode;
	private String typeName;
	
	private HyLevelEnum(int levelCode,String levelName) {
		this.typeCode = levelCode;
		this.typeName = levelName;
	}
	
	public int getLevelCode() {	return this.typeCode;	}
	
	public String getLevelName() {	return this.typeName;	}
	
	public static String getNameByCode(int code) {
		for(HyLevelEnum obj:values()) {
			if(obj.typeCode == code)	return obj.typeName;
		}
		return null;
	}
	
	public static boolean checkTypeCodeOk(int typeCode) {
		for(HyLevelEnum obj:values()) {
			if(obj.typeCode == typeCode)	return true;
		}
		return false;
	}

	public static boolean isCanBeBdCenter(int typeCode){
		return PROXY_HY.getLevelCode() != typeCode;
	}
	
}
