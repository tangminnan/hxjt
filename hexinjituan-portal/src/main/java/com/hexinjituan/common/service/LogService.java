package com.hexinjituan.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexinjituan.common.domain.LogDO;
import com.hexinjituan.common.domain.PageDO;
import com.hexinjituan.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
