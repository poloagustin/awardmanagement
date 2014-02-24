/**
 * 
 */
package ar.com.donpepe.awardmanagement.services.impl;

import java.util.*;
import java.util.Map.Entry;

import ar.com.donpepe.awardmanagement.daos.*;
import ar.com.donpepe.awardmanagement.domain.*;
import ar.com.donpepe.awardmanagement.dtos.*;
import ar.com.donpepe.awardmanagement.services.*;
import ar.com.donpepe.awardmanagement.services.mappers.*;

/**
 * @author Fernando
 * 
 */
public class SalesServiceImpl implements SalesService {

	private SaleDao saleDao;
	private ProductDao productDao;
	private SaleCommissionDao saleCommissionDao;
	private UserDao userDao;
	private Float bestSalePrize;
	private Float bestCampaignPrize;

	public SaleDao getSaleDao() {
		return saleDao;
	}

	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public SaleCommissionDao getSaleCommissionDao() {
		return saleCommissionDao;
	}

	public void setSaleCommissionDao(SaleCommissionDao saleCommissionDao) {
		this.saleCommissionDao = saleCommissionDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Float getBestSalePrize() {
		return bestSalePrize;
	}

	public void setBestSalePrize(Float bestSalePrize) {
		this.bestSalePrize = bestSalePrize;
	}

	public Float getBestCampaignPrize() {
		return bestCampaignPrize;
	}

	public void setBestCampaignPrize(Float bestCampaignPrize) {
		this.bestCampaignPrize = bestCampaignPrize;
	}

	public Boolean addSale(SaleDto sales) {
		Integer rows = null;
		Sale sale = new Sale();
		sale = SalesMapper.getSale(sales);

		try {			
			rows = this.saleDao.save(sale);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (rows > 0 ? true : false);
	}

	@Override
	public List<SaleIndexDto> getSalesReport(Integer userId) {
		List<SaleIndexDto> saleIndexDtos = new ArrayList<SaleIndexDto>();

		for (Sale sale : this.saleDao.getSalesByUserId(userId)) {
			saleIndexDtos.add(SalesMapper.getSaleIndexDto(sale));
		}

		return saleIndexDtos;
	}

	@Override
	public Boolean verifySaleNumber(String saleNumber) {
		List<Sale> sale = null;
		Boolean check = null;
		sale = this.saleDao.getSaleByNumber(saleNumber);
		if (sale.isEmpty()) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	@Override
	public List<SaleIndexDto> getIndex() {
		List<Sale> sales = new ArrayList<Sale>();
		List<SaleIndexDto> saleIndexDto = new ArrayList<SaleIndexDto>();

		sales = this.saleDao.getAll();

		for (Sale sale : sales) {
			saleIndexDto.add(SalesMapper.getSaleIndexDto(sale));
		}

		return saleIndexDto;
	}

	@Override
	public SaleDto getSaleByNumber(String saleNumber) {
		List<Sale> sale = null;
		SaleDto saleDto = null;
		sale = this.saleDao.getSaleByNumber(saleNumber);
		if (sale != null) {
			saleDto = SalesMapper.getSaleDto(sale.get(0));
		}
		return saleDto;
	}

	@Override
	public SaleDto getById(Integer id) {
		SaleDto saleDto = null;
		try {

			saleDto = SalesMapper.getSaleDto(this.saleDao.get(id));

		} catch (Exception e) {

			e.printStackTrace();
		}

		return saleDto;
	}

	@Override
	public List<SaleIndexDto> getSalesByPeriod(Date dateFrom, Date dateTo,
			Integer userId) {
		List<Sale> sales = null;
		sales = this.saleDao.getSalesByPeriod(dateFrom, dateTo, userId);
		return SalesMapper.getSaleIndexDto(sales);
	}

	@Override
	public List<SaleReportDto> getSalesReport(List<Integer> ids, int period,
			int year) {
		List<SaleReportDto> report = new ArrayList<SaleReportDto>();
		try {
			// Get all sales for the given period.
			List<Sale> sales = this.saleDao.getSalesByPeriod(period, year);

			// Get all products.
			List<Product> products = this.productDao.getAll();

			// Get all sale commissions.
			List<SaleCommission> commissions = this.saleCommissionDao.getAll();

			// Get sellers.
			List<User> users = this.userDao.getByIds(ids);
			
			// Get all sellers that reached the maximum amount of sales
			Map<Integer, Float> bestSellers = this.getBestSellers(sales, ids);

			// Get all sellers that reached the maximum amount of sales by
			// product
			Map<Integer, Float> bestCampaignSellers = this
					.getBestCampaignSellers(sales, ids, products);

			// Get all sellers with their commissions.
			Map<Integer, Float> commissionBySellers = this.getSellerCommission(
					sales, ids, commissions);
			
			// Get all sellers commission for selling specific products.
			Map<Integer, Float> commissionProductSellers = this
					.getCommissionProductSellers(sales, ids, products);
			for (Integer id : ids) {
				Float amount = new Float(0);
				for (Entry<Integer, Float> item : bestSellers.entrySet()) {
					if (item.getKey() == id) {
						amount += item.getValue();
					}
				}
				for (Entry<Integer, Float> item : bestCampaignSellers.entrySet()) {
					if (item.getKey() == id) {
						amount += item.getValue();
					}
				}
				for (Entry<Integer, Float> item : commissionBySellers.entrySet()) {
					if (item.getKey() == id) {
						amount += item.getValue();
					}
				}
				for (Entry<Integer, Float> item : commissionProductSellers
						.entrySet()) {
					if (item.getKey() == id) {
						amount += item.getValue();
					}
				}
				SaleReportDto dto = new SaleReportDto();
				String salesmanName = "";
				for (User user : users) {
					if (user.getId() == id) {
						salesmanName = user.getFullName();
						break;
					}
				}
				dto.setSalesman(salesmanName);
				dto.setAward(amount);
				report.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}

	private Map<Integer, Float> getCommissionProductSellers(List<Sale> sales,
			List<Integer> salesmen, List<Product> products) {
		List<PairDto<Integer, Float>> bestCampaignSellers = new ArrayList<PairDto<Integer, Float>>();
		for (Integer salesman : salesmen) {
			PairDto<Integer, Float> entry = new PairDto<Integer, Float>();
			entry.key = salesman;
			entry.value = new Float(0);
			bestCampaignSellers.add(entry);
		}
		for (Product product : products) {
			Map<Integer, Integer> productAmountBySalesman = new HashMap<Integer, Integer>();
			for (Integer string : salesmen) {
				Integer productAmount = 0;
				for (Sale sale : sales) {
					if (sale.getSalesman().getId() == string) {
						for (SaleItem saleItem : sale.getSaleItems()) {
							if (saleItem.getProduct().getId() == product
									.getId()) {
								productAmount += saleItem.getAmount();
							}
						}
					}
				}
				productAmountBySalesman.put(string, productAmount);
			}
			for (PairDto<Integer, Float> pairDto : bestCampaignSellers) {
				pairDto.value += (productAmountBySalesman.get(pairDto.key) * product
						.getSaleCommission());
			}
		}
		Map<Integer, Float> res = new HashMap<Integer, Float>();
		for (PairDto<Integer, Float> pairDto : bestCampaignSellers) {
			res.put(pairDto.key, pairDto.value);
		}
		return res;
	}

	private Map<Integer, Float> getSellerCommission(List<Sale> sales,
			List<Integer> salesmen, List<SaleCommission> commissions) {
		Map<Integer, Float> salesmenSaleAmount = new HashMap<Integer, Float>();
		for (Integer id : salesmen) {

			// Get amount of sales for the given seller.
			Integer count = 0;
			for (Sale sale : sales) {
				if (sale.getSalesman().getId() == id) {
					count++;
				}
			}

			// Set commission for the seller
			Float commission = new Float(0);
			for (SaleCommission saleCommission : commissions) {
				if (saleCommission.getMinimumSalesAmount() <= count
						&& (saleCommission.getMaximumSalesAmount() == null ? count
								: saleCommission.getMaximumSalesAmount()) >= count) {
					commission = saleCommission.getSaleCommission();
				}
			}
			salesmenSaleAmount.put(id, commission);
		}
		return salesmenSaleAmount;
	}

	private Map<Integer, Float> getBestCampaignSellers(List<Sale> sales,
			List<Integer> salesmen, List<Product> products) {
		List<PairDto<Integer, Float>> bestCampaignSellers = new ArrayList<PairDto<Integer, Float>>();

		// Initiate collection of sellers.
		for (Integer salesman : salesmen) {
			PairDto<Integer, Float> entry = new PairDto<Integer, Float>();
			entry.key = salesman;
			entry.value = new Float(0);
			bestCampaignSellers.add(entry);
		}

		// Calculate amount of products each seller has sold.
		for (Product product : products) {
			// Calculate amount of the given product a seller sold.
			Map<Integer, Integer> productAmountBySalesman = new HashMap<Integer, Integer>();

			productAmountBySalesman = getAmountOfProductSoldBy(sales, salesmen,
					product);

			// Calculate the maximum amount sold for the given product.
			Integer max = 0;
			for (Entry<Integer, Integer> entry : productAmountBySalesman
					.entrySet()) {
				if (entry.getValue() > max) {
					max = entry.getValue();
				}
			}

			// Assign the best campaign prize to the sellers
			for (PairDto<Integer, Float> pairDto : bestCampaignSellers) {
				pairDto.value += productAmountBySalesman.get(pairDto.key) == max ? this.bestCampaignPrize
						: 0;
			}
		}

		// Get a distinct of only the
		Map<Integer, Float> res = new HashMap<Integer, Float>();
		for (PairDto<Integer, Float> pairDto : bestCampaignSellers) {
			if (pairDto.value != 0) {
				if (res.containsKey(pairDto.key)) {
					res.put(pairDto.key, ((Float) res.get(pairDto.key))
							+ pairDto.value);
				} else {
					res.put(pairDto.key, pairDto.value);
				}
			}
		}

		return res;
	}

	private Map<Integer, Integer> getAmountOfProductSoldBy(List<Sale> sales,
			List<Integer> salesmen, Product product) {
		Map<Integer, Integer> productAmountBySalesman = new HashMap<Integer, Integer>();
		for (Integer string : salesmen) {
			Integer productAmount = 0;

			// Calculate amount of sales by product and seller.
			for (Sale sale : sales) {
				// If the seller needs to be evaluated count the amount
				// products he sold.
				if (sale.getSalesman().getId() == string) {
					for (SaleItem saleItem : sale.getSaleItems()) {
						if (saleItem.getProduct().getId() == product.getId()) {
							productAmount += saleItem.getAmount();
						}
					}
				}
			}
			productAmountBySalesman.put(string, productAmount);
		}
		return productAmountBySalesman;
	}

	private Map<Integer, Float> getBestSellers(List<Sale> sales,
			List<Integer> ids) {
		Map<Integer, Integer> salesmenSaleAmount = new HashMap<Integer, Integer>();

		// Count amount of sales by salesman.
		for (Integer id : ids) {
			Integer count = 0;
			for (Sale sale : sales) {
				if (sale.getSalesman().getId() == id) {
					count++;
				}
			}
			salesmenSaleAmount.put(id, count);
		}

		// Calculate the biggest amount of sales
		Integer max = 0;
		for (Entry<Integer, Integer> salesmanSaleAmount : salesmenSaleAmount
				.entrySet()) {
			if (max < salesmanSaleAmount.getValue()) {
				max = salesmanSaleAmount.getValue();
			}
		}

		// Make a collection of all sellers
		// that have the biggest amount of sales.
		Map<Integer, Float> bestSellers = new HashMap<Integer, Float>();
		for (Entry<Integer, Integer> salesmanSaleAmount : salesmenSaleAmount
				.entrySet()) {
			bestSellers.put(salesmanSaleAmount.getKey(), salesmanSaleAmount
					.getValue() == max ? this.getBestSalePrize() : 0);
		}
		return bestSellers;
	}
}
