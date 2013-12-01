package ar.com.donpepe.awardmanagement.services.mappers;

import ar.com.donpepe.awardmanagement.domain.SaleCommission;
import ar.com.donpepe.awardmanagement.dtos.SaleCommissionDto;
import ar.com.donpepe.awardmanagement.dtos.SaleCommissionIndexDto;



public class SaleCommissionMapper {

	public static SaleCommissionDto getSaleCommissionDto(SaleCommission saleCom){
		SaleCommissionDto comDto = new SaleCommissionDto();
		comDto.setId(saleCom.getId());
		comDto.setMaximunSalesAmount(saleCom.getMaximumSalesAmount());
		comDto.setMinimumSalesAmount(saleCom.getMinimumSalesAmount());
		comDto.setSaleCommission(saleCom.getSaleCommission());
		
		return comDto;}
	
	public static SaleCommission getSaleCommission(SaleCommissionDto saleCom){
		SaleCommission saleCommssion = new SaleCommission();
		saleCommssion.setId(saleCom.getId());
		saleCommssion.setMaximumSalesAmount(saleCom.getMaximumSalesAmount());
		saleCommssion.setMinimumSalesAmount(saleCom.getMinimumSalesAmount());
		saleCommssion.setSaleCommission(saleCom.getSaleCommission());
		
		return saleCommssion;}
	
	public static SaleCommissionIndexDto getSaleCommissionIndexDto(SaleCommission saleCom){
		SaleCommissionIndexDto comDto = new SaleCommissionIndexDto();
		comDto.setId(saleCom.getId());
		comDto.setMaximunSalesAmount(saleCom.getMaximumSalesAmount());
		comDto.setMinimumSalesAmount(saleCom.getMinimumSalesAmount());
		comDto.setSaleCommission(saleCom.getSaleCommission());
		
		return comDto;}
	
	public static SaleCommission getSaleCommissionFromIndexDto(SaleCommissionIndexDto saleCom){
		SaleCommission saleCommssion = new SaleCommission();
		saleCommssion.setId(saleCom.getId());
		saleCommssion.setMaximumSalesAmount(saleCom.getMaximumSalesAmount());
		saleCommssion.setMinimumSalesAmount(saleCom.getMinimumSalesAmount());
		saleCommssion.setSaleCommission(saleCom.getSaleCommission());
		
		return saleCommssion;}
	
}
