package com.hexinjituan.information.service;

import com.hexinjituan.information.domain.LaowuAnliCateDO;

import java.util.List;
import java.util.Map;

/**
 * 劳务案例分裂表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 11:24:45
 */
public interface LaowuAnliCateService {
	
	LaowuAnliCateDO get(Integer id);
	
	List<LaowuAnliCateDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LaowuAnliCateDO laowuAnliCate);
	
	int update(LaowuAnliCateDO laowuAnliCate);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
