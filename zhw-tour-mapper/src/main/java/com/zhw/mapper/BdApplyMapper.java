package com.zhw.mapper;

import com.zhw.domain.BdApply;

public interface BdApplyMapper {
	int insert(BdApply obj);
	
	BdApply selectByPrimaryKey(String hyCode);
}
