package com.zhw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhw.domain.BdApply;
import com.zhw.mapper.BdApplyMapper;
import com.zhw.mapper.MemberInfoMapper;
import com.zhw.response.BaseResult;
import com.zhw.service.BdApplyService;
import com.zhw.type.IfBdCenterEnum;
import com.zhw.utils.DateUtils;

@Service
public class BdApplyServiceImpl implements BdApplyService{

	@Autowired
	private BdApplyMapper bdMapper;
	
	@Autowired
	private MemberInfoMapper infoMapper;
	
	@Override
	public BaseResult addBdApply(BdApply obj) throws Exception {
		obj.setSqTime(DateUtils.formatCurrentDate());
		obj.setIfBdCenter(IfBdCenterEnum.WILL_BD_CENTER.getTypeCode());
		obj.setHkAccount("6226 6237 0028 8651");
		bdMapper.insert(obj);
		infoMapper.updateIfBdByCode(obj.getHyCode(),IfBdCenterEnum.WILL_BD_CENTER.getTypeCode());
		return BaseResult.sucessInstance().setMsg("申请成功！");
	}

	@Override
	public BdApply queryBdApplyByCode(String hyCode) throws Exception {
		return bdMapper.selectByPrimaryKey(hyCode);
	}

}
