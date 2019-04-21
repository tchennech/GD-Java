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
import com.fx.hmwac.domain.PredictResultBean;
import com.fx.hmwac.domain.SingleResultBean;
import com.fx.hmwac.domain.TrainModelBean;
import com.fx.hmwac.util.CreateID;


@Service
@Scope
public class ModelService {
	final String detectorImgsPath = "C:\\detectorImgs\\";
	final String resultImgsPath = "C:\\resultImgs\\";
	CreateID ci= CreateID.singleCreateID;
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
	public PredictResultBean predict(PredictBean pb) throws Exception {
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
		PredictResultBean result = new PredictResultBean();
		//固定id测试用
		//String id = ci.madeID();
		String id = "testid";
		result.setId(id);
		result.setDetectorPath(detectorImgsPath + id+"\\");
		result.setResultPath(resultImgsPath+ id +"\\");
		//检测部分
		//移动检测结果
		//设置检测结果
		List<SingleResultBean> sr = new ArrayList<SingleResultBean>();
		String[] ids = {"102_3F325691-A609-4354-A4AC-960A1D463749_26.jpg",
				"102_3F325691-A609-4354-A4AC-960A1D463749_32.jpg",
				"102_3F325691-A609-4354-A4AC-960A1D463749_42.jpg"};
		int[][] nums = {{0, 22, 0, 0, 0, 0, 0, 0},
				{0, 37, 0, 0, 0, 0, 0, 0},
				{0, 25, 0, 0, 0, 0, 0, 0}};
		for(int i=0; i<3; i++) {
			int num = 0;
			for(int j=0; j<8; j++) {
				num += nums[i][j];
			}
			sr.add(new SingleResultBean(ids[i], nums[i], num));
		}
		result.setPictures(sr);
		//分类部分
		//结果保存
		return result;
	}
	public int deleteModelById(String id) throws Exception{
		// TODO Auto-generated method stub
		ModelBean mb = new ModelBean();
		mb.setId(id);
		int result = modelMapper.deleteModelById(mb);
		return result;
	}

}
