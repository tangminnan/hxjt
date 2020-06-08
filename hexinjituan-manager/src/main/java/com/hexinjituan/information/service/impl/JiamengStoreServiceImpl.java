package com.hexinjituan.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hexinjituan.information.dao.JiamengStoreDao;
import com.hexinjituan.information.domain.JiamengStoreDO;
import com.hexinjituan.information.service.JiamengStoreService;



@Service
public class JiamengStoreServiceImpl implements JiamengStoreService {
	@Autowired
	private JiamengStoreDao jiamengStoreDao;
	
	@Override
	public JiamengStoreDO get(Integer id){
		return jiamengStoreDao.get(id);
	}
	
	@Override
	public List<JiamengStoreDO> list(Map<String, Object> map){
		return jiamengStoreDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return jiamengStoreDao.count(map);
	}
	
	@Override
	public int save(JiamengStoreDO jiamengStore){
		return jiamengStoreDao.save(jiamengStore);
	}
	
	@Override
	public int update(JiamengStoreDO jiamengStore){
		return jiamengStoreDao.update(jiamengStore);
	}
	
	@Override
	public int remove(Integer id){
		return jiamengStoreDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return jiamengStoreDao.batchRemove(ids);
	}
	
}
