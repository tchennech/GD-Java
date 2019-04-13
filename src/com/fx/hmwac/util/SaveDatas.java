package com.fx.hmwac.util;
//import java.io.DataInputStream;
//import java.io.File;  
//import java.io.FileOutputStream;  
//import java.io.IOException;  
//import java.net.URL; 
public class SaveDatas {
	public static SaveDatas singleSaveDatas = new SaveDatas();
	private SaveDatas() throws Exception{
		String connectString;   
		  Class.forName("oracle.jdbc.driver.OracleDriver");   
		  connectString = "jdbc:oracle:thin:@192.168.1.134:1521:zhpt";   
		  conn = (OracleConnection)   
		  DriverManager.getConnection(connectString, "dzjc","dzjc");   
		  stmt = conn.createStatement();   
	}
//	public void downloadImage(String Imageurl, String filename, String path) throws IOException{  
//	        System.getProperties().setProperty("http.proxyHost", "IP");//设置代理  
//	        System.getProperties().setProperty("http.proxyPort", "Port");  
//	        URL url = new URL(Imageurl);  
//	        //打开网络输入流  
//	        DataInputStream dis = new DataInputStream(url.openStream());  
//	        String newImageName=path + "/" + filename;
//	        //建立一个新的文件  
//	        FileOutputStream fos = new FileOutputStream(new File(newImageName));  
//	        byte[] buffer = new byte[1024];  
//	        int length;  
//	        //开始填充数据  
//	        while((length = dis.read(buffer))>0){  
//	            fos.write(buffer,0,length);  
//	        }  
//	        dis.close();  
//	        fos.close();      
//	    }
}
