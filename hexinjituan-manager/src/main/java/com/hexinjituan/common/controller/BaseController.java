package com.hexinjituan.common.controller;

import org.springframework.stereotype.Controller;

import com.hexinjituan.common.utils.ShiroUtils;
import com.hexinjituan.system.domain.UserDO;
import com.hexinjituan.system.domain.UserToken;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}