package ar.com.donpepe.awardmanagement.daos.impl;

import ar.com.donpepe.awardmanagement.daos.EntityWithIdDao;
import ar.com.donpepe.awardmanagement.domain.EntityWithId;

public abstract class EntityWithIdDaoImpl<T extends EntityWithId> extends GenericHibernateDao<T, Integer> implements
		EntityWithIdDao<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 698115226494946843L;
	
}
