package com.zhw.response;

/**
 * 功能描述：用于作为返回结果
 *
 * @Auther 张帅令
 * @Time 2017/12/20
 * @Note
 */
public class BaseResult {
    public static final int SUCCESS_STATUS = 0;
    public static final int FAILED_STATUS = 1;

    private int status;

    private String msg;

    private Object obj;

    private BaseResult(int status){
        this.status = status;
    }

    public BaseResult setStatus(int status){
        this.status = status;
        return this;
    }

    public int getStatus(){
        return this.status;
    }

    public BaseResult setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public String getMsg(){
        return this.msg;
    }

    public BaseResult setObj(Object obj){
        this.obj = obj;
        return this;
    }

    public Object getObj(){
        return this.obj;
    }

    public boolean isSucess(){
        return SUCCESS_STATUS == this.status;
    }

    public boolean isFailed(){
        return FAILED_STATUS == this.status;
    }

    public static BaseResult sucessInstance(){
        return new BaseResult(SUCCESS_STATUS);
    }

    public static BaseResult failedInstance(String msg){
        return new BaseResult(FAILED_STATUS).setMsg(msg);
    }
}
