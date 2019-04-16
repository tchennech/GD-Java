package com.fx.hmwac.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fx.hmwac.domain.ModelBean;

public interface ModelMapper {
	
//	public int saveDatas(DataLoadBean dlb);

	public List<ModelBean> getAllModels();

	public ModelBean getModelById(ModelBean mb);
	
	public int deleteModelById(ModelBean mb);
	
}
