package com.zhw.type;

/**
 * 会员级别
 * @author zsl
 *
 */
public enum HyLevelEnum {
	PROXY_HY(1,"普通代理商"),GOLD_HY(2,"金卡代理商"),DIAMOND_HY(3,"钻石代理商");
	
	private int levelCode;
	private String levelName;
	
	private HyLevelEnum(int levelCode,String levelName) {
		this.levelCode = levelCode;
		this.levelName = levelName;
	}
	
	public int getLevelCode() {	return this.levelCode;	}
	
	public String getLevelName() {	return this.levelName;	}
	
	public static String getNameByCode(int code) {
		for(HyLevelEnum obj:values()) {
			if(obj.levelCode == code)	return obj.levelName;
		}
		return null;
	}
	
}
