package com.hexinjituan.information.dao;

import com.hexinjituan.information.domain.LeaveMsgDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 留言表
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 19:38:13
 */
@Mapper
public interface LeaveMsgDao {

	LeaveMsgDO get(Integer id);
	
	List<LeaveMsgDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LeaveMsgDO leaveMsg);
	
	int update(LeaveMsgDO leaveMsg);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
