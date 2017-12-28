package com.zhw.service;

import java.util.List;

import com.zhw.domain.MemberBankInfo;
import com.zhw.domain.MemberInfo;

/**
 * 功能描述：
 *
 * @Auther 张帅令
 * @Time 2017/12/26
 * @Note
 */

public interface HomeService {

    String getJDManHyCode(String hyCode);
    /**
     * 查询银行卡信息
     * @param hyCode
     * @return
     */
    MemberBankInfo queryBankInfo(String hyCode);
    /**
     * 查询开通会员信息
     * @return
     */
    List<MemberInfo> queryOpenInfo();
    /**
     * 
     * 查询未开通会员信息
     * @return
     */
    List<MemberInfo> queryInfo();
}
