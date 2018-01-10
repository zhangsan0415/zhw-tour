package com.zhw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhw.component.BatchUpdateService;
import com.zhw.domain.TourRegisterInfo;
import com.zhw.mapper.TourRegisterInfoMapper;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;
import com.zhw.service.TourService;
import com.zhw.type.ConfirmStatusEnum;
import com.zhw.type.SexEnum;
import com.zhw.utils.DateUtils;

@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourRegisterInfoMapper tourMapper;
	
	@Autowired
	private BatchUpdateService batchComponent;
	
	@Override
	public PageResult queryTourList(String hyCode ,int areaType,int tourType,String cfDate,int currentPage) {
		int count = tourMapper.selectTourListPageCount(hyCode,areaType,tourType,cfDate);
		if (count==0) return 	PageResult.getOkInstance();
		int start = PageResult.getStartNumber(currentPage);
		List<TourRegisterInfo> list = tourMapper.selectTourListPage(hyCode,areaType,tourType,cfDate,start,	PageResult.pageSize);
		list.forEach(obj ->{
			obj.setSexName(SexEnum.getNameByCode(obj.getBmSex()));
			obj.setConfirmStatusName(ConfirmStatusEnum.getNameByCode(obj.getConfirmStatus()));
		});
		return PageResult.getPageInstance(list, currentPage, count);
	}
	@Override
	public BaseResult saveTourList(int tourType, int areaType, String cfDate, List<TourRegisterInfo> dataList,
			String userCode) throws Exception {
		for(TourRegisterInfo obj:dataList) {
			obj.setTourType(tourType);
			obj.setAreaType(areaType);
			obj.setCfDate(cfDate);
			obj.setHyCode(userCode);
			obj.setCjTime(DateUtils.formatCurrentDate());
			obj.setConfirmStatus(ConfirmStatusEnum.UNCONFIRMED.getTypeCode());
		}
		
		return batchComponent.batchUpdate(dataList, TourRegisterInfoMapper.class, true);
	}

}
