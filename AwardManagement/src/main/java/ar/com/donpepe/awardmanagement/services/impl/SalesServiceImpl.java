/**
 * 
 */
package ar.com.donpepe.awardmanagement.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ar.com.donpepe.awardmanagement.daos.ProductDao;
import ar.com.donpepe.awardmanagement.daos.SaleCommissionDao;
import ar.com.donpepe.awardmanagement.daos.SaleDao;
import ar.com.donpepe.awardmanagement.domain.Product;
import ar.com.donpepe.awardmanagement.domain.Sale;
import ar.com.donpepe.awardmanagement.domain.SaleCommission;
import ar.com.donpepe.awardmanagement.domain.SaleItem;
import ar.com.donpepe.awardmanagement.dtos.PairDto;
import ar.com.donpepe.awardmanagement.dtos.SaleDto;
import ar.com.donpepe.awardmanagement.dtos.SaleIndexDto;
import ar.com.donpepe.awardmanagement.dtos.SaleReportDto;
import ar.com.donpepe.awardmanagement.services.SalesService;
import ar.com.donpepe.awardmanagement.services.mappers.SalesMapper;

/**
 * @author Fernando
 * 
 */
public class SalesServiceImpl implements SalesService {

	private SaleDao saleDao;
	private ProductDao productDao;
	private SaleCommissionDao saleCommissionDao;
	private Float bestSalePrize;
	private Float bestCampaignPrize;

	@Override
	public Boolean addSale(SaleDto sales) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		List<SaleIndexDto> saleIndexDtos = new ArrayList<SaleIndexDto>();

		for (Sale sale : this.saleDao.getSalesByUserId(userId)) {
			saleIndexDtos.add(SalesMapper.getSaleIndexDto(sale));
		}

		return saleIndexDtos;
	}

	@Override
	public Boolean verifySaleNumber(String saleNumber) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		SaleDto saleDto = null;
		try {

			saleDto = SalesMapper.getSaleDto(this.saleDao.get(id));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return saleDto;
	}

	public SaleDao getSaleDao() {
		return saleDao;
	}

	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}

	@Override
	public List<SaleIndexDto> getSalesByPeriod(Date dateFrom, Date dateTo,
			Integer userId) {
		// TODO Auto-generated method stub
		List<Sale> sales = null;
		sales = this.saleDao.getSalesByPeriod(dateFrom, dateTo, userId);
		return SalesMapper.getSaleIndexDto(sales);
	}

	@Override
	public List<SaleReportDto> getSalesReport(List<Integer> ids, int period,
			int year) {
		List<SaleReportDto> report = null;
		try {
			List<Sale> sales = this.saleDao.getSalesByPeriod(ids, period, year);
			List<Product> products = this.productDao.getAll();
			List<String> salesmen = this.getSellers(ids, sales);
			List<SaleCommission> commissions = this.saleCommissionDao.getAll();
			Map<String, Float> bestSellers = this.getBestSellers(sales,
					salesmen);
			Map<String, Float> bestCampaignSellers = this
					.getBestCampaignSellers(sales, salesmen, products);
			Map<String, Float> commissionBySellers = this
					.getSellerCommission(sales, salesmen, commissions);
			Map<String, Float> commissionProductSellers = this
					.getCommissionProductSellers(sales, salesmen, products);
			for (String salesman : salesmen) {
				Float amount = new Float(0);
				for (Entry<String, Float> item : bestSellers.entrySet()) {
					if (item.getKey() == salesman) {
						amount += item.getValue();
					}
				}
				for (Entry<String, Float> item : bestCampaignSellers.entrySet()) {
					if (item.getKey() == salesman) {
						amount += item.getValue();
					}
				}
				for (Entry<String, Float> item : commissionBySellers.entrySet()) {
					if (item.getKey() == salesman) {
						amount += item.getValue();
					}
				}
				for (Entry<String, Float> item : commissionProductSellers.entrySet()) {
					if (item.getKey() == salesman) {
						amount += item.getValue();
					}
				}
				SaleReportDto dto = new SaleReportDto();
				dto.setSalesman(salesman);
				dto.setAward(amount);
				report.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}

	private Map<String, Float> getCommissionProductSellers(List<Sale> sales,
			List<String> salesmen, List<Product> products) {
		List<PairDto<String, Float>> bestCampaignSellers = new ArrayList<PairDto<String, Float>>();
		for (String salesman : salesmen) {
			PairDto<String, Float> entry = new PairDto<String, Float>();
			entry.key = salesman;
			entry.value = new Float(0);
			bestCampaignSellers.add(entry);
		}
		for (Product product : products) {
			Map<String, Integer> productAmountBySalesman = new HashMap<String, Integer>();
			for (String string : salesmen) {
				Integer productAmount = 0;
				for (Sale sale : sales) {
					if (sale.getSalesman().getFullName() == string) {
						for (SaleItem saleItem : sale.getSaleItems()) {
							if (saleItem.getProduct().getId() == product.getId()) {
								productAmount += saleItem.getAmount();
							}
						}
					}
				}
				productAmountBySalesman.put(string, productAmount);
			}
			for (PairDto<String, Float> pairDto : bestCampaignSellers) {
				pairDto.value += (productAmountBySalesman.get(pairDto.key) * product.getSaleCommission());
			}
		}
		Map<String, Float> res = new HashMap<String, Float>();
		for (PairDto<String, Float> pairDto : bestCampaignSellers) {
			res.put(pairDto.key, pairDto.value);
		}
		return res;
	}

	private Map<String, Float> getSellerCommission(List<Sale> sales,
			List<String> salesmen, List<SaleCommission> commissions) {
		Map<String, Float> salesmenSaleAmount = new HashMap<String, Float>();
		for (String id : salesmen) {
			Integer count = 0;
			for (Sale sale : sales) {
				if (sale.getSalesman().getFullName() == id) {
					count++;
				}
			}
			Float commission = new Float(0);
			for (SaleCommission saleCommission : commissions) {
				if (saleCommission.getMaximumSalesAmount() <= count && saleCommission.getMinimumSalesAmount() >= count) {
					commission = saleCommission.getSaleCommission();
				}
			}
			salesmenSaleAmount.put(id, commission);
		}
		return salesmenSaleAmount;
	}

	private Map<String, Float> getBestCampaignSellers(List<Sale> sales,
			List<String> salesmen, List<Product> products) {
		List<PairDto<String, Float>> bestCampaignSellers = new ArrayList<PairDto<String, Float>>();
		for (String salesman : salesmen) {
			PairDto<String, Float> entry = new PairDto<String, Float>();
			entry.key = salesman;
			entry.value = new Float(0);
			bestCampaignSellers.add(entry);
		}
		for (Product product : products) {
			Map<String, Integer> productAmountBySalesman = new HashMap<String, Integer>();
			for (String string : salesmen) {
				Integer productAmount = 0;
				for (Sale sale : sales) {
					if (sale.getSalesman().getFullName() == string) {
						for (SaleItem saleItem : sale.getSaleItems()) {
							if (saleItem.getProduct().getId() == product.getId()) {
								productAmount += saleItem.getAmount();
							}
						}
					}
				}
				productAmountBySalesman.put(string, productAmount);
			}
			Integer max = 0;
			for (Entry<String, Integer> entry : productAmountBySalesman.entrySet()) {
				if (entry.getValue() > max) {
					max = entry.getValue();
				}
			}
			for (PairDto<String, Float> pairDto : bestCampaignSellers) {
				pairDto.value += productAmountBySalesman.get(pairDto.key) == max ? this.bestCampaignPrize : 0;
			}
		}
		Map<String, Float> res = new HashMap<String, Float>();
		for (PairDto<String, Float> pairDto : bestCampaignSellers) {
			res.put(pairDto.key, pairDto.value);
		}
		return res;
	}

	private List<String> getSellers(List<Integer> ids, List<Sale> sales) {
		List<String> salesmen = new ArrayList<String>();
		for (Integer id : ids) {
			for (Sale sale : sales) {
				if (sale.getSalesman().getId() == id) {
					salesmen.add(sale.getSalesman().getFullName());
					break;
				}
			}
		}
		return salesmen;
	}

	private Map<String, Float> getBestSellers(List<Sale> sales, List<String> ids) {
		Map<String, Integer> salesmenSaleAmount = new HashMap<String, Integer>();
		for (String id : ids) {
			Integer count = 0;
			for (Sale sale : sales) {
				if (sale.getSalesman().getFullName() == id) {
					count++;
				}
			}
			salesmenSaleAmount.put(id, count);
		}
		Integer max = 0;
		for (Entry<String, Integer> salesmanSaleAmount : salesmenSaleAmount
				.entrySet()) {
			if (max < salesmanSaleAmount.getValue()) {
				max = salesmanSaleAmount.getValue();
			}
		}
		Map<String, Float> bestSellers = new HashMap<String, Float>();
		for (Entry<String, Integer> salesmanSaleAmount : salesmenSaleAmount
				.entrySet()) {
			bestSellers.put(salesmanSaleAmount.getKey(), salesmanSaleAmount
					.getValue() == max ? this.bestSalePrize : 0);
		}
		return bestSellers;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
