package com.hexinjituan.information.dao;

import com.hexinjituan.information.domain.StudentsElegantDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 轮播图表
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-02 10:21:35
 */
@Mapper
public interface StudentsElegantDao {

	StudentsElegantDO get(Integer id);
	
	List<StudentsElegantDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(StudentsElegantDO studentsElegant);
	
	int update(StudentsElegantDO studentsElegant);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
