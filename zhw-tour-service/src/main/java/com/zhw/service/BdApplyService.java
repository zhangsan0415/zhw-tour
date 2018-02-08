package com.zhw.service;

import com.zhw.domain.BdApply;
import com.zhw.response.BaseResult;

public interface BdApplyService {
	
	BaseResult addBdApply(BdApply obj)throws Exception;
	
	
	BdApply queryBdApplyByCode(String hyCode)throws Exception;
}
