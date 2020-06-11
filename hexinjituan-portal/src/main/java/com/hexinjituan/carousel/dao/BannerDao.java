package com.hexinjituan.carousel.dao;

import com.hexinjituan.carousel.domain.BannerDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 轮播图表
 * @author wjl
 */
@Mapper
public interface BannerDao {

	BannerDO get(Long id);
	
	List<BannerDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(BannerDO file);
	
	int update(BannerDO file);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
