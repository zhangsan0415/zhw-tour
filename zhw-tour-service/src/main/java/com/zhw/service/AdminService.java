package com.zhw.service;

import com.zhw.domain.NewsCenterInfo;
import com.zhw.domain.TourItem;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;

public interface AdminService {
	
	/*******************************旅游管理部分**********************************/
	PageResult getTourItems(Integer areaType,int currentPage)throws Exception;
	
	BaseResult removeTourItem(int pkId)throws Exception;
	
	BaseResult addOneTourItem(TourItem obj,String hyCode)throws Exception;
	
	BaseResult delTourInfo(int pkId)throws Exception;
	
	BaseResult confirmTourInfo(int pkId)throws Exception;
	
	//查询游客报名记录
	PageResult queryTourList(String hyCode ,int areaType,int tourType,String cfDate,int currentPage);
	
	/*******************************会员管理部分**********************************/
	
	PageResult getAuditList(String hyCode,int currentPage)throws Exception;
	
	BaseResult auditHy(String hyCode)throws Exception;
	
	BaseResult delHy(String hyCode)throws Exception;
	
	
	BaseResult getNotBdList(String hyCode,int currentPage)throws Exception;
	
	BaseResult ktBdCenter(String hyCode)throws Exception;
	
	/********************************新闻编辑****************************************/
	
	PageResult getNewsList(String newsTitle,int currentPage)throws Exception;
	
	BaseResult delNews(int pkId)throws Exception;
	
	BaseResult addNews(NewsCenterInfo info) throws Exception;
	
}
