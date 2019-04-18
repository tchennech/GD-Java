package com.fx.hmwac.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CopyImgs {
	public static CopyImgs singCopyImgs = new CopyImgs();

	private CopyImgs() {
	};

	public void copyFiles(String originPath, String targetPath, String[] files) throws Exception{
		for(String fileName : files) {
			String realPath = targetPath + fileName;
			File file = new File(realPath);
			if(!file.exists()) {
				copyFile(originPath+fileName, realPath);
			}
		}
	}

	public void copyFile(String input, String output) {
		int n = 0;
		try {
			FileInputStream fis = new FileInputStream(input);
			FileOutputStream fos = new FileOutputStream(output);
			while ((n = fis.read()) != -1) {
				fos.write(n);
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
