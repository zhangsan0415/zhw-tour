package com.zhw.utils;

/**
 * 功能描述：
 * 字符串工具类
 * @Auther 张帅令
 * @Time 2017/12/6
 * @Note
 */
public class StringUtils {

    /**
     * 字符串使用String拼接相当的慢，故有此方法
     */
    public static String putTogether(String ...values){
        StringBuilder sb = new StringBuilder();
        for(String value:values){
            sb.append(value);
        }
        return sb.toString();
    }

    public static boolean isEmpty(String value){
        return value == null || value.length() == 0;
    }

    public static boolean isEmpty(String ...params){
        for(String param:params){
            if(isEmpty(param)) return true;
        }
        return false;
    }

    public static boolean isEqual(String value1,String value2){
        if(isEmpty(value1)) return false;
        return value1.equals(value2);
    }
}
