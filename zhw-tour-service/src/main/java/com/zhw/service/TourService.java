package com.zhw.service;

import java.util.List;

import com.zhw.domain.TourRegisterInfo;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;

public interface TourService {
	//查询游客报名记录
	PageResult queryTourList(String hyCode ,int areaType,int tourType,String cfDate,int currentPage);
	
	//添加旅游注册信息
	BaseResult saveTourList(int tourType,int areaType,String cfDate,List<TourRegisterInfo> dataList,String userCode)throws Exception;
	
	//获取旅游行程项目
	BaseResult getTourItemList(int areaType)throws Exception;
}
