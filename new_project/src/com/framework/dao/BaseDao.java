package com.framework.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	public T save(T entity);
	
	public void update(T entity);
	
	public void delete(Serializable id);
	
	public Serializable merge(Object obj);
	
	public T findById(Serializable id);
	
	public List<T> findByIds(String[] ids);
	/**
	 * 这里的sql是指定查询sql
	 * @param sql
	 * @return
	 */
	public int getSqlCount(String sql);
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public List<Map<String,Object>> findBySqlList(String sql);
	
	/**
	 * 带分页查询结果集封装
	 * @param sql
	 * @param start
	 * @param limit
	 * @return
	 */
	public Map<String,Object> findBySqlMap(String sql,Integer start,int limit);
}
