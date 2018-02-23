package com.zhw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhw.domain.BdApply;

public interface BdApplyMapper {
	int insert(BdApply obj);
	
	BdApply selectByPrimaryKey(String hyCode);

	int selectTotalCountByStatus(int ifBdCenter);

	List<BdApply> selectNotBdPageList(@Param("start")int start, @Param("pagesize")int pagesize, @Param("ifBdCenter")int ifBdCenter);
}
