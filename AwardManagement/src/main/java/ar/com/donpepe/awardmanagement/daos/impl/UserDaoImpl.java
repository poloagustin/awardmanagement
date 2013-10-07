package ar.com.donpepe.awardmanagement.daos.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import ar.com.donpepe.awardmanagement.daos.UserDao;
import ar.com.donpepe.awardmanagement.domain.User;

public class UserDaoImpl extends EntityWithIdDaoImpl<User> implements UserDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9187333192179118652L;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByUsername(String username) {
		List<User> users = null;
		try {
			DetachedCriteria criteria = super.getMyCriteria().add(Restrictions.like("username", username, MatchMode.ANYWHERE));
			users = (List<User>)super.getHibernateTemplate().findByCriteria(criteria);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return users;
	}
}
