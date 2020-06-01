package com.hexinjituan.information.service;

import com.hexinjituan.information.domain.CompanyInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 就业公司表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-05-27 17:12:49
 */
public interface CompanyInfoService {
	
	CompanyInfoDO get(Integer id);
	
	List<CompanyInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CompanyInfoDO companyInfo);
	
	int update(CompanyInfoDO companyInfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
