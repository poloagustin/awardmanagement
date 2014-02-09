package ar.com.donpepe.awardmanagement.daos.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.springframework.dao.DataAccessException;

import ar.com.donpepe.awardmanagement.daos.SaleDao;
import ar.com.donpepe.awardmanagement.daos.impl.EntityWithIdDaoImpl;
import ar.com.donpepe.awardmanagement.domain.BestSalesmanReport;
import ar.com.donpepe.awardmanagement.domain.CampaignBestSalesmanReport;
import ar.com.donpepe.awardmanagement.domain.ProductSaleCommissionReport;
import ar.com.donpepe.awardmanagement.domain.Sale;
import ar.com.donpepe.awardmanagement.domain.SaleCommissionReport;

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

		calendar.set(Calendar.DAY_OF_MONTH, Calendar.getInstance()
				.getActualMinimum(Calendar.DAY_OF_MONTH));
		firstDayOfMonth = calendar.getTime();

		calendar.set(Calendar.DAY_OF_MONTH, Calendar.getInstance()
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		lastDayOfMonth = calendar.getTime();

		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Sale.class);
			criteria = criteria.add(Restrictions.and(Restrictions.eq("user",
					userId), Restrictions.between("date", firstDayOfMonth,
					lastDayOfMonth)));
			salesByUser = super.getHibernateTemplate().findByCriteria(criteria);
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return salesByUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sale> getSaleByNumber(String number) {
		List<Sale> sale = null;
		try {
			DetachedCriteria criteria = super.getMyCriteria().add(
					Restrictions.eq("number", number));
			sale = (List<Sale>) super.getHibernateTemplate().findByCriteria(
					criteria);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return sale;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BestSalesmanReport> getBestSalesmanReportByPeriod(int month,
			int year) {
		List<BestSalesmanReport> bestSalesmanReports = null;
		try {
			List<List<Object>> list = (List<List<Object>>) this
					.getHibernateTemplate()
					.find("select new list(sm.id id, concat(c.lastName, ', ', c.firstName) as fullName, count(s.id) countSales) "
							+ "from Sale s "
							+ "inner join fetch s.salesman sm "
							// + "where sm.id in (:userIds) "
							+ "group by sm.id, sm.firstName, sm.lastName");
			bestSalesmanReports = new ArrayList<BestSalesmanReport>();
			for (int i = 0; i < list.size(); i++) {
				List<Object> item = list.get(i);
				BestSalesmanReport bestSalesmanReport = new BestSalesmanReport();
				bestSalesmanReport.setSalesmanId((Integer) item.get(0));
				bestSalesmanReport.setSalesmanName((String) item.get(1));
				bestSalesmanReport.setAmount((Integer) item.get(2));
				bestSalesmanReports.add(bestSalesmanReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bestSalesmanReports;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CampaignBestSalesmanReport> getCampaignBestSalesmanReportByPeriod(
			int month, int year) {
		List<CampaignBestSalesmanReport> campaignBestSalesmanReports = null;
		try {
			List<List<Object>> list = (List<List<Object>>) this
					.getHibernateTemplate()
					.find("select new list(sm.id id, concat(c.lastName, ', ', c.firstName) as fullName, p.name productName, count(si.amount) countSales) "
							+ "from SaleItem si "
							+ "inner join fetch si.sale s "
							+ "inner join fetch s.salesman sm "
							+ "inner join fetch si.product p "
							+ "group by sm.id, sm.firstName, sm.lastName, p.name");
			campaignBestSalesmanReports = new ArrayList<CampaignBestSalesmanReport>();
			for (int i = 0; i < list.size(); i++) {
				List<Object> item = list.get(i);
				CampaignBestSalesmanReport campaignBestSalesmanReport = new CampaignBestSalesmanReport();
				campaignBestSalesmanReport.setSalesmanId((Integer) item.get(0));
				campaignBestSalesmanReport
						.setSalesmanName((String) item.get(1));
				campaignBestSalesmanReport.setProductName((String) item.get(2));
				campaignBestSalesmanReport.setAmount((Integer) item.get(3));
				campaignBestSalesmanReports.add(campaignBestSalesmanReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return campaignBestSalesmanReports;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleCommissionReport> getProductSaleCommissionReportByPeriod(
			int month, int year) {
		List<ProductSaleCommissionReport> productSaleCommissionReports = null;
		try {
			List<List<Object>> list = (List<List<Object>>) this
					.getHibernateTemplate()
					.find("select new list(sm.id id, concat(c.lastName, ', ', c.firstName) as fullName, p.name productName, p.saleCommission saleCommission, count(si.amount) countSales) "
							+ "from SaleItem si "
							+ "inner join fetch si.sale s "
							+ "inner join fetch s.salesman sm "
							+ "inner join fetch si.product p "
							+ "group by sm.id, sm.firstName, sm.lastName, p.name, p.saleCommission");
			productSaleCommissionReports = new ArrayList<ProductSaleCommissionReport>();
			for (int i = 0; i < list.size(); i++) {
				List<Object> item = list.get(i);
				ProductSaleCommissionReport productSaleCommissionReport = new ProductSaleCommissionReport();
				productSaleCommissionReport
						.setSalesmanId((Integer) item.get(0));
				productSaleCommissionReport.setSalesmanName((String) item
						.get(1));
				productSaleCommissionReport
						.setProductName((String) item.get(2));
				productSaleCommissionReport.setCommission((Float) item.get(3));
				productSaleCommissionReport.setAmount((Integer) item.get(4));
				productSaleCommissionReports.add(productSaleCommissionReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return productSaleCommissionReports;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaleCommissionReport> getSaleCommissionReportByPeriod(
			int month, int year) {
		List<SaleCommissionReport> saleCommissionReports = null;
		try {
			List<List<Object>> list = (List<List<Object>>) this
					.getHibernateTemplate()
					.find("select new list(g.id id, g.fullName fullName, g.countSales countSales, sc.saleCommission saleCommission)"
							+ "from SaleCommission sc"
							+ "inner join ( "
							+ "select new list(sm.id id, concat(c.lastName, ', ', c.firstName) as fullName, count(s.id) countSales) "
							+ "from Sale s "
							+ "inner join fetch s.salesman sm "
							+ "group by sm.id, sm.firstName, sm.lastName"
							+ ") g on g.countSales >= sc.minimumSalesAmount and g.countSales <= sc.maximumSalesAmount");
			saleCommissionReports = new ArrayList<SaleCommissionReport>();
			for (int i = 0; i < list.size(); i++) {
				List<Object> item = list.get(i);
				SaleCommissionReport saleCommissionReport = new SaleCommissionReport();
				saleCommissionReport.setSalesmanId((Integer) item.get(0));
				saleCommissionReport.setSalesmanName((String) item.get(1));
				saleCommissionReport.setSaleAmount((Integer) item.get(2));
				saleCommissionReport.setCommissionAmount((Float) item.get(3));
				saleCommissionReports.add(saleCommissionReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return saleCommissionReports;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sale> getSalesByPeriod(Date dateFrom, Date dateTo,
			Integer userId) {
		List<Sale> salesByUser = null;
		List<Sale> sales = null;
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Sale.class);
			criteria = criteria.add(Restrictions.and(
					Restrictions.eq("salesman.id", userId),
					Restrictions.between("date", dateFrom, dateTo)));
			salesByUser = (List<Sale>) super.getHibernateTemplate()
					.findByCriteria(criteria);
			Set<Sale> salesSet = new HashSet<Sale>(salesByUser);
			sales = new ArrayList<Sale>(salesSet);
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return sales;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sale> getSalesByPeriod(int month, int year) {
		List<Sale> sales = null;

		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Sale.class);
			criteria = criteria.add(Restrictions.and(Restrictions
					.sqlRestriction("MONTH(date) = ?", month,
							IntegerType.INSTANCE), Restrictions.sqlRestriction(
					"YEAR(date) = ?", year, IntegerType.INSTANCE)));

			sales = (List<Sale>) super.getHibernateTemplate().findByCriteria(
					criteria);
			Set<Sale> salesSet = new HashSet<Sale>(sales);
			sales = new ArrayList<Sale>(salesSet);
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return sales;
	}
}
