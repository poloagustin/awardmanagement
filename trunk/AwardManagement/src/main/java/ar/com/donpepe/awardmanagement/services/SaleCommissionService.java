package ar.com.donpepe.awardmanagement.services;

import java.util.List;

import ar.com.donpepe.awardmanagement.domain.SaleCommission;
import ar.com.donpepe.awardmanagement.dtos.SaleCommissionDto;


public interface SaleCommissionService {
	
	Boolean updateSaleCommission(SaleCommissionDto saleCommission);
	Boolean deleteSaleCommission(SaleCommissionDto saleCommission);
	Integer newSaleCommission(SaleCommissionDto saleCommission);
	
	
	SaleCommission getById(Integer id);
	SaleCommission getSaleCommissionByAmount(Integer amount);
	List<SaleCommission>  getSalesCommissionByAmount(Integer amount);
	Float getSaleCommissionFromList(List<SaleCommission> commissions, Integer amount);
	List<SaleCommission>  getAll();
}
