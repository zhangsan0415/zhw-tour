package com.zhw.service;

import com.zhw.domain.MemberInfo;
import com.zhw.domain.MemberScoreInfo;

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
     * 通过会员编码获其会员积分信息
     * @param hyCode
     * @return
     * @throws Exception
     */
    MemberScoreInfo getScoreInfoByHyCode(String hyCode)throws Exception;
    
}
