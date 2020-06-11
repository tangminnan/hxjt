package com.hexinjituan.information.service.impl;

import com.hexinjituan.information.dao.LaowuAnliCateDao;
import com.hexinjituan.information.domain.LaowuAnliCateDO;
import com.hexinjituan.information.service.LaowuAnliCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class LaowuAnliCateServiceImpl implements LaowuAnliCateService {
	@Autowired
	private LaowuAnliCateDao laowuAnliCateDao;
	
	@Override
	public LaowuAnliCateDO get(Integer id){
		return laowuAnliCateDao.get(id);
	}
	
	@Override
	public List<LaowuAnliCateDO> list(Map<String, Object> map){
		return laowuAnliCateDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return laowuAnliCateDao.count(map);
	}
	
	@Override
	public int save(LaowuAnliCateDO laowuAnliCate){
		return laowuAnliCateDao.save(laowuAnliCate);
	}
	
	@Override
	public int update(LaowuAnliCateDO laowuAnliCate){
		return laowuAnliCateDao.update(laowuAnliCate);
	}
	
	@Override
	public int remove(Integer id){
		return laowuAnliCateDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return laowuAnliCateDao.batchRemove(ids);
	}
	
}
