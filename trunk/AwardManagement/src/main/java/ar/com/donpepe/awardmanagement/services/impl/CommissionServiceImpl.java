package ar.com.donpepe.awardmanagement.services.impl;

import java.util.*;

import ar.com.donpepe.awardmanagement.daos.ProductDao;
import ar.com.donpepe.awardmanagement.daos.SaleDao;
import ar.com.donpepe.awardmanagement.daos.UserDao;
import ar.com.donpepe.awardmanagement.domain.BestSalesmanReport;
import ar.com.donpepe.awardmanagement.domain.CampaignBestSalesmanReport;
import ar.com.donpepe.awardmanagement.domain.ProductSaleCommissionReport;
import ar.com.donpepe.awardmanagement.dtos.BestSalesmanReportDto;
import ar.com.donpepe.awardmanagement.dtos.CampaignBestSalesmanReportDto;
import ar.com.donpepe.awardmanagement.dtos.CommissionReportItemDto;
import ar.com.donpepe.awardmanagement.dtos.ProductSaleCommissionReportDto;
import ar.com.donpepe.awardmanagement.dtos.SaleCommissionReportDto;
import ar.com.donpepe.awardmanagement.services.CommissionService;

public class CommissionServiceImpl implements CommissionService {

	private SaleDao saleDao;

	private ProductDao productDao;

	private UserDao userDao;

	private float mostSalesPrice;

	private String mostSalesMessage;

	// @Override
	// public List<SalesmanPriceDto> getSalesmanPrices(List<Integer> userIds,
	// int month, int year) {
	// List<SalesmanPriceDto> prices = new ArrayList<SalesmanPriceDto>();
	// try {
	// List<Sale> sales = this.saleDao.getSalesByPeriod(userIds, month, year);
	// List<User> users = this.getUserDao().getAll();
	// List<Product> products = this.productDao.getAll();
	// Map<Integer, Integer> saleAmountByUsers =
	// this.getSaleAmountByUser(userIds, sales);
	// Integer bestSalesmanId = this.getBestSalesmanId(saleAmountByUsers);
	// for (Entry<Integer, Integer> saleAmount : saleAmountByUsers.entrySet()) {
	// SalesmanPriceDto bestSaleDto = new SalesmanPriceDto();
	// bestSaleDto.setPriceName(this.getMostSalesMessage());
	// bestSaleDto.setProductName("");
	// for (User user : users) {
	// if (user.getId() == bestSalesmanId) {
	// bestSaleDto.setSalesmanFullName(user.getFullName());
	// }
	// }
	// if (saleAmount.getKey() == bestSalesmanId) {
	// bestSaleDto.setAmount(this.mostSalesPrice);
	// } else {
	// bestSaleDto.setAmount(0);
	// }
	// }
	// for (Integer userId : userIds) {
	// SalesmanPriceDto mostSalesPriceDto = new SalesmanPriceDto();
	// Integer saleAmount = 0;
	// }
	// } catch (Exception e) {
	// 
	// }
	// return prices;
	// }
	//
	// private Integer getBestSalesmanId(Map<Integer, Integer>
	// saleAmountByUsers) {
	// Integer userId = null;
	// Integer amount = 0;
	// for (Entry<Integer, Integer> entry : saleAmountByUsers.entrySet()) {
	// if (entry.getValue() > amount) {
	// userId = entry.getKey();
	// amount = entry.getValue();
	// }
	// }
	// return userId;
	// }
	//
	// private Map<Integer, Integer> getSaleAmountByUser(List<Integer> userIds,
	// List<Sale> sales) {
	// Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	// for (Integer userId : userIds) {
	// Integer amount = 0;
	// for (Sale sale : sales) {
	// if (sale.getSalesman().getId() == userId) {
	// amount++;
	// }
	// }
	// map.put(userId, amount);
	// }
	// return map;
	// }
	//
	// @Override
	// public List<SalesmanCommissionDto> getSalesmanCommissions(
	// List<Integer> userIds, int month, int year) {
	// return null;
	// }

	public SaleDao getSaleDao() {
		return saleDao;
	}

	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}

	public float getMostSalesPrice() {
		return mostSalesPrice;
	}

	public void setMostSalesPrice(float mostSalesPrice) {
		this.mostSalesPrice = mostSalesPrice;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getMostSalesMessage() {
		return mostSalesMessage;
	}

	public void setMostSalesMessage(String mostSalesMessage) {
		this.mostSalesMessage = mostSalesMessage;
	}

	@Override
	public List<BestSalesmanReportDto> getBestSalesmanReport(
			List<Integer> userIds, int month, int year) {
		List<BestSalesmanReportDto> bestSalesmanReportDtos = new ArrayList<BestSalesmanReportDto>();
		try {
			List<BestSalesmanReport> bestSalesmanReports = this.saleDao
					.getBestSalesmanReportByPeriod(month, year);
			Integer maxAmount = this.getMaxAmountBestSalesmanReport(bestSalesmanReports);
			for (BestSalesmanReport bestSalesmanReport : bestSalesmanReports) {
				if (userIds.contains(bestSalesmanReport.getSalesmanId())) {
					BestSalesmanReportDto bestSalesmanReportDto = new BestSalesmanReportDto();
					bestSalesmanReportDto.setSalesmanName(bestSalesmanReport
							.getSalesmanName());
					bestSalesmanReportDto.setAmount(bestSalesmanReport
							.getAmount());
					if (bestSalesmanReport.getAmount() == maxAmount) {
						bestSalesmanReportDto.setPrice(this.mostSalesPrice);
					} else {
						bestSalesmanReportDto.setPrice((float) 0);
					}
					bestSalesmanReportDtos.add(bestSalesmanReportDto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bestSalesmanReportDtos;
	}

	private Integer getMaxAmountBestSalesmanReport(List<BestSalesmanReport> bestSalesmanReports) {
		Integer maxAmount = 0;
		for (BestSalesmanReport bestSalesmanReport : bestSalesmanReports) {
			if (maxAmount < bestSalesmanReport.getAmount()) {
				maxAmount = bestSalesmanReport.getAmount();
			}
		}
		return maxAmount;
	}

	@Override
	public List<CampaignBestSalesmanReportDto> getCampaignBestSalesmanReport(
			List<Integer> userIds, int month, int year) {
		List<CampaignBestSalesmanReportDto> campaignBestSalesmanReportDtos = new ArrayList<CampaignBestSalesmanReportDto>();
		try {
			List<CampaignBestSalesmanReport> campaignBestSalesmanReports = this.saleDao
					.getCampaignBestSalesmanReportByPeriod(month, year);
			Integer maxAmount = this.getMaxAmountCampaignBestSalesmanReport(campaignBestSalesmanReports);
			for (CampaignBestSalesmanReport campaignBestSalesmanReport : campaignBestSalesmanReports) {
				if (userIds.contains(campaignBestSalesmanReport.getSalesmanId())) {
					CampaignBestSalesmanReportDto campaignBestSalesmanReportDto = new CampaignBestSalesmanReportDto();
					campaignBestSalesmanReportDto.setSalesmanName(campaignBestSalesmanReport
							.getSalesmanName());
					campaignBestSalesmanReportDto.setAmount(campaignBestSalesmanReport
							.getAmount());
					if (campaignBestSalesmanReport.getAmount() == maxAmount) {
						campaignBestSalesmanReportDto.setPrice(this.mostSalesPrice);
					} else {
						campaignBestSalesmanReportDto.setPrice((float) 0);
					}
					campaignBestSalesmanReportDtos.add(campaignBestSalesmanReportDto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return campaignBestSalesmanReportDtos;
	}

	private Integer getMaxAmountCampaignBestSalesmanReport(
			List<CampaignBestSalesmanReport> campaignBestSalesmanReports) {
		Integer maxAmount = 0;
		for (CampaignBestSalesmanReport campaignBestSalesmanReport : campaignBestSalesmanReports) {
			if (maxAmount < campaignBestSalesmanReport.getAmount()) {
				maxAmount = campaignBestSalesmanReport.getAmount();
			}
		}
		return maxAmount;
	}

	@Override
	public List<ProductSaleCommissionReportDto> getProductSaleCommissionReport(
			List<Integer> userIds, int month, int year) {
		List<ProductSaleCommissionReportDto> productSaleCommissionReportDtos = new ArrayList<ProductSaleCommissionReportDto>();
		try {
			List<ProductSaleCommissionReport> productSaleCommissionReports = this.saleDao
					.getProductSaleCommissionReportByPeriod(month, year);
			Integer maxAmount = this.getMaxAmountProductSaleCommissionReport(productSaleCommissionReports);
			for (ProductSaleCommissionReport productSaleCommissionReport : productSaleCommissionReports) {
				if (userIds.contains(productSaleCommissionReport.getSalesmanId())) {
					ProductSaleCommissionReportDto productSaleCommissionReportDto = new ProductSaleCommissionReportDto();
					productSaleCommissionReportDto.setSalesmanName(productSaleCommissionReport
							.getSalesmanName());
					productSaleCommissionReportDto.setAmount(productSaleCommissionReport
							.getAmount());
					if (productSaleCommissionReport.getAmount() == maxAmount) {
//						productSaleCommissionReportDto.setPrice(this.mostSalesPrice);
					} else {
//						productSaleCommissionReportDto.setPrice((float) 0);
					}
					productSaleCommissionReportDtos.add(productSaleCommissionReportDto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productSaleCommissionReportDtos;
	}

	private Integer getMaxAmountProductSaleCommissionReport(
			List<ProductSaleCommissionReport> productSaleCommissionReports) {
		Integer maxAmount = 0;
		for (ProductSaleCommissionReport productSaleCommissionReport : productSaleCommissionReports) {
			if (maxAmount < productSaleCommissionReport.getAmount()) {
				maxAmount = productSaleCommissionReport.getAmount();
			}
		}
		return maxAmount;
	}

	@Override
	public List<SaleCommissionReportDto> getSaleCommissionReport(
			List<Integer> userIds, int month, int year) {
		return null;
	}

	@Override
	public List<CommissionReportItemDto> getMonthlyReport(
			List<Integer> userIds, Integer month, Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

}
