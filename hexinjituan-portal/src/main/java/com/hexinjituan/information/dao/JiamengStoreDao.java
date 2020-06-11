package com.hexinjituan.information.dao;

import com.hexinjituan.information.domain.JiamengStoreDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 直营加盟店铺
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 16:56:43
 */
@Mapper
public interface JiamengStoreDao {

	JiamengStoreDO get(Integer id);
	
	List<JiamengStoreDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(JiamengStoreDO jiamengStore);
	
	int update(JiamengStoreDO jiamengStore);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
