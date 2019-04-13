package com.fx.hmwac.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fx.hmwac.domain.UserLoginBean;
import com.fx.hmwac.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	private final String SET_ENCODE = "utf-8";
	private final String SET_TEXTURE = "text/plain";
	private final String DATA = "datal";
	private String changeEncode(HttpServletRequest request, HttpServletResponse response, String paraName) throws UnsupportedEncodingException  {
        request.setCharacterEncoding(SET_ENCODE);
        response.setCharacterEncoding(SET_ENCODE);
        response.setContentType(SET_TEXTURE);
        String msg = request.getParameter(paraName).toString();
        return msg;
    }
	
	@RequestMapping(value="userlogin", method=RequestMethod.POST)
	@ResponseBody
    public String userLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String param = "";
		JsonObject jsonMsg = new JsonObject();
        try {
            param = changeEncode(request, response, DATA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Gson gson = new Gson();
        UserLoginBean user = gson.fromJson(param, UserLoginBean.class);
        UserLoginBean result = null;
        try {
        	result = userService.userLogin(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonMsg.addProperty("status", 1);
			jsonMsg.addProperty("msg", e.getMessage());
			return jsonMsg.toString();
		}
               
        jsonMsg.addProperty("status", 0);
        jsonMsg.addProperty("data", (new Gson()).toJson(result).toString());
        System.out.println(jsonMsg.toString());
        return jsonMsg.toString();
	}
	
}
