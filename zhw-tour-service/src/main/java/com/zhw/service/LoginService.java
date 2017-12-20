package com.zhw.service;

public interface LoginService {

    /**
     * 验证用户密码是否正确（用户名为会员编号）
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    boolean checkLogin(String username,String password)throws Exception;

    /**
     * 验证会员编号是否存在
     * @param memberCode
     * @return
     * @throws Exception
     */
    boolean checkMemberCode(String memberCode)throws Exception;
}
