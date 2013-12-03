package ar.com.donpepe.awardmanagement.daos;

import java.util.Date;
import java.util.List;

import ar.com.donpepe.awardmanagement.domain.BestSalesmanReport;
import ar.com.donpepe.awardmanagement.domain.CampaignBestSalesmanReport;
import ar.com.donpepe.awardmanagement.domain.ProductSaleCommissionReport;
import ar.com.donpepe.awardmanagement.domain.Sale;
import ar.com.donpepe.awardmanagement.domain.SaleCommissionReport;

public interface SaleDao extends EntityWithIdDao<Sale>{
	List<Sale> getSalesByUserId(Integer userId); 
	List<Sale> getSaleByNumber(String number);
	List<Sale> getSalesByPeriod(Date dateFrom , Date dateTo, Integer userId);
	List<Sale> getSalesByPeriod(List<Integer> userIds, int month, int year);
	List<BestSalesmanReport> getBestSalesmanReportByPeriod(int month, int year);
	List<CampaignBestSalesmanReport> getCampaignBestSalesmanReportByPeriod(int month, int year);
	List<ProductSaleCommissionReport> getProductSaleCommissionReportByPeriod(int month, int year);
	List<SaleCommissionReport> getSaleCommissionReportByPeriod(int month, int year);
}
