package com.zhw.service;

import com.zhw.domain.MemberInfo;
import com.zhw.pojo.HyInfoPo;
import com.zhw.response.BaseResult;

public interface HyManagerService {
	
	BaseResult addHy(HyInfoPo infoPo,MemberInfo userInfo)throws Exception;
}
