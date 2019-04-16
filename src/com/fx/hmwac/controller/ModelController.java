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
import com.fx.hmwac.domain.PredictBean;
import com.fx.hmwac.domain.TrainModelBean;
import com.fx.hmwac.service.ModelService;
import com.fx.hmwac.util.SaveDatas;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Controller
public class ModelController {
	@Resource
	private ModelService modelService;
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

	@RequestMapping(value = "trainModel", method = RequestMethod.POST)
	@ResponseBody
	public String trainModel(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String param = "";
		JsonObject jsonMsg = new JsonObject();
		try {
			param = changeEncode(request, response, DATA);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Gson gson = new Gson();
		TrainModelBean tmb = gson.fromJson(param, TrainModelBean.class);
		int result = 0;
		try {
			result = modelService.trainModel(tmb);
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
	@RequestMapping(value = "getAllModels", method = RequestMethod.POST, produces="text/html; charset=utf-8")
	@ResponseBody
	public String getAllModels(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		JsonObject jsonMsg = new JsonObject();
		List<ModelBean> result;
		try {
			result = modelService.getAllModels();
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
	@RequestMapping(value = "predict", method = RequestMethod.POST)
	@ResponseBody
	public String predict(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String param = "";
		JsonObject jsonMsg = new JsonObject();
		try {
			param = changeEncode(request, response, DATA);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Gson gson = new Gson();
		PredictBean pb = gson.fromJson(param, PredictBean.class);
		int result = 0;
		try {
			result = modelService.predict(pb);
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
	@RequestMapping(value = "deleteModel", method = RequestMethod.POST)
	@ResponseBody
	public String deleteModel(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String param = "";
		JsonObject jsonMsg = new JsonObject();
		try {
			param = changeEncode(request, response, DATA);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Gson gson = new Gson();
		ModelBean mb = gson.fromJson(param, ModelBean.class);
		int result = 0;
		try {
			result = modelService.deleteModelById(mb.getId());
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
