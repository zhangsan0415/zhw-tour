package com.zhw.service;

import java.util.List;

import com.zhw.domain.MemberBankInfo;
import com.zhw.domain.MemberScoreInfoDetail;
import com.zhw.domain.TourItem;

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
     * 根据登录人会员编号查询积分明细
     * @param hyCode
     * @return
     */
   List<MemberScoreInfoDetail> queryScoreList(String hyCode);
   
   
   /**
    * 查询所有的旅游行程
    * @param areaType
    * @return
    */
   List<TourItem> queryTourItems(int areaType);
//   /**
//    * 查看左右区注册金额
//    * @param hyCode
//    * @return
//    */
//   List<MemberInfo> querySyatem(String hyCode);
}
