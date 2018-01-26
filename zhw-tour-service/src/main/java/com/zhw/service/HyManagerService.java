package com.zhw.service;

import java.util.List;
import java.util.Map;

import com.zhw.domain.MemberInfo;
import com.zhw.pojo.HyInfoPo;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;

public interface HyManagerService {
	
	BaseResult addHy(HyInfoPo infoPo,MemberInfo userInfo)throws Exception;
	
	BaseResult ktHy(String hyCode,String ktMan)throws Exception;
	
	BaseResult delHy(String hyCode)throws Exception;

	PageResult getActivedOrNotListPage(String hyCode,String jhStatus,int currentPage,String currentUser )throws Exception;
	
	List<Map<String,Object>> getRelation(MemberInfo currentUser)throws Exception;
}
