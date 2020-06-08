package com.hexinjituan.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hexinjituan.information.dao.ZhaoxianDao;
import com.hexinjituan.information.domain.ZhaoxianDO;
import com.hexinjituan.information.service.ZhaoxianService;



@Service
public class ZhaoxianServiceImpl implements ZhaoxianService {
	@Autowired
	private ZhaoxianDao zhaoxianDao;
	
	@Override
	public ZhaoxianDO get(Integer id){
		return zhaoxianDao.get(id);
	}
	
	@Override
	public List<ZhaoxianDO> list(Map<String, Object> map){
		return zhaoxianDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return zhaoxianDao.count(map);
	}
	
	@Override
	public int save(ZhaoxianDO zhaoxian){
		return zhaoxianDao.save(zhaoxian);
	}
	
	@Override
	public int update(ZhaoxianDO zhaoxian){
		return zhaoxianDao.update(zhaoxian);
	}
	
	@Override
	public int remove(Integer id){
		return zhaoxianDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return zhaoxianDao.batchRemove(ids);
	}
	
}
