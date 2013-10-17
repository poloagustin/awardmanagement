package ar.com.donpepe.awardmanagement.daos.impl;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import ar.com.donpepe.awardmanagement.daos.SaleDao;
import ar.com.donpepe.awardmanagement.daos.impl.EntityWithIdDaoImpl;
import ar.com.donpepe.awardmanagement.domain.Sale;

public class SaleDaoImpl extends EntityWithIdDaoImpl<Sale> implements SaleDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1120189426185910853L;

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

		
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Sale.class);
			criteria = criteria.add(
				Restrictions.and(
					Restrictions.eq("user", userId),
					Restrictions.between("date", firstDayOfMonth, lastDayOfMonth)
				)
			);
			salesByUser = super.getHibernateTemplate().findByCriteria(criteria);
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return salesByUser;
	}

	@Override
	public Sale getSaleByNumber(String number) {
		// TODO Auto-generated method stub
		Sale sale = new Sale();
		try {
			DetachedCriteria criteria = super.getMyCriteria().add(Restrictions.eq("number", number));
			sale = (Sale)super.getHibernateTemplate().findByCriteria(criteria);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return sale;
	}
}