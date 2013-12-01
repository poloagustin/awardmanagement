package ar.com.donpepe.awardmanagement.daos.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import ar.com.donpepe.awardmanagement.daos.UserDao;
import ar.com.donpepe.awardmanagement.domain.User;
import ar.com.donpepe.awardmanagement.services.mappers.UserMapper;

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
			DetachedCriteria criteria = super.getMyCriteria()
					.add(Restrictions.like("username", username,
							MatchMode.ANYWHERE));
			users = (List<User>) super.getHibernateTemplate().findByCriteria(
					criteria);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getByUsernameAndPassword(String username, String password) {
		User user = null;
		try {
			DetachedCriteria criteria = super.getMyCriteria().add(
					Restrictions.and(Restrictions.eq("username", username),
							Restrictions.eq("password", password)));
			List<User> users = (List<User>) super.getHibernateTemplate()
					.findByCriteria(criteria, 0, 1);
			
			if (users.size() > 0) {
				user = users.get(0);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> getUsersSalerMans() {
		// TODO Auto-generated method stub
		List<User> users = null;
		try {
			DetachedCriteria criteria = super.getMyCriteria().add(Restrictions.like("role", UserMapper.getRoleAsEnum("Vendedor")));
			users = (List<User>)super.getHibernateTemplate().findByCriteria(criteria);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return users;
	}
}
