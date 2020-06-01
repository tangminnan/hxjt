package com.hexinjituan.information.service;

import com.hexinjituan.information.domain.CompanyGongchengDO;

import java.util.List;
import java.util.Map;

/**
 * 业务工程表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-01 13:39:38
 */
public interface CompanyGongchengService {
	
	CompanyGongchengDO get(Integer id);
	
	List<CompanyGongchengDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CompanyGongchengDO companyGongcheng);
	
	int update(CompanyGongchengDO companyGongcheng);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
