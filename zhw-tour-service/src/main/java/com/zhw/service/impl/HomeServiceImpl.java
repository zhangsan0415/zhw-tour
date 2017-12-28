package com.zhw.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhw.domain.MemberBankInfo;
import com.zhw.domain.MemberInfo;
import com.zhw.mapper.MemberBankInfoMapper;
import com.zhw.mapper.MemberInfoMapper;
import com.zhw.service.HomeService;
import com.zhw.type.HyLevelScoreEnum;
import com.zhw.type.IfBdCenterEnum;
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
	
    @Override
    public String getJDManHyCode(String hyCode) {
        return null;
    }

	@Override
	public MemberBankInfo queryBankInfo(String hyCode) {
		return bankInfoMapper.queryBankInfo(hyCode);
		
	}

	@Override
	public List<MemberInfo> queryOpenInfo() {
	
		List<MemberInfo> list = memberInfoMapper.queryMemberInfo();
		if(list.size()==0){
			return null;
		}else{
			for (int i = 0; i < list.size(); i++) {
				//设置投资金额
				list.get(i).setMoney(HyLevelScoreEnum.getValueByCode(list.get(i).getHyLevel()));
				//设置是否开通
				list.get(i).setFlag(JHStatusEnum.getNameByCode(list.get(i).getJhStatus()));
			}
			return list;
		}
	}

	@Override
	public List<MemberInfo> queryInfo() {
		// TODO Auto-generated method stub
		List<MemberInfo> list = memberInfoMapper.queryInfo();
		if(list.size()==0){
			return null;
		}else{
			for (int i = 0; i < list.size(); i++) {
				//设置投资金额
				list.get(i).setMoney(HyLevelScoreEnum.getValueByCode(list.get(i).getHyLevel()));
				//设置是否开通
				list.get(i).setFlag(JHStatusEnum.getNameByCode(list.get(i).getJhStatus()));
			}
			return list;
		}
		
	}
}
