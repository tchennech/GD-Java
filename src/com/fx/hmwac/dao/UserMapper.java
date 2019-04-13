package com.fx.hmwac.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fx.hmwac.domain.UserLoginBean;

public interface UserMapper {
	
	public UserLoginBean selectBy(UserLoginBean user);

}
