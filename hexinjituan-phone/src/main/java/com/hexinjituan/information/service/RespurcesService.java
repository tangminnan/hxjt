package com.hexinjituan.information.service;

import com.hexinjituan.information.domain.RespurcesDO;

import java.util.List;
import java.util.Map;

/**
 * 人力资源表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-11 17:30:27
 */
public interface RespurcesService {
	
	RespurcesDO get(Integer id);
	
	List<RespurcesDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RespurcesDO respurces);
	
	int update(RespurcesDO respurces);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
