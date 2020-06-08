package com.hexinjituan.information.dao;

import com.hexinjituan.information.domain.ZhaoxianDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 招聘表
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 14:10:07
 */
@Mapper
public interface ZhaoxianDao {

	ZhaoxianDO get(Integer id);
	
	List<ZhaoxianDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZhaoxianDO zhaoxian);
	
	int update(ZhaoxianDO zhaoxian);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
