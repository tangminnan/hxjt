package com.hexinjituan.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hexinjituan.information.dao.LaowuAnliDao;
import com.hexinjituan.information.domain.LaowuAnliDO;
import com.hexinjituan.information.service.LaowuAnliService;



@Service
public class LaowuAnliServiceImpl implements LaowuAnliService {
	@Autowired
	private LaowuAnliDao laowuAnliDao;
	
	@Override
	public LaowuAnliDO get(Integer id){
		return laowuAnliDao.get(id);
	}
	
	@Override
	public List<LaowuAnliDO> list(Map<String, Object> map){
		return laowuAnliDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return laowuAnliDao.count(map);
	}
	
	@Override
	public int save(LaowuAnliDO laowuAnli){
		return laowuAnliDao.save(laowuAnli);
	}
	
	@Override
	public int update(LaowuAnliDO laowuAnli){
		return laowuAnliDao.update(laowuAnli);
	}
	
	@Override
	public int remove(Integer id){
		return laowuAnliDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return laowuAnliDao.batchRemove(ids);
	}
	
}
