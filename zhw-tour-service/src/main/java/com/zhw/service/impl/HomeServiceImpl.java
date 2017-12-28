package com.zhw.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.zhw.domain.MemberBankInfo;
import com.zhw.mapper.MemberBankInfoMapper;

import com.zhw.service.HomeService;

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
    @Override
    public String getJDManHyCode(String hyCode) {
        return null;
    }

	@Override
	public MemberBankInfo queryBankInfo(String hyCode) {
		return bankInfoMapper.queryBankInfo(hyCode);
		
	}
}
