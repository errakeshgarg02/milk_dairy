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
public abstract class CommonDAO {
	
	private static Log LOG = LogFactory.getLog(CommonDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * 
	 * @param commerceObject
	 * @throws DAOException
	 */
	public void save(Object commerceObject) throws DAOException {
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
	public void delete(Object commerceObject) throws DAOException{
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
	public List findAll(Class clazz) throws DAOException{
		LOG.info("findAll");
		List resultList  = null;
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
	public List findByValue(Class clazz, String variable, String name) throws DAOException{
		LOG.info("findByName");
		List resultList  = null;
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
	public void update(Object commerceObject) throws DAOException{
		LOG.info("update object");
		try {
			entityManager.merge(commerceObject);
			
		}catch (Exception e) {
			throw new DAOException(e.getMessage(),e);
		}	
	}
	
	public Object getLastRecord(Class clazz) throws DAOException {
		LOG.info("getLastRecord");
		Object obj  = null;
		try {
			obj = entityManager.createQuery("from "+clazz.getName()+" order by CREATED_DATE DESC").setMaxResults(1).getResultList().get(0);
						
		}catch (Exception e) {
			throw new DAOException(e.getMessage(),e);
		}	
		return obj;
	}
	
}
