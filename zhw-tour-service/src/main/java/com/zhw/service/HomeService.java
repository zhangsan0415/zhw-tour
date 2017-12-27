package com.zhw.service;

import com.zhw.domain.MemberBankInfo;

/**
 * 功能描述：
 *
 * @Auther 张帅令
 * @Time 2017/12/26
 * @Note
 */

public interface HomeService {

    String getJDManHyCode(String hyCode);
    MemberBankInfo queryBankInfo(String hyCode);
}
