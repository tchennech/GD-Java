package com.fx.hmwac.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fx.hmwac.dao.ModelMapper;
import com.fx.hmwac.domain.DataLoadBean;
import com.fx.hmwac.domain.ModelBean;
import com.fx.hmwac.domain.PredictBean;
import com.fx.hmwac.domain.TrainModelBean;
import com.fx.hmwac.util.CreateID;


@Service
@Scope
public class ModelService {
	@Resource
	private ModelMapper modelMapper;
	@Resource
	private DataService dataService;
	public int trainModel(TrainModelBean tmb) throws Exception {
		// 获取data数据
		DataLoadBean dlbForm = new DataLoadBean();
		dlbForm.setId(tmb.getId());
		DataLoadBean dlb;
		try {
			dlb = dataService.getDataById(dlbForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		//执行算法
		System.out.println(dlb);
		System.out.println(tmb);
		return 0;
	}
	public List<ModelBean> getAllModels() {
		// TODO Auto-generated method stub
		List<ModelBean> result = modelMapper.getAllModels();
		return result;
	}
	public ModelBean getModelById(ModelBean mb) {
		// TODO Auto-generated method stub
		ModelBean result = modelMapper.getModelById(mb);
		return result;
	}
	public int predict(PredictBean pb) throws Exception {
		// TODO Auto-generated method stub
		DataLoadBean dlbForm = new DataLoadBean();
		dlbForm.setId(pb.getDataId());
		DataLoadBean dlb;
		ModelBean mbForm = new ModelBean();
		mbForm.setId(pb.getModelId());
		ModelBean mb;
		try {
			dlb = dataService.getDataById(dlbForm);
			mb = getModelById(mbForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
		//执行算法
		System.out.println(dlb);
		System.out.println(mb);
		return 0;
	}
	public int deleteModelById(String id) throws Exception{
		// TODO Auto-generated method stub
		ModelBean mb = new ModelBean();
		mb.setId(id);
		int result = modelMapper.deleteModelById(mb);
		return result;
	}

}
