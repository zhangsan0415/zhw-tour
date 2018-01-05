package com.zhw.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhw.domain.MemberBankInfo;
import com.zhw.domain.MemberInfo;
import com.zhw.domain.MemberScoreInfoDetail;
import com.zhw.domain.TourRegisterInfo;
import com.zhw.mapper.MemberBankInfoMapper;
import com.zhw.mapper.MemberInfoMapper;
import com.zhw.mapper.MemberScoreInfoDetailMapper;
import com.zhw.mapper.MemberScoreInfoMapper;
import com.zhw.mapper.TourRegisterInfoMapper;
import com.zhw.service.HomeService;
import com.zhw.type.HyLevelEnum;
import com.zhw.type.HyLevelScoreEnum;
import com.zhw.type.JHStatusEnum;
import com.zhw.utils.StringUtils;

/**
 * 功能描述：
 *
 * @Auther 张帅令
 * @Time 2017/12/26
 * @Note
 */
@Service
public class HomeServiceImpl implements HomeService {
	
	@Resource
	private MemberBankInfoMapper bankInfoMapper;
	
	@Resource
	private MemberInfoMapper memberInfoMapper;
	
	@Resource
	private TourRegisterInfoMapper tourMapper;
	
	@Resource
	private MemberScoreInfoMapper scoreMapper;
	
	@Resource
	private MemberScoreInfoDetailMapper scoreInfoMapper;
	
    @Override
    public String getJDManHyCode(String hyCode) {
    	String jdMan = memberInfoMapper.selectJdManCode(hyCode);
        return StringUtils.isEmpty(jdMan)?hyCode:jdMan;
    }

	@Override
	public MemberBankInfo queryBankInfo(String hyCode) {
		return bankInfoMapper.queryBankInfo(hyCode);
		
	}

	@Override
	public List<MemberInfo> queryHyInfoByStatus(String hyCode,int jhStatus) {
		List<MemberInfo> list = memberInfoMapper.selectMemberInfoByKtManAndStatus(hyCode,jhStatus);
		if(list ==null || list.size()==0)	return null;
		this.setMoneyAndFlag(list);
		return list;
	}

	private void setMoneyAndFlag(List<MemberInfo> list){
		list.forEach(obj->{
			obj.setMoney(HyLevelScoreEnum.getValueByCode(obj.getHyLevel()));
			obj.setFlag(JHStatusEnum.getNameByCode(obj.getJhStatus()));
			obj.setLevelName(HyLevelEnum.getNameByCode(obj.getHyLevel()));
		});
	}
	/*
	@Override
	public List<MemberInfo> queryMemberInfoBytjMan(String tjMan) {
		// TODO Auto-generated method stub
		List<MemberInfo> list = memberInfoMapper.selectMemberInfoBytjMan(tjMan);
		if(list ==null || list.size()==0)	return null;
		this.setMoneyAndFlag(list);
		return list;
	}*/

/*	@Override
	public List<TourRegisterInfo> queryTourInfo(String hyCode) {
		// TODO Auto-generated method stub
		return tourMapper.queryTourInfo(hyCode);
	}*/

	@Override
	public List<MemberScoreInfoDetail> queryScoreList(String hyCode) {
		// TODO Auto-generated method stub
		return scoreInfoMapper.queryScoreInfoByHyCode(hyCode);
	}
}
