package ar.com.donpepe.awardmanagement.daos.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import ar.com.donpepe.awardmanagement.daos.GenericDao;

public abstract class GenericHibernateDao<T, TId extends Serializable>
		implements GenericDao<T, TId> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 809515827287293892L;
	private Class<T> persistentClass;

	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public GenericHibernateDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public List<T> getAll() {
		List<T> objs = new ArrayList<T>();
		try {
			objs = this.hibernateTemplate.loadAll(this.persistentClass);
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return objs;
	}

	public T get(TId id) {
		T obj = null;
		try {
			obj = this.hibernateTemplate.get(this.persistentClass, id);
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	// @Transactional
	public TId save(T obj) {
		TId id = null;
		try {
			id = (TId) this.hibernateTemplate.save(obj);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return id;
	}

	// @Transactional
	public void update(T obj) {
		try {
			this.hibernateTemplate.update(obj);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void delete(T obj) {
		try {
			this.hibernateTemplate.delete(obj);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public List<Serializable> doBulkAction(List<Serializable> objs,
			BulkOperation bulkOperation) {
		List<Serializable> insertedIds = new ArrayList<Serializable>();
		try {
			switch (bulkOperation) {
			case INSERT:
				for (Serializable obj : objs) {
					insertedIds.add(this.hibernateTemplate.save(obj));
				}
				break;
			case DELETE:
				for (Serializable obj : objs) {
					this.hibernateTemplate.delete(obj);
				}
				break;
			case UPDATE:
				for (Serializable obj : objs) {
					this.hibernateTemplate.update(obj);
				}
				break;
			default:
				break;
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return insertedIds;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	protected DetachedCriteria getMyCriteria() {
		return DetachedCriteria.forClass(this.persistentClass);
	}
}
