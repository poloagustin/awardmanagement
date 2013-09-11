package ar.com.donpepe.awardmanagement.daos.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;

import org.hibernate.*;

import ar.com.donpepe.awardmanagement.daos.GenericDao;
import ar.com.donpepe.awardmanagement.daos.session.HibernateSessionFactory;

public class GenericHibernateDao<T, TId extends Serializable> implements
		GenericDao<T, TId> {
	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericHibernateDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Session session = HibernateSessionFactory.getInstance().createSession();
		List<T> objs = new ArrayList<T>();
		try {
			objs = (List<T>) session.createCriteria(this.persistentClass)
					.list();
		} catch (HibernateException exception) {
			exception.printStackTrace();
		} finally {
			HibernateSessionFactory.getInstance().destroySession(session);
		}
		return objs;
	}

	@SuppressWarnings("unchecked")
	public T get(TId id) {
		Session session = HibernateSessionFactory.getInstance().createSession();
		T obj = null;
		try {
			obj = (T) session.get(this.persistentClass, id);
		} catch (HibernateException exception) {
			exception.printStackTrace();
		} finally {
			HibernateSessionFactory.getInstance().destroySession(session);
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public TId save(T obj) {
		Session session = HibernateSessionFactory.getInstance().createSession();
		TId id = null;
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			id = (TId) session.save(obj);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.getInstance().destroySession(session);
		}
		return id;
	}

	public void update(T obj) {
		Session session = HibernateSessionFactory.getInstance().createSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(obj);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.getInstance().destroySession(session);
		}
	}

	public void delete(T obj) {
		Session session = HibernateSessionFactory.getInstance().createSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(obj);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.getInstance().destroySession(session);
		}
	}

	public static List<Serializable> doBulkAction(
			List<Serializable> objs, BulkOperation bulkOperation) {
		Session session = HibernateSessionFactory.getInstance().createSession();
		List<Serializable> insertedIds = new ArrayList<Serializable>();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			switch (bulkOperation) {
			case INSERT:
				for (Serializable obj : objs) {
					insertedIds.add(session.save(obj));
				}
				break;
			case DELETE:
				for (Serializable obj : objs) {
					session.delete(obj);
				}
				break;
			case UPDATE:
				for (Serializable obj : objs) {
					session.update(obj);
				}
				break;
			default:
				break;
			}

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.getInstance().destroySession(session);
		}

		return insertedIds;
	}
}
