package com.hexinjituan.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hexinjituan.information.dao.RespurcesDao;
import com.hexinjituan.information.domain.RespurcesDO;
import com.hexinjituan.information.service.RespurcesService;



@Service
public class RespurcesServiceImpl implements RespurcesService {
	@Autowired
	private RespurcesDao respurcesDao;
	
	@Override
	public RespurcesDO get(Integer id){
		return respurcesDao.get(id);
	}
	
	@Override
	public List<RespurcesDO> list(Map<String, Object> map){
		return respurcesDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return respurcesDao.count(map);
	}
	
	@Override
	public int save(RespurcesDO respurces){
		return respurcesDao.save(respurces);
	}
	
	@Override
	public int update(RespurcesDO respurces){
		return respurcesDao.update(respurces);
	}
	
	@Override
	public int remove(Integer id){
		return respurcesDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return respurcesDao.batchRemove(ids);
	}
	
}
