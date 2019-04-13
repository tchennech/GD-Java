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
import com.fx.hmwac.util.SaveDatas;


@Service
@Scope
public class DataService {
	@Resource
	private DataMapper dataMapper;

	public boolean SaveData(DataLoadBean dlb) throws Exception {
		//保存图片
		String path = "C:/myPictures/";
		path += dlb.getFlodName();
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		SaveDatas sd = SaveDatas.singleSaveDatas;
		try {
			for(PictureDetail pd : dlb.getFiles()) {
				sd.downloadImage(pd.getUrl(), pd.getName(), path);
			}
		} catch (Exception e){
			System.out.println(e);
			throw new Exception(e);
		}
		
		//数据库中保存信息
		int status;
		CreateID ci= CreateID.singleCreateID;
		dlb.setId(ci.madeID());
		dlb.setNum(dlb.getFiles().size());
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
		return true;
	}

}
