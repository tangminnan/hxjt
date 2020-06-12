package com.hexinjituan.information.service;

import com.hexinjituan.information.domain.SkillTrainingDO;

import java.util.List;
import java.util.Map;

/**
 * 送技术下乡
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-02 14:22:56
 */
public interface SkillTrainingService {
	
	SkillTrainingDO get(Integer id);
	
	List<SkillTrainingDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SkillTrainingDO skillTraining);
	
	int update(SkillTrainingDO skillTraining);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
