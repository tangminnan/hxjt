package com.hexinjituan.information.dao;

import com.hexinjituan.information.domain.HezuosheDO;
import com.hexinjituan.information.domain.HezuosheShouyeDO;
import com.hexinjituan.information.domain.LaowuAnliCateDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 合作社分社
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-06 20:04:23
 */
@Mapper
public interface HezuosheDao {

	HezuosheDO get(Integer id);
	
	List<HezuosheDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HezuosheDO hezuoshe);
	
	int update(HezuosheDO hezuoshe);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

    List<HezuosheShouyeDO> listHezuosheShouyeDO(Map<String, Object> map);

	int updateHezuosheShouyeDO(HezuosheShouyeDO hezuosheShouyeDO);

	int saveHezuosheShouyeDO(HezuosheShouyeDO hezuosheShouyeDO);

    List<LaowuAnliCateDO> listLaowuAll(String s);
}
