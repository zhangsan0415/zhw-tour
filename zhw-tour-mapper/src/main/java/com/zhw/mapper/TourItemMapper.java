package com.zhw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhw.domain.TourItem;

public interface TourItemMapper {
	
	List<TourItem> selectListByAreaType(int areaType);
	
	int insertOneItem(TourItem obj);
	
	int deleteOneItem(int pkId);
	
	int selectTotalCountForPage(Integer areaType);
	
	List<TourItem> selectListForPage(@Param("areaType")Integer areaType,@Param("start")int start,@Param("pageSize")int pageSize);
	
	//查询行程所对应的报名未确信条数,用于确定是否可以删除
	int selectUNConfirmBMNumByPkId(int pkId);
	
}
