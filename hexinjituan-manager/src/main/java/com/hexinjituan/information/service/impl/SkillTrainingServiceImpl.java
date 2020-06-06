package com.hexinjituan.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hexinjituan.information.dao.SkillTrainingDao;
import com.hexinjituan.information.domain.SkillTrainingDO;
import com.hexinjituan.information.service.SkillTrainingService;



@Service
public class SkillTrainingServiceImpl implements SkillTrainingService {
	@Autowired
	private SkillTrainingDao skillTrainingDao;
	
	@Override
	public SkillTrainingDO get(Integer id){
		return skillTrainingDao.get(id);
	}
	
	@Override
	public List<SkillTrainingDO> list(Map<String, Object> map){
		return skillTrainingDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return skillTrainingDao.count(map);
	}
	
	@Override
	public int save(SkillTrainingDO skillTraining){
		return skillTrainingDao.save(skillTraining);
	}
	
	@Override
	public int update(SkillTrainingDO skillTraining){
		return skillTrainingDao.update(skillTraining);
	}
	
	@Override
	public int remove(Integer id){
		return skillTrainingDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return skillTrainingDao.batchRemove(ids);
	}
	
}
