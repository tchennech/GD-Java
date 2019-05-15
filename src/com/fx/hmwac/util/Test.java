package com.fx.hmwac.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			final Process p = Runtime.getRuntime().exec("C:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python36\\python.exe E:\\projects\\graduatedesign\\SSD-Tensorflow-master\\notebooks\\predict2.py");
//			System.out.println(p.waitFor());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
            System.out.println("start");

            String[] args1=new String[]{"python3","E:\\projects\\graduatedesign\\SSD-Tensorflow-master\\notebooks\\predict2.py", "12312"};
            Process pr=Runtime.getRuntime().exec(args1);
 
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
