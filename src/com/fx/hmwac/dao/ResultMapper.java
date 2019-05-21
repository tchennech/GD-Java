package com.fx.hmwac.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fx.hmwac.domain.ResultBean;

public interface ResultMapper {
	
	public List<ResultBean> getAllResults();

	public int addResult(ResultBean mb);

	public ResultBean getResultById(ResultBean rb);

}
