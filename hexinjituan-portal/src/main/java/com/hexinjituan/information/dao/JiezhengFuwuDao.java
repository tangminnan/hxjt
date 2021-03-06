package com.hexinjituan.information.dao;

import com.hexinjituan.information.domain.JiezhengFuwuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 家政服务表
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 20:22:37
 */
@Mapper
public interface JiezhengFuwuDao {

	JiezhengFuwuDO get(Integer id);
	
	List<JiezhengFuwuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(JiezhengFuwuDO jiezhengFuwu);
	
	int update(JiezhengFuwuDO jiezhengFuwu);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<JiezhengFuwuDO> fuwulist();
}
