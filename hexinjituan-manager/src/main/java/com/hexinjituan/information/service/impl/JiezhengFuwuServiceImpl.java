package com.hexinjituan.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hexinjituan.information.dao.JiezhengFuwuDao;
import com.hexinjituan.information.domain.JiezhengFuwuDO;
import com.hexinjituan.information.service.JiezhengFuwuService;



@Service
public class JiezhengFuwuServiceImpl implements JiezhengFuwuService {
	@Autowired
	private JiezhengFuwuDao jiezhengFuwuDao;
	
	@Override
	public JiezhengFuwuDO get(Integer id){
		return jiezhengFuwuDao.get(id);
	}
	
	@Override
	public List<JiezhengFuwuDO> list(Map<String, Object> map){
		return jiezhengFuwuDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return jiezhengFuwuDao.count(map);
	}
	
	@Override
	public int save(JiezhengFuwuDO jiezhengFuwu){
		return jiezhengFuwuDao.save(jiezhengFuwu);
	}
	
	@Override
	public int update(JiezhengFuwuDO jiezhengFuwu){
		return jiezhengFuwuDao.update(jiezhengFuwu);
	}
	
	@Override
	public int remove(Integer id){
		return jiezhengFuwuDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return jiezhengFuwuDao.batchRemove(ids);
	}
	
}
