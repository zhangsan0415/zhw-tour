package com.zhw.type;

import java.math.BigDecimal;

public enum HyLevelScoreEnum {
	PROXY_HY(1,BigDecimal.valueOf(1000)),GOLD_HY(2,BigDecimal.valueOf(5000)),DIAMOND_HY(3,BigDecimal.valueOf(8000));
	
	private int typeCode;
	private BigDecimal typeValue;
	
	private HyLevelScoreEnum(int typeCode,BigDecimal typeValue) {
		this.typeCode = typeCode;
		this.typeValue = typeValue;
	}
	
	public int getTypeCode() {	return this.typeCode;	}
	
	public BigDecimal getTypeValue() {	return this.typeValue;	}
	
	public static BigDecimal getValueByCode(int typeCode) {
		for(HyLevelScoreEnum obj:values()) {
			if(obj.typeCode == typeCode) return obj.typeValue;
		}
		return null;
	}
	
}
