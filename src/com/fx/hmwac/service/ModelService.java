package com.fx.hmwac.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fx.hmwac.dao.ModelMapper;
import com.fx.hmwac.dao.ResultMapper;
import com.fx.hmwac.domain.DataLoadBean;
import com.fx.hmwac.domain.ModelBean;
import com.fx.hmwac.domain.PredictBean;
import com.fx.hmwac.domain.PredictResultBean;
import com.fx.hmwac.domain.ResultBean;
import com.fx.hmwac.domain.SingleResultBean;
import com.fx.hmwac.domain.TrainModelBean;
import com.fx.hmwac.util.CallPython;
import com.fx.hmwac.util.CreateID;


@Service
@Scope
public class ModelService {
	final String detectorImgsPath = "C:\\detectorImgs\\";
	final String resultImgsPath = "C:\\resultImgs\\";
	private final CallPython cpy = CallPython.singleCallPython;
	CreateID ci= CreateID.singleCreateID;
	@Resource
	private ModelMapper modelMapper;
	@Resource
	private DataService dataService;
	@Resource
	private ResultMapper resultMapper;
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
		//id生成
		String id = ci.madeID();
		//检测结果
		List<String> dr = cpy.callPy(0, dlb.getId(), id);
		//分类结果
		List<String> cr = cpy.callPy(1, dlb.getId(), id);
		//结果保存
		result.setId(id);
		result.setDetectorPath(detectorImgsPath + id+"\\");
		result.setResultPath(resultImgsPath+ id +"\\");
		String xmlPath = "C:\\resultXml\\"+id+"\\";
		Map<String, SingleResultBean> setResult = new HashMap<>();
		for(String line : dr) {
			String[] li = line.split(" ");
			System.out.println(li);
			setResult.put(li[1], new SingleResultBean(li[1], Integer.parseInt(li[2])));
		}
		for(String line : cr) {
			int[] num = {0, 0, 0, 0, 0, 0, 0, 0};
			String[] li = line.split(" ");
			for(int i=0; i<8; i++) {
				num[i] = Integer.parseInt(li[i+2]);
			}
			setResult.put(li[1], new SingleResultBean(li[1], num, setResult.get(li[1]).getNum()));
		}
		//设置结果
		List<SingleResultBean> sr = new ArrayList<SingleResultBean>();
		for(Map.Entry<String, SingleResultBean> mm : setResult.entrySet()) {
			sr.add(mm.getValue());
		}
		result.setPictures(sr);
		
		//添加到数据库
		ResultBean rb = new ResultBean(id, dlb.getId(), dlb.getFlodName(), result.getGoodNum(), result.getBadNum(), result.getResultPath(),
				xmlPath, result.getDetectorPath(), "tchennech", new Date(), mb.getName(), mb.getId());
		resultMapper.addResult(rb);
		
		return result;
	}
	
	public List<ResultBean> getAllResults() {
		// TODO Auto-generated method stub
		List<ResultBean> result = resultMapper.getAllResults();
		return result;
	}
	
	public int deleteModelById(String id) throws Exception{
		// TODO Auto-generated method stub
		ModelBean mb = new ModelBean();
		mb.setId(id);
		int result = modelMapper.deleteModelById(mb);
		return result;
	}
	public PredictResultBean getResultById(ResultBean rb) {
		// TODO Auto-generated method stub
		ResultBean trb = resultMapper.getResultById(rb);
		PredictResultBean result = new PredictResultBean();
		result.setDetectorPath(trb.getDetectorPath());
		result.setId(trb.getId());
		result.setResultPath(trb.getImgPath());
		List<String> xmlr = cpy.callPy(-1, "0", trb.getId());
		List<SingleResultBean> setResult = new ArrayList<>();
		for(String line : xmlr) {
			int[] num = {0, 0, 0, 0, 0, 0, 0, 0};
			String[] li = line.split(" ");
			int totalNum = 0;
			for(int i=0; i<8; i++) {
				num[i] = Integer.parseInt(li[i+2]);
				totalNum += num[i];
			}
			setResult.add(new SingleResultBean(li[1], num, totalNum));
		}
		result.setPictures(setResult);
		return result;
	}

}
