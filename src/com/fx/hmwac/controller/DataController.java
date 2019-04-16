package com.fx.hmwac.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fx.hmwac.domain.DataLoadBean;
import com.fx.hmwac.domain.ModelBean;
import com.fx.hmwac.service.DataService;
import com.fx.hmwac.util.SaveDatas;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Controller
public class DataController {
	@Resource
	private DataService dataService;
	private final String SET_ENCODE = "utf-8";
	private final String SET_TEXTURE = "text/plain";
	private final String DATA = "datal";
	SaveDatas sSaveDatas = SaveDatas.singleSaveDatas;

	private String changeEncode(HttpServletRequest request, HttpServletResponse response, String paraName)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding(SET_ENCODE);
		response.setCharacterEncoding(SET_ENCODE);
		response.setContentType(SET_TEXTURE);
		String msg = request.getParameter(paraName).toString();
		return msg;
	}

	@RequestMapping(value = "upLoadData", method = RequestMethod.POST)
	@ResponseBody
	public String upLoadData(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String param = "";
		JsonObject jsonMsg = new JsonObject();
		try {
			param = changeEncode(request, response, DATA);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Gson gson = new Gson();
		DataLoadBean dlb = gson.fromJson(param, DataLoadBean.class);
		String result = "";
		try {
			result = dataService.SaveData(dlb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonMsg.addProperty("status", 1);
			jsonMsg.addProperty("msg", e.getMessage());
			return jsonMsg.toString();
		}

		jsonMsg.addProperty("status", 0);
		jsonMsg.addProperty("path", (new Gson()).toJson(result).toString());
		System.out.println(jsonMsg.toString());
		return jsonMsg.toString();
	}

	@RequestMapping("/upLoadImg")
	@ResponseBody
	public String upLoadImg(@RequestBody MultipartFile file, String path, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonObject jsonMsg = new JsonObject();
		path = path.substring(1,path.length()-1); 
		System.out.println("上传图片是否为空：" + file.isEmpty());
		System.out.println("路径：" + path);
		if (file != null) {
			String imgType = null;// 图片类型
			String fileName = file.getOriginalFilename();// 原文件名称
			// 判断图片类型
			imgType = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
					: null;
			if (imgType != null) {
				if ("PNG".equals(imgType.toUpperCase()) || "JPG".equals(imgType.toUpperCase())) {
					// 转存文件到指定路径
					try {
						sSaveDatas.saveImgs(path, file);
					} catch (Exception e) {
						jsonMsg.addProperty("status", 1);
						jsonMsg.addProperty("msg", e.getMessage());
						return jsonMsg.toString();
					}
					System.out.println("文件成功上传到指定目录下");
				} else {
					System.out.println("请上传PNG或者JPG格式的文件");
					jsonMsg.addProperty("status", 1);
					jsonMsg.addProperty("msg", "请上传PNG或者JPG格式的文件");
					return jsonMsg.toString();
				}
			} else {
				System.out.println("文件类型为空");
				jsonMsg.addProperty("status", 1);
				jsonMsg.addProperty("msg", "文件类型为空");
				return jsonMsg.toString();
			}
		} else {
			System.out.println("没有找到相对应的文件");
			jsonMsg.addProperty("status", 1);
			jsonMsg.addProperty("msg", "没有找到相对应的文件");
			return jsonMsg.toString();
		}
		jsonMsg.addProperty("status", 0);
		System.out.println(jsonMsg.toString());
		return jsonMsg.toString();
	}
	
	@RequestMapping(value = "getAllData", method = RequestMethod.POST, produces="text/html; charset=utf-8")
	@ResponseBody
	public String getAllData(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String param = "";
		JsonObject jsonMsg = new JsonObject();
		List<DataLoadBean> result;
		try {
			result = dataService.getAllData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonMsg.addProperty("status", 1);
			jsonMsg.addProperty("msg", e.getMessage());
			return jsonMsg.toString();
		}

		jsonMsg.addProperty("status", 0);
		jsonMsg.addProperty("datas", (new Gson()).toJson(result).toString());
		System.out.println(jsonMsg.toString());
		return jsonMsg.toString();
	}
	@RequestMapping(value = "deleteData", method = RequestMethod.POST)
	@ResponseBody
	public String deleteData(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String param = "";
		JsonObject jsonMsg = new JsonObject();
		try {
			param = changeEncode(request, response, DATA);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Gson gson = new Gson();
		DataLoadBean dlb = gson.fromJson(param, DataLoadBean.class);
		int result = 0;
		try {
			result = dataService.deleteDataById(dlb.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonMsg.addProperty("status", 1);
			jsonMsg.addProperty("msg", e.getMessage());
			return jsonMsg.toString();
		}
		jsonMsg.addProperty("status", 0);
		jsonMsg.addProperty("statu", (new Gson()).toJson(result).toString());
		System.out.println(jsonMsg.toString());
		return jsonMsg.toString();
	}
}
