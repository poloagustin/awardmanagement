package ar.com.donpepe.awardmanagement.services;

import java.util.List;

import ar.com.donpepe.awardmanagement.domain.SaleCommission;
import ar.com.donpepe.awardmanagement.dtos.SaleCommissionDto;
import ar.com.donpepe.awardmanagement.dtos.SaleCommissionIndexDto;




public interface SaleCommissionService {
	
	Boolean updateSaleCommission(SaleCommissionDto saleCommission);
	Boolean deleteSaleCommission(SaleCommissionDto saleCommission);
	Integer newSaleCommission(SaleCommissionDto saleCommission);
	
	SaleCommission getSaleCommissionByNumber(String saleCommissionNumber);
	SaleCommission getById(Integer id);
	List<SaleCommissionIndexDto> getIndex();
	SaleCommission getSaleCommissionByAmmount(Integer amount);

}
