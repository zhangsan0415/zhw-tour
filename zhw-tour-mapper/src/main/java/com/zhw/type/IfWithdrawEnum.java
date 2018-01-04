package com.zhw.type;

import com.zhw.utils.StringUtils;

public enum IfWithdrawEnum {

    CONFIRM("0","已确认"),UNCONFIRM("1","未确认");
	private String typeCode;

    private String typeName;

    private IfWithdrawEnum(String typeCode,String typeName){
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public String getTypeCode(){    return this.typeCode;    }

    public String getTypeName(){    return this.typeName;    }

    public static String getNameByCode(String typeCode){
        if(StringUtils.isEmpty(typeCode))   return null;

        for(IfWithdrawEnum bank:values()){
            if(bank.typeCode.equals(typeCode))  return bank.typeName;
        }
        return null;
    }
}
