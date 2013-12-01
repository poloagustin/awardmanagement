package ar.com.donpepe.awardmanagement.daos.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import ar.com.donpepe.awardmanagement.daos.SaleCommissionDao;
import ar.com.donpepe.awardmanagement.domain.Sale;
import ar.com.donpepe.awardmanagement.domain.SaleCommission;

public class SaleCommissionDaoImpl extends EntityWithIdDaoImpl<SaleCommission> implements
		SaleCommissionDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9187333192179118652L;

	@SuppressWarnings("unchecked")
	@Override
	public List<SaleCommission> getByAmmount(Integer salesAmount) {
		List<SaleCommission> commissions = null;
		String searchAmount = salesAmount.toString();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Sale.class);
			criteria = criteria.add(
				Restrictions.and(
					Restrictions.ge("minimumSalesAmount", searchAmount),
					Restrictions.le("maximumSalesAmount", searchAmount
							)
				)
			);
			commissions = super.getHibernateTemplate().findByCriteria(criteria);
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return commissions;
		
	}

}
