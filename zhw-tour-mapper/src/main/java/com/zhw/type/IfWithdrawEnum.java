package com.zhw.type;

import com.zhw.utils.StringUtils;

public enum IfWithdrawEnum {

	TQ_JJ_SCORE("1016","提取奖金积分"),TQ_LY_SCORE("1017","提取旅游积分"),BD_SCORFE("1018","报单积分"),XJ_SCORE("1019","现金积分"),
    CONFIRM("0","未确认"),UNCONFIRM("1","已确认");
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
