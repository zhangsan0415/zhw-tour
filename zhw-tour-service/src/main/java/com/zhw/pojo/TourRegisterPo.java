package com.zhw.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhw.domain.TourRegisterInfo;

public class TourRegisterPo {
	private Integer tourType;
	
	private String cfDate;
	
	private List<TourRegisterInfo> tourors;

	public Integer getTourType() {
		return tourType;
	}

	public void setTourType(Integer tourType) {
		this.tourType = tourType;
	}

	public String getCfDate() {
		return cfDate;
	}

	public void setCfDate(String cfDate) {
		this.cfDate = cfDate;
	}

	public List<TourRegisterInfo> getTourors() {
		return tourors;
	}

	public void setTourors(String tourors) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, TourRegisterInfo.class);
		this.tourors = mapper.readValue(tourors, javaType);
	}
	
	
}
