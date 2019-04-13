package com.fx.hmwac.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class SaveDatas {
	public static SaveDatas singleSaveDatas = new SaveDatas();

	private SaveDatas() {
	}

	public void saveImgs(String path, MultipartFile file) throws Exception {
		try {
			String name = file.getOriginalFilename();
			String filePath = path;
			filePath += name;
			System.out.println(filePath);
			file.transferTo(new File(filePath));// 将文件写入到指定的路径当中
		} catch (Exception e) { // TODO Auto-generated catch block
			System.out.print(file);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}
