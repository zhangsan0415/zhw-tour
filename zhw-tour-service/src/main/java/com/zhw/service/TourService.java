package com.zhw.service;

import com.zhw.response.PageResult;

public interface TourService {
	//查询游客报名记录
	PageResult queryTourList(String hyCode,int currentPage);
}
