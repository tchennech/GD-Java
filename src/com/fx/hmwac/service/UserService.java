package com.fx.hmwac.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fx.hmwac.dao.UserMapper;
import com.fx.hmwac.domain.UserLoginBean;


@Service
@Scope
public class UserService {
	@Resource
	private UserMapper userMapper;

	public UserLoginBean userLogin(UserLoginBean userlogin) throws Exception {
		UserLoginBean user;
		try {
			user = userMapper.selectBy(userlogin);
			System.out.println(userlogin);
		} catch (Exception e) {
			throw new Exception(e);
		}

		if (user == null) {
			throw new Exception("error username or password");

		}
		return user;
	}

}
