package com.rakesh.milk.dairy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.rakesh.milk.dairy.exception.DAOException;

/**
 * 
 * @author rakesh.kumar
 *
 */
@Repository
public abstract class CommonDAO<R> {
	
	private static Log LOG = LogFactory.getLog(CommonDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * 
	 * @param commerceObject
	 * @throws DAOException
	 */
	public void save(R commerceObject) throws DAOException {
		LOG.info("saving object");
		try {
			entityManager.persist(commerceObject);
			
		}catch (Exception e) {
			throw new DAOException(e.getMessage(),e);
		}		
	}
	
	/**
	 * 
	 * @param commerceObject
	 * @throws DAOException
	 */
	public void delete(R commerceObject) throws DAOException{
		LOG.info("deleting object");
		try {
			
			if(entityManager.contains(commerceObject)) {
				entityManager.remove(commerceObject);
			}else {
				entityManager.remove(entityManager.merge(commerceObject));
			}
			
		}catch (Exception e) {
			throw new DAOException(e.getMessage(),e);
		}
	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 * @throws DAOException
	 */
	public List<R> findAll(Class clazz) throws DAOException{
		LOG.info("findAll");
		List<R> resultList  = null;
		try {
			Query createQuery = entityManager.createQuery("from "+clazz.getName());
			resultList = createQuery.getResultList();
		}catch (Exception e) {
			throw new DAOException(e.getMessage(),e);
		}	
		return resultList;
	}
	
	/**
	 * 
	 * @param clazz
	 * @param variable
	 * @param name
	 * @return
	 * @throws DAOException
	 */
	public List<R> findByValue(Class clazz, String variable, Object name) throws DAOException{
		LOG.info("findByValue method variable ::"+variable+" and value::"+name);
		List<R> resultList  = null;
		try {
			resultList = entityManager.createQuery("from "+clazz.getName()+" where "+variable+" = :name").setParameter("name", name).getResultList();
						
		}catch (Exception e) {
			throw new DAOException(e.getMessage(),e);
		}	
		return resultList;
	}
	
	/**
	 * 
	 * @param commerceObject
	 * @throws DAOException
	 */
	public void update(R commerceObject) throws DAOException{
		LOG.info("update object");
		try {
			entityManager.merge(commerceObject);
			
		}catch (Exception e) {
			throw new DAOException(e.getMessage(),e);
		}	
	}
	
	public R getLastRecord(Class clazz) throws DAOException {
		LOG.info("getLastRecord");
		R obj  = null;
		try {
			List<R> resultList = entityManager.createQuery("from "+clazz.getName()+" order by CREATED_DATE DESC").setMaxResults(1).getResultList();
			LOG.info("getLastRecord list size :"+resultList.size());
			if(resultList != null && resultList.size() == 1) {
				obj = resultList.get(0);
			}
						
		}catch (Exception e) {
			throw new DAOException(e.getMessage(),e);
		}	
		return obj;
	}

	
}
