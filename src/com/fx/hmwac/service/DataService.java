package com.fx.hmwac.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fx.hmwac.dao.DataMapper;
import com.fx.hmwac.domain.DataLoadBean;
import com.fx.hmwac.domain.PictureDetail;
import com.fx.hmwac.util.CreateID;


@Service
@Scope
public class DataService {
	@Resource
	private DataMapper dataMapper;

	public String SaveData(DataLoadBean dlb) throws Exception {
		//生产id
		CreateID ci= CreateID.singleCreateID;
		dlb.setId(ci.madeID());
		//生产文件夹名
		String path = "C:\\myPictures\\";
		path += dlb.getId();
		path += "\\";
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		//数据库中保存信息
		int status;
		dlb.setSaveTime(new Date());
		dlb.setPath(path);
		try {
			status = dataMapper.saveDatas(dlb);
			System.out.println(status);
		} catch (Exception e) {
			throw new Exception(e);
		}

		if (status == 0) {
			throw new Exception("信息保存失败");
		}
		return path;
	}

	public List<DataLoadBean> getAllData() throws Exception{
		// TODO Auto-generated method stub
		
		List<DataLoadBean> result = dataMapper.getAllData();
		return result;
	}
	public DataLoadBean getDataById(DataLoadBean dlb) throws Exception{
		// TODO Auto-generated method stub
		DataLoadBean result = dataMapper.getDataById(dlb);
		return result;
	}
}
