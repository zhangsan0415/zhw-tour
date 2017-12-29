package com.zhw.mapper;

import java.util.List;

import com.zhw.domain.TourRegisterInfo;

public interface TourRegisterInfoMapper {

	List<TourRegisterInfo> queryTourInfo(String hyCode);
}
