package com.hexinjituan.information.service.impl;

import com.hexinjituan.information.dao.CompanyGongchengDao;
import com.hexinjituan.information.domain.CompanyGongchengDO;
import com.hexinjituan.information.service.CompanyGongchengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CompanyGongchengServiceImpl implements CompanyGongchengService {
	@Autowired
	private CompanyGongchengDao companyGongchengDao;
	
	@Override
	public CompanyGongchengDO get(Integer id){
		return companyGongchengDao.get(id);
	}
	
	@Override
	public List<CompanyGongchengDO> list(Map<String, Object> map){
		return companyGongchengDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return companyGongchengDao.count(map);
	}
	
	@Override
	public int save(CompanyGongchengDO companyGongcheng){
		return companyGongchengDao.save(companyGongcheng);
	}
	
	@Override
	public int update(CompanyGongchengDO companyGongcheng){
		return companyGongchengDao.update(companyGongcheng);
	}
	
	@Override
	public int remove(Integer id){
		return companyGongchengDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return companyGongchengDao.batchRemove(ids);
	}
	
}
