package com.hexinjituan.information.service;

import com.hexinjituan.information.domain.LeaveMsgDO;

import java.util.List;
import java.util.Map;

/**
 * 留言表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 19:38:13
 */
public interface LeaveMsgService {
	
	LeaveMsgDO get(Integer id);
	
	List<LeaveMsgDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LeaveMsgDO leaveMsg);
	
	int update(LeaveMsgDO leaveMsg);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
