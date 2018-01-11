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
import com.zhw.utils.DateUtils;

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
		//如果存在行程尚未确认，不能删除
		int count = itemMapper.selectUNConfirmBMNumByPkId(pkId);
		if(count>0)	return BaseResult.failedInstance("该行程还存在有未确认的报名，尚不能删除！");
		
		itemMapper.deleteOneItem(pkId);
		return BaseResult.sucessInstance().setMsg("删除成功！");
	}

	@Override
	public BaseResult addOneTourItem(TourItem obj,String hyCode) throws Exception {
		obj.setCreateMan(hyCode);
		obj.setCreateTime(DateUtils.formatCurrentDate());
		itemMapper.insertOneItem(obj);
		return BaseResult.sucessInstance().setMsg("添加失功！");
	}

}
