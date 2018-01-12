package com.zhw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhw.domain.NewsCenterInfo;

public interface NewsCenterMapper {

	//查询新闻列表
	List<NewsCenterInfo> selectList(@Param("newsTitle")String newsTitle,@Param("start")int start,@Param("pageSize")int pageSize);
	//删除
	int deleteOneNews(int pkId);
	//添加
	int insertOneNews(NewsCenterInfo info);
	//查询总数
	int selectCount(@Param("newsTitle")String newsTtitle);
}
