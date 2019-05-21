package com.fx.hmwac.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CallPython {
	private final String DETPATH = "E:\\projects\\graduatedesign\\SSD-Tensorflow-master\\notebooks\\predict2.py";
	private final String CLAPATH = "E:\\projects\\graduatedesign\\graduateDesign\\main.py";
	private final String XMLPYPATH = "E:\\projects\\graduatedesign\\graduateDesign\\readXml.py";
	private final String IMGPATH = "C:\\myPictures\\";
	private final String XMLPATH = "C:\\resultXml\\";
	public static CallPython singleCallPython = new CallPython();

	private CallPython() {
	};

	public List<String> callPy(int type, String imgId, String id) {
		List<String> result = new ArrayList<String>();
		try {
			System.out.println("start");
			String file = DETPATH;
			String[] args1;
			if (type == 0) {
				file = DETPATH;
				args1 = new String[] { "python3", file, IMGPATH + imgId + "\\", id };
			} else if(type == -1){
				file = XMLPYPATH;
				args1 = new String[] { "python3", file, XMLPATH + id };
			}else{
				file = CLAPATH;
				args1 = new String[] { "python3", file, "1", IMGPATH + imgId, id };
			}

			Process pr = Runtime.getRuntime().exec(args1);

			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				if ("returnMessage".equals(line.split(" ")[0])) {
					result.add(line);
				}
			}
			in.close();
			pr.waitFor();
			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
