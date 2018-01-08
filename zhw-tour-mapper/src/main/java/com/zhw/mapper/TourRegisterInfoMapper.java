package com.zhw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhw.annotion.Batch;
import com.zhw.domain.TourRegisterInfo;

public interface TourRegisterInfoMapper {

	//查询报名记录
	List<TourRegisterInfo> queryTourInfo(@Param("hyCode")String hyCode,@Param("start")int start,@Param("pageSize")int pageSize);
	//查询报名记录总条数
	int queryTourCount(String hyCode);
	
	@Batch
	int insertBatch(List<TourRegisterInfo> list);
}
