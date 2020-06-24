package com.hexinjituan.information.dao;

import com.hexinjituan.information.domain.CompanyGongchengDO;
import com.hexinjituan.information.domain.CompanyInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 业务工程表
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-01 13:39:38
 */
@Mapper
public interface CompanyGongchengDao {

	CompanyGongchengDO get(Integer id);
	
	List<CompanyGongchengDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CompanyGongchengDO companyGongcheng);
	
	int update(CompanyGongchengDO companyGongcheng);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	CompanyInfoDO getG();
}
