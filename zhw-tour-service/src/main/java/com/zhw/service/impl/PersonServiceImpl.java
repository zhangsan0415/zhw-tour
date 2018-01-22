package com.zhw.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.core.Is;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhw.domain.MemberBankInfo;
import com.zhw.domain.MemberInfo;
import com.zhw.mapper.MemberBankInfoMapper;
import com.zhw.mapper.MemberInfoMapper;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;
import com.zhw.service.PersonService;
import com.zhw.type.HyLevelEnum;
import com.zhw.type.HyLevelScoreEnum;
import com.zhw.type.JHStatusEnum;
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

	@Override
	public PageResult getMemberInfo(String tjMan, int currentPage,String hyCode,int jhStatus)throws Exception {
		
		int count = memberInfoMapper.selectCountBytjMan(tjMan,hyCode,jhStatus);
		if (count == 0)return 	PageResult.getOkInstance();
		int start = PageResult.getStartNumber(currentPage);
		List<MemberInfo> list = memberInfoMapper.selectMemberInfoBytjMan(tjMan,start,PageResult.pageSize,hyCode,jhStatus);
		if(list ==null || list.size()==0)	return null;
		this.setMoneyAndFlag(list);
		return PageResult.getPageInstance(list, currentPage, count);
	}
	
	private void setMoneyAndFlag(List<MemberInfo> list){
		list.forEach(obj->{
			obj.setMoney(HyLevelScoreEnum.getValueByCode(obj.getHyLevel()));
			obj.setFlag(JHStatusEnum.getNameByCode(obj.getJhStatus()));
			obj.setLevelName(HyLevelEnum.getNameByCode(obj.getHyLevel()));
		});
	}
	
	@Override
	public BaseResult queryNum(String hyCode) throws Exception {
		List<MemberInfo> list = memberInfoMapper.selectBytjMan(hyCode);
		if(list ==null || list.size()==0)	return null;
		this.setMoneyAndFlag(list);
		BigDecimal money = BigDecimal.ZERO;
		BigDecimal yMoney = BigDecimal.ZERO;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getZyArea()==0) {
				//左区
				money = money.add(list.get(i).getMoney());
			}else{
				yMoney = yMoney.add(list.get(i).getMoney());
			}
		}
		MemberInfo info = new MemberInfo();
		info.setzMoney(money);
		info.setyMoney(yMoney);
		return BaseResult.sucessInstance().setObj(info);
	}
}
