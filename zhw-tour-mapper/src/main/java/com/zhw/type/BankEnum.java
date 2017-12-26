package com.zhw.type;

import com.zhw.utils.StringUtils;

/**
 * 功能描述：
 *
 * @Auther 张帅令
 * @Time 2017/12/26
 * @Note
 */
public enum BankEnum {

    NY_BANK_ABC("1000","农业银行"),JSH_BANK_CCB("1001","建设银卡"),GSH_BAK_ICBC("1002","工商银行"),ZHG_BANK_BOC("1003","中国银行"),
    ZHSH_BANK_CMB("1004","招商银行"),JT_BANK_BOCOM("1005","交通银行");

    private String typeCode;

    private String typeName;

    private BankEnum(String typeCode,String typeName){
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public String getTypeCode(){    return this.typeCode;    }

    public String getTypeName(){    return this.typeName;    }

    public static String getNameByCode(String typeCode){
        if(StringUtils.isEmpty(typeCode))   return null;

        for(BankEnum bank:values()){
            if(bank.typeCode.equals(typeCode))  return bank.typeName;
        }
        return null;
    }
}
