package com.zhw.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhw.domain.TourRegisterInfo;
import com.zhw.mapper.TourRegisterInfoMapper;
import com.zhw.response.PageResult;
import com.zhw.service.TourService;

@Service
public class TourServiceImpl implements TourService {

	private TourRegisterInfoMapper tourMapper;
	@Override
	public PageResult queryTourList(String hyCode,int currentPage) {
		int count = tourMapper.queryTourCount(hyCode);
		if (count==0) return 	PageResult.getOkInstance();
		int start = PageResult.getStartNumber(currentPage);
		List<TourRegisterInfo> list = tourMapper.queryTourInfo(hyCode,start,PageResult.pageSize);
		if(list ==null || list.size()==0)	return null;
		
		
		return PageResult.getPageInstance(list, currentPage, count);
	}

}
