package com.hexinjituan.information.service.impl;

import com.hexinjituan.information.dao.LeaveMsgDao;
import com.hexinjituan.information.domain.LeaveMsgDO;
import com.hexinjituan.information.service.LeaveMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class LeaveMsgServiceImpl implements LeaveMsgService {
	@Autowired
	private LeaveMsgDao leaveMsgDao;
	
	@Override
	public LeaveMsgDO get(Integer id){
		return leaveMsgDao.get(id);
	}
	
	@Override
	public List<LeaveMsgDO> list(Map<String, Object> map){
		return leaveMsgDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return leaveMsgDao.count(map);
	}
	
	@Override
	public int save(LeaveMsgDO leaveMsg){
		return leaveMsgDao.save(leaveMsg);
	}
	
	@Override
	public int update(LeaveMsgDO leaveMsg){
		return leaveMsgDao.update(leaveMsg);
	}
	
	@Override
	public int remove(Integer id){
		return leaveMsgDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return leaveMsgDao.batchRemove(ids);
	}
	
}
