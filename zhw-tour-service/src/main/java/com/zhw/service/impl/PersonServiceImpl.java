package com.zhw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhw.domain.MemberBankInfo;
import com.zhw.mapper.MemberBankInfoMapper;
import com.zhw.mapper.MemberInfoMapper;
import com.zhw.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService {

	@Resource
	private MemberInfoMapper memberInfoMapper;
	
	@Resource
	private MemberBankInfoMapper bankInfoMapper;
	
	@Override
	@Transactional
	public int modifyInfo(String hyCode,String khBankName,String khCardCode,String khName,String khProvince,
			String khCity,String sfzCardCode,String yxEmail,String sjMobile)throws Exception {
		//1/修改邮箱、手机号
		   int num = memberInfoMapper.modifyInfo(hyCode, sjMobile, yxEmail,sfzCardCode);
		//修改银行信息
		   if (num>0) {
			    MemberBankInfo bankInfo = new MemberBankInfo();
				bankInfo.setHyCode(hyCode);
				bankInfo.setKhBankName(khBankName);
				bankInfo.setKhCardCode(khCardCode);
				bankInfo.setKhCity(khCity);
				bankInfo.setKhName(khName);
				bankInfo.setKhProvince(khProvince);
				bankInfo.setSfzCardCode(sfzCardCode);
				return bankInfoMapper.modifyBankInfo(bankInfo);
		   }
			return 0;
		
	}

	@Override
	public int modifyPwd(String hyCode,String yjPwd,String ejPwd)throws Exception {
		
		return memberInfoMapper.modifyPwd(hyCode, yjPwd, ejPwd);
	}

}
