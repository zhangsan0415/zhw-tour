package com.zhw.type;

/**
 * 是否为管理员
 * @author zsl
 *
 */
public enum IfAdminEnum   {
	Y_ADMIN(0,"是"),N_ADMIN(1,"否");
	
	private int typeCode;
	private String typeName;
	
	private IfAdminEnum(int typeCode,String typeName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
	}
	
	public int getTypeCode() {	return this.typeCode;	}
	
	public String getTypeName() {	return this.typeName;	};
	
	public static String getNameByCode(int code) {
		for(IfAdminEnum obj:values()) {
			if(obj.typeCode == code) 	return obj.typeName;
		}
		return null;
	}

	public static boolean isAdmin(int typeCode){
		return Y_ADMIN.getTypeCode() == typeCode;
	}
}
