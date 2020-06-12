package com.hexinjituan.information.service.impl;

import com.hexinjituan.information.dao.HezuosheDao;
import com.hexinjituan.information.domain.HezuosheDO;
import com.hexinjituan.information.domain.HezuosheShouyeDO;
import com.hexinjituan.information.service.HezuosheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class HezuosheServiceImpl implements HezuosheService {
	@Autowired
	private HezuosheDao hezuosheDao;
	
	@Override
	public HezuosheDO get(Integer id){
		return hezuosheDao.get(id);
	}
	
	@Override
	public List<HezuosheDO> list(Map<String, Object> map){
		return hezuosheDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return hezuosheDao.count(map);
	}
	
	@Override
	public int save(HezuosheDO hezuoshe){
		return hezuosheDao.save(hezuoshe);
	}
	
	@Override
	public int update(HezuosheDO hezuoshe){
		return hezuosheDao.update(hezuoshe);
	}
	
	@Override
	public int remove(Integer id){
		return hezuosheDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return hezuosheDao.batchRemove(ids);
	}

	@Override
	public List<HezuosheShouyeDO> listHezuosheShouyeDO(Map<String, Object> map) {
		return hezuosheDao.listHezuosheShouyeDO(map);
	}

	@Override
	public int updateHezuosheShouyeDO(HezuosheShouyeDO hezuosheShouyeDO) {
		return hezuosheDao.updateHezuosheShouyeDO(hezuosheShouyeDO);
	}

	@Override
	public int saveHezuosheShouyeDO(HezuosheShouyeDO hezuosheShouyeDO) {
		return hezuosheDao.saveHezuosheShouyeDO(hezuosheShouyeDO);
	}

}
