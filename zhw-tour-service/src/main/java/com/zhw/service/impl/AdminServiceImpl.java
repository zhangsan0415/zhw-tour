package com.zhw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhw.domain.TourItem;
import com.zhw.domain.TourRegisterInfo;
import com.zhw.mapper.TourItemMapper;
import com.zhw.mapper.TourRegisterInfoMapper;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;
import com.zhw.service.AdminService;
import com.zhw.type.AreaTypeEnum;
import com.zhw.type.ConfirmStatusEnum;
import com.zhw.type.SexEnum;
import com.zhw.utils.DateUtils;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private TourItemMapper itemMapper;
	
	@Autowired
    private TourRegisterInfoMapper tourMapper;
	
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
		return BaseResult.sucessInstance().setMsg("添加成功！");
	}

	@Override
	public BaseResult delTourInfo(int pkId) throws Exception {
		int num = tourMapper.delTourInfo(pkId);
		if(num == 0)return BaseResult.exceptionInstance();
		return BaseResult.sucessInstance().setMsg("删除成功！");
	}

	@Override
	public BaseResult confirmTourInfo(int pkId) throws Exception {
		int num = tourMapper.ConfirmInfo(pkId);
		if(num == 0)return BaseResult.exceptionInstance();
		return BaseResult.sucessInstance().setMsg("确认成功！");
	}

	@Override
	public PageResult queryTourList(String hyCode, int areaType, int tourType,
			String cfDate, int currentPage) {
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

}
