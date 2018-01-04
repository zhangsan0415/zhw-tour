package com.zhw.type;

import com.zhw.utils.StringUtils;

public enum ZZTypeEnum {

	  BD_TO_HY("1010","报单积分 转给 其他会员"),JJ_TO_BD("1011","奖金积分 转 报单积分"),JJ_TO_XJ("1012","奖金积分 转 现金积分"),JJ_TO_GW("1013","奖金积分 转 购物积分"),
	    LY_TO_BD("1014","旅游积分 转 报单积分"),LY_TO_XJ("1015","旅游积分 转 现金积分");

	    private String typeCode;

	    private String typeName;

	    private ZZTypeEnum(String typeCode,String typeName){
	        this.typeCode = typeCode;
	        this.typeName = typeName;
	    }

	    public String getTypeCode(){    return this.typeCode;    }

	    public String getTypeName(){    return this.typeName;    }

	    public static String getNameByCode(String typeCode){
	        if(StringUtils.isEmpty(typeCode))   return null;

	        for(ZZTypeEnum bank:values()){
	            if(bank.typeCode.equals(typeCode))  return bank.typeName;
	        }
	        return null;
	    }
}
