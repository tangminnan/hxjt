package com.hexinjituan.information.service.impl;

import com.hexinjituan.information.dao.StudentsElegantDao;
import com.hexinjituan.information.domain.StudentsElegantDO;
import com.hexinjituan.information.service.StudentsElegantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class StudentsElegantServiceImpl implements StudentsElegantService {
	@Autowired
	private StudentsElegantDao studentsElegantDao;
	
	@Override
	public StudentsElegantDO get(Integer id){
		return studentsElegantDao.get(id);
	}
	
	@Override
	public List<StudentsElegantDO> list(Map<String, Object> map){
		return studentsElegantDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return studentsElegantDao.count(map);
	}
	
	@Override
	public int save(StudentsElegantDO studentsElegant){
		return studentsElegantDao.save(studentsElegant);
	}
	
	@Override
	public int update(StudentsElegantDO studentsElegant){
		return studentsElegantDao.update(studentsElegant);
	}
	
	@Override
	public int remove(Integer id){
		return studentsElegantDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return studentsElegantDao.batchRemove(ids);
	}
	
}
