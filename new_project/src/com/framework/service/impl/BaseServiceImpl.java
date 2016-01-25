package com.framework.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.framework.dao.BaseDao;
import com.framework.service.BaseService;


@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T> {

	private BaseDao<T> baseDao;
	public void setBaseDao(BaseDao<T> baseDao){
		this.baseDao = baseDao;
	}
	
	public T save(T entity) {
		
		return baseDao.save(entity);
	}

	public void update(T entity) {
		
		baseDao.update(entity);
	}

	public void delete(Serializable id) {
		
		baseDao.delete(id);
	}

	public Serializable merge(Object obj) {
		
		return baseDao.merge(obj);
	}

	public T findById(Serializable id) {
		
		return baseDao.findById(id);
	}

	public List<T> findByIds(String[] ids) {
		
		return baseDao.findByIds(ids);
	}

	public int getSqlCount(String sql) {
		
		return baseDao.getSqlCount(sql);
	}

	public List<Map<String, Object>> findBySqlList(String sql) {
		
		return baseDao.findBySqlList(sql);
	}

	public Map<String, Object> findBySqlMap(String sql, Integer start, int limit) {
		
		return baseDao.findBySqlMap(sql, start, limit);
	}

}
