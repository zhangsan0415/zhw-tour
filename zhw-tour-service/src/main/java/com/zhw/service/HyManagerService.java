package com.zhw.service;

import com.zhw.domain.MemberInfo;
import com.zhw.pojo.HyInfoPo;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;

public interface HyManagerService {
	
	BaseResult addHy(HyInfoPo infoPo,MemberInfo userInfo)throws Exception;
	
	BaseResult ktHy(String hyCode,String ktMan)throws Exception;

	BaseResult ktBdCenter(String hyCode)throws Exception;
	
	
	PageResult getActivedOrNotListPage(String hyCode,int jhStatus,int currentPage,String currentUser )throws Exception;
}
