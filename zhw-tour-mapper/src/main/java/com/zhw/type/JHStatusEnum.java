package com.zhw.type;

public enum JHStatusEnum {
	ACTIVED(0,"已开通"),UNACTIVED(1,"未开通"),RECHARGE(2,"积分充值"),ACTIVED_UNFIRMED(3,"已开通未审核");
	
	private int typeCode;
	private String typeName;
	
	private JHStatusEnum(int typeCode,String typeName) {
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
		for(JHStatusEnum obj:values()) {
			if(obj.typeCode == typeCode)	return obj.typeName;
		}
		return null;
	}
	
	public static boolean checkedOk(int typeCode) {
		for(JHStatusEnum obj:values()) {
			if(obj.typeCode == typeCode)	return true;
		}
		return false;
	}

	public static boolean isActived(int typeCode){
		return ACTIVED.getTypeCode() == typeCode;
	}
}
