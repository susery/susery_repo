package com.framework.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.framework.dao.BaseDao;
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	private Class<T> clazz;
	public BaseDaoImpl() {
		ParameterizedType pt =  (ParameterizedType)getClass().getGenericSuperclass();//BaseDaoImpl<T>
		clazz = (Class<T>)pt.getActualTypeArguments()[0];
	}

	protected Session getDefaultSession(){
		if(sessionFactory!=null){
			return sessionFactory.getCurrentSession();
		}else{
			return null;
		}
	}

	public T save(T entity) {
		return (T) getDefaultSession().save(entity);
	}
	
	public void update(T entity) {
		getDefaultSession().update(entity);;
	}

	public void delete(Serializable id) {
		T thisObj = findById(id);
		getDefaultSession().delete(thisObj);
	}

	public Serializable merge(Object obj) {
		return (Serializable) getDefaultSession().merge(obj);
	}

	public T findById(Serializable id) {
		return (T) getDefaultSession().get(this.clazz, id);
	}

	public List<T> findByIds(String[] ids) {
		List<T> list = new ArrayList<T>();
		if(ids.length>0){
			for (int i = 0; i < ids.length; i++) {
				String id = ids[i];
				if(StringUtils.isNotBlank(id)){
					T obj = findById(Long.parseLong(id));
					if(obj!=null){
						list.add(obj);
					}
				}
			}
		}
		return list;
	}
	public int getSqlCount(String sql){
		String countSql = "select count(1) from ("+sql+")";
		SQLQuery query = getDefaultSession().createSQLQuery(countSql);
		return 0;
	}
	public List<Map<String, Object>> findBySqlList(String sql) {
		List<Map<String, Object>> list = null;
		if(StringUtils.isNotBlank(sql)){
			Query query = getDefaultSession().createSQLQuery(sql);
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list = query.list();
		}
		return list;
	}

	public Map<String, Object> findBySqlMap(String sql, Integer start, int limit) {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		String pageSql = "";
		if(start>=0 && limit>0){
			pageSql = "select * from ("+ sql +")"+" LIMIT "+ start +","+limit;
		}else{
			pageSql = sql;
		}
		/*if(start== null && limit==0){
			pageSql = sql;
		}else if(start >0 && limit==0){
			pageSql = sql;
		}else{
			pageSql = "select * from ("+ sql +")"+" LIMIT "+ start +","+limit;
		}*/
		
		if (StringUtils.isNotBlank(pageSql)) {
			List<Map<String, Object>> sqlList = findBySqlList(pageSql);
			resultMap.put("rows", sqlList);
			resultMap.put("total", getSqlCount(pageSql));
		}
		return resultMap;
	}

}
