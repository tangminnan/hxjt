package com.hexinjituan.carousel.service;

import com.hexinjituan.carousel.domain.BannerDO;

import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * 
 * @author wjl
 */
public interface BannerService {
	
	BannerDO get(Long id);
	
	List<BannerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BannerDO sysFile);
	
	int update(BannerDO sysFile);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	/**
	 * 判断一个文件是否存在
	 * @param url FileDO中存的路径
	 * @return
	 */
    Boolean isExist(String url);
}
