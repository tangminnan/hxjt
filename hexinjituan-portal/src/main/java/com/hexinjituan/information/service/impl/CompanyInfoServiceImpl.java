package com.hexinjituan.information.service.impl;

import com.hexinjituan.information.dao.CompanyInfoDao;
import com.hexinjituan.information.domain.CompanyInfoDO;
import com.hexinjituan.information.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {
	@Autowired
	private CompanyInfoDao companyInfoDao;
	
	@Override
	public CompanyInfoDO get(Integer id){
		return companyInfoDao.get(id);
	}
	
	@Override
	public List<CompanyInfoDO> list(Map<String, Object> map){
		return companyInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return companyInfoDao.count(map);
	}
	
	@Override
	public int save(CompanyInfoDO companyInfo){
		return companyInfoDao.save(companyInfo);
	}
	
	@Override
	public int update(CompanyInfoDO companyInfo){
		return companyInfoDao.update(companyInfo);
	}
	
	@Override
	public int remove(Integer id){
		return companyInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return companyInfoDao.batchRemove(ids);
	}
	
}
