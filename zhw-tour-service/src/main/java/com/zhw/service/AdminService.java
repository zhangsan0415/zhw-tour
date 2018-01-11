package com.zhw.service;

import com.zhw.domain.TourItem;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;

public interface AdminService {
	
	/*******************************旅游管理部分**********************************/
	PageResult getTourItems(Integer areaType,int currentPage)throws Exception;
	
	BaseResult removeTourItem(int pkId)throws Exception;
	
	BaseResult addOneTourItem(TourItem obj,String hyCode)throws Exception;
	
	
}
