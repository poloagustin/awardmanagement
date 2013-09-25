package ar.com.donpepe.awardmanagement.daos.impl;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import ar.com.donpepe.awardmanagement.daos.SaleDao;
import ar.com.donpepe.awardmanagement.daos.session.HibernateSessionFactory;
import ar.com.donpepe.awardmanagement.domain.Sale;

public class SaleDaoImpl extends EntityWithIdDaoImpl<Sale> implements SaleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Sale> getSalesByUserId(Integer userId) {
		List<Sale> salesByUser = null;
		
		Date firstDayOfMonth = null;
		Date lastDayOfMonth = null;
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
		firstDayOfMonth = calendar.getTime();
		
		calendar.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
		firstDayOfMonth = calendar.getTime();

		Session session = HibernateSessionFactory.getInstance().createSession();

		try {
			Criteria criteria = session.createCriteria(Sale.class);
			criteria = criteria.add(
				Restrictions.and(
					Restrictions.eq("user", userId),
					Restrictions.and(
						Restrictions.ge("date", firstDayOfMonth),
						Restrictions.le("date", lastDayOfMonth)
					)
				)
			);
			salesByUser = (List<Sale>)criteria.list();
		} catch (HibernateException exception) {
			exception.printStackTrace();
		} finally {
			HibernateSessionFactory.getInstance().destroySession(session);
		}

		return salesByUser;
	}
}
