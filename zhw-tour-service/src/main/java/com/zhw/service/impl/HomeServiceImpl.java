package com.zhw.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhw.domain.MemberBankInfo;
import com.zhw.domain.MemberInfo;
import com.zhw.domain.MemberScoreInfoDetail;
import com.zhw.domain.TourItem;
import com.zhw.mapper.MemberBankInfoMapper;
import com.zhw.mapper.MemberInfoMapper;
import com.zhw.mapper.MemberScoreInfoDetailMapper;
import com.zhw.mapper.TourItemMapper;
import com.zhw.service.HomeService;
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
	private MemberScoreInfoDetailMapper scoreInfoMapper;
	
	@Resource
	private TourItemMapper itemMapper;
	
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
	public List<MemberScoreInfoDetail> queryScoreList(String hyCode) {
		return scoreInfoMapper.queryScoreInfoByHyCode(hyCode);
	}

	@Override
	public List<TourItem> queryTourItems(int areaType) {
		return itemMapper.selectListByAreaType(areaType);
	}

}
