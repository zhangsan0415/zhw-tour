package com.zhw.service;

import java.util.List;

import com.zhw.domain.MemberBankInfo;
import com.zhw.domain.MemberInfo;
import com.zhw.domain.MemberScoreInfo;
import com.zhw.domain.MemberScoreInfoDetail;
import com.zhw.domain.TourRegisterInfo;

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
     * 根据状态查询会员信息
     * @return
     */
    List<MemberInfo> queryHyInfoByStatus(String hyCode,int jhStatus);
    
    /**
     * 根据推荐人查询推荐的人的信息
     * @param tjMan
     * @return
     */
    
    List<MemberInfo> queryMemberInfoBytjMan(String tjMan);
    
    /**
     * 默认查询登录人的报名记录
     * @return
     */
    List<TourRegisterInfo> queryTourInfo(String hyCode);
    /**
     * 根据登录人会员编号查询积分明细
     * @param hyCode
     * @return
     */
    List<MemberScoreInfoDetail> queryScoreList(String hyCode);
}
