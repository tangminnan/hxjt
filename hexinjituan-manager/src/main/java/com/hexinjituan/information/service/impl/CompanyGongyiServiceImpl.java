package com.hexinjituan.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hexinjituan.information.dao.CompanyGongyiDao;
import com.hexinjituan.information.domain.CompanyGongyiDO;
import com.hexinjituan.information.service.CompanyGongyiService;



@Service
public class CompanyGongyiServiceImpl implements CompanyGongyiService {
	@Autowired
	private CompanyGongyiDao companyGongyiDao;
	
	@Override
	public CompanyGongyiDO get(Integer id){
		return companyGongyiDao.get(id);
	}
	
	@Override
	public List<CompanyGongyiDO> list(Map<String, Object> map){
		return companyGongyiDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return companyGongyiDao.count(map);
	}
	
	@Override
	public int save(CompanyGongyiDO companyGongyi){
		return companyGongyiDao.save(companyGongyi);
	}
	
	@Override
	public int update(CompanyGongyiDO companyGongyi){
		return companyGongyiDao.update(companyGongyi);
	}
	
	@Override
	public int remove(Integer id){
		return companyGongyiDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return companyGongyiDao.batchRemove(ids);
	}
	
}
