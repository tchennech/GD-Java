package com.fx.hmwac.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fx.hmwac.domain.DataLoadBean;

public interface DataMapper {
	
	public int saveDatas(DataLoadBean dlb);

	public List<DataLoadBean> getAllData();

	public DataLoadBean selectById(DataLoadBean dlb);

}
