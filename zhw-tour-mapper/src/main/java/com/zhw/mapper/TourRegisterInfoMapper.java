package com.zhw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhw.annotion.Batch;
import com.zhw.domain.TourRegisterInfo;

public interface TourRegisterInfoMapper {

	//查询报名记录
	List<TourRegisterInfo> selectTourListPage(@Param("hyCode") String hyCode,@Param("areaType")int areaType,@Param("tourType")int tourType,
			@Param("cfDate")String cfDate,@Param("start")int start,@Param("pageSize")int pageSize);
	
	//查询报名记录总条数
	int selectTourListPageCount(@Param("hyCode") String hyCode ,@Param("areaType")int areaType,@Param("tourType")int tourType,@Param("cfDate")String cfDate);
	
	@Batch
	int insertBatch(List<TourRegisterInfo> list);
}
