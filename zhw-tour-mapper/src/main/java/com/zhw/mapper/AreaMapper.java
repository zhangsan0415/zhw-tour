package com.zhw.mapper;

import java.util.List;

import com.zhw.domain.Area;

public interface AreaMapper {
	
	List<Area> selectAreaListByParentId(String parentId);

}
