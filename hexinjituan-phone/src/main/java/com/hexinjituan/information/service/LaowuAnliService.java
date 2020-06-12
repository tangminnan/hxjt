package com.hexinjituan.information.service;

import com.hexinjituan.information.domain.LaowuAnliDO;

import java.util.List;
import java.util.Map;

/**
 * 劳务案例表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 09:59:57
 */
public interface LaowuAnliService {
	
	LaowuAnliDO get(Integer id);
	
	List<LaowuAnliDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LaowuAnliDO laowuAnli);
	
	int update(LaowuAnliDO laowuAnli);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
