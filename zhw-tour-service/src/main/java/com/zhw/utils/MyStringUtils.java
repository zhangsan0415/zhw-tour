package com.zhw.utils;

/**
 * 功能描述：
 * 字符串工具类
 * @Auther 张帅令
 * @Time 2017/12/6
 * @Note
 */
public class MyStringUtils {

    /**
     * 字符串使用String拼接相当的慢，故有此方法
     */
    public static String putTogether(String ...values){
        if(values == null || values.length == 0)    return null;
        StringBuilder sb = new StringBuilder();
        for(String value:values){
            sb.append(value);
        }
        return sb.toString();
    }

    public static boolean isEmpty(String value){
        return value == null || value.length() == 0;
    }
}
