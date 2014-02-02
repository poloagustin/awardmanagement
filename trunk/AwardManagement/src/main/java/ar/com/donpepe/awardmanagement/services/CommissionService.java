package ar.com.donpepe.awardmanagement.services;

import java.util.*;

import ar.com.donpepe.awardmanagement.dtos.BestSalesmanReportDto;
import ar.com.donpepe.awardmanagement.dtos.CampaignBestSalesmanReportDto;
import ar.com.donpepe.awardmanagement.dtos.ProductSaleCommissionReportDto;
import ar.com.donpepe.awardmanagement.dtos.SaleCommissionReportDto;

public interface CommissionService {
	List<BestSalesmanReportDto> getBestSalesmanReport(List<Integer> userIds, int month, int year);
	List<CampaignBestSalesmanReportDto> getCampaignBestSalesmanReport(List<Integer> userIds, int month, int year);
	List<ProductSaleCommissionReportDto> getProductSaleCommissionReport(List<Integer> userIds, int month, int year);
	List<SaleCommissionReportDto> getSaleCommissionReport(List<Integer> userIds, int month, int year);
}
