package com.zhw.service;

import com.zhw.domain.MemberInfo;

public interface LoginService {

    /**
     * 验证用户密码是否正确（用户名为会员编号）
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    MemberInfo checkLogin(String hyCode,String password)throws Exception;

    /**
     * 验证会员编号是否存在
     * @param memberCode
     * @return
     * @throws Exception
     */
    boolean isHyExsists(String hyCode)throws Exception;
    
    
    /**
     * 修改用户(会员)密码
     * @param memberCode
     * @param pwd
     * @return
     * @throws Exception
     */
    boolean changePwd(String hyCode,String pwd) throws Exception;
    
}
