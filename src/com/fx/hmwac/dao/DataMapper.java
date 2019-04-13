package com.fx.hmwac.dao;

import org.apache.ibatis.annotations.Param;

import com.fx.hmwac.domain.DataLoadBean;

public interface DataMapper {
	
	public int saveDatas(DataLoadBean dlb);

}
