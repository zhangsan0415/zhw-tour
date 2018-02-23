package com.zhw.service;

import com.zhw.domain.BdApply;
import com.zhw.domain.MemberInfo;
import com.zhw.response.BaseResult;

public interface BdApplyService {
	
	BaseResult addBdApply(BdApply obj,MemberInfo info)throws Exception;
	
	
	BdApply queryBdApplyByCode(String hyCode)throws Exception;
}
