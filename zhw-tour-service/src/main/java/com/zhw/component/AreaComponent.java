package com.zhw.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhw.domain.Area;
import com.zhw.mapper.AreaMapper;

@Component
public class AreaComponent {
	
	private static final String BASE_ID = "000000";
	
	@Autowired
	private AreaMapper areaMapper;
	
	public List<Area> getProvinces(){
		return areaMapper.selectAreaListByParentId(BASE_ID);
	}
	
	public List<Area> getCities(String provinceId){
		return areaMapper.selectAreaListByParentId(provinceId);
	}
	
}
