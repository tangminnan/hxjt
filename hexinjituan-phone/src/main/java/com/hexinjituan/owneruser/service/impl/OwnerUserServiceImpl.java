package com.hexinjituan.owneruser.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexinjituan.common.config.BootdoConfig;
import com.hexinjituan.common.service.FileService;
import com.hexinjituan.owneruser.dao.OwnerUserDao;
import com.hexinjituan.owneruser.domain.OwnerUserDO;
import com.hexinjituan.owneruser.service.OwnerUserService;



@Transactional
@Service
public class OwnerUserServiceImpl implements OwnerUserService {
	@Autowired
	OwnerUserDao ownerUserMapper;
	@Autowired
	private FileService sysFileService;
	@Autowired
	private BootdoConfig bootdoConfig;
/*	private static final Logger logger = LoggerFactory.getLogger(UserService.class);*/

	@Override
	public OwnerUserDO get(Long id) {
		OwnerUserDO user = ownerUserMapper.get(id);
		return user;
	}
	
	@Override
	public OwnerUserDO getbyname(String username){
		
		OwnerUserDO user = ownerUserMapper.getbyname(username);
		return user;
	}

	@Override
	public List<OwnerUserDO> list(Map<String, Object> map) {
		return ownerUserMapper.list(map);
	}

	@Override
	public int save(OwnerUserDO user){
		return ownerUserMapper.save(user);
	}
	
	@Override
	public int count(Map<String, Object> map) {
		return ownerUserMapper.count(map);
	}


	@Override
	public int update(OwnerUserDO user) {
		int r = ownerUserMapper.update(user);
		
		return r;
	}

	@Override
	public int remove(Long userId) {
		/*userRoleMapper.removeByUserId(userId);*/
		return ownerUserMapper.remove(userId);
	}

	@Override
	public boolean exit(Map<String, Object> params) {
		boolean exit;
		exit = ownerUserMapper.list(params).size() > 0;
		return exit;
	}



}
