package com.zhw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhw.domain.TourItem;
import com.zhw.mapper.TourItemMapper;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;
import com.zhw.service.AdminService;
import com.zhw.type.AreaTypeEnum;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private TourItemMapper itemMapper;
	
	@Override
	public PageResult getTourItems(Integer areaType, int currentPage) throws Exception {
		int totalCount = itemMapper.selectTotalCountForPage(areaType);
		if(totalCount == 0)	return PageResult.getOkInstance();
		
		List<TourItem> tourItems = itemMapper.selectListForPage(areaType,PageResult.getStartNumber(currentPage),PageResult.pageSize);
		if(tourItems != null) {
			tourItems.forEach(obj -> {
				obj.setAreaTypeName(AreaTypeEnum.getNameByCode(obj.getAreaType()));
			});
		}
		return PageResult.getPageInstance(tourItems, currentPage, totalCount);
	}

	@Override
	public BaseResult removeTourItem(int pkId) throws Exception {
		int result = itemMapper.deleteOneItem(pkId);
		return result == 0?BaseResult.failedInstance("行程已不存在！"):BaseResult.sucessInstance().setMsg("删除成功！");
	}

	@Override
	public BaseResult addOneTourItem(TourItem obj) throws Exception {
		itemMapper.insertOneItem(obj);
		return BaseResult.failedInstance("添加失功！");
	}

}
