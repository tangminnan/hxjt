package com.hexinjituan.information.service;

import com.hexinjituan.information.domain.CompanyGongyiDO;

import java.util.List;
import java.util.Map;

/**
 * 慈善公益表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-01 16:08:42
 */
public interface CompanyGongyiService {
	
	CompanyGongyiDO get(Integer id);
	
	List<CompanyGongyiDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CompanyGongyiDO companyGongyi);
	
	int update(CompanyGongyiDO companyGongyi);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
