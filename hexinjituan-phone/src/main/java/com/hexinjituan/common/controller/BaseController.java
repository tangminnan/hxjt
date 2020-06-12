package com.hexinjituan.common.controller;

import org.springframework.stereotype.Controller;

import com.hexinjituan.common.utils.ShiroUtils;
import com.hexinjituan.owneruser.domain.OwnerUserDO;
import com.hexinjituan.system.domain.UserToken;

@Controller
public class BaseController {
	public OwnerUserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}