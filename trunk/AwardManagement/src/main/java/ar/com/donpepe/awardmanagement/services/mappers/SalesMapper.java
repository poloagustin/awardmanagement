package ar.com.donpepe.awardmanagement.services.mappers;

import ar.com.donpepe.awardmanagement.domain.Sale;
import ar.com.donpepe.awardmanagement.dtos.SaleDto;
import ar.com.donpepe.awardmanagement.dtos.SaleIndexDto;

public class SalesMapper {
	
	public static SaleDto getSaleDto(Sale sale){
		SaleDto saleDto = new SaleDto();
		saleDto.setNumber(sale.getNumber());
		saleDto.setDate(sale.getDate());
		saleDto.setSalesMan(sale.getSalesman());
		
		return saleDto;
		
	}
	
	public static Sale getSale(SaleDto saleDto){
		Sale sale = new Sale();
		sale.setDate(saleDto.getDate());
		sale.setNumber(saleDto.getNumber());
		sale.setSaleItems(saleDto.getSaleItems());
		sale.setSalesman(saleDto.getSalesMan());
		return sale;
		
	}
	
	public static SaleIndexDto getSaleIndexDto(Sale sale){
		SaleIndexDto saleIndexDto = new SaleIndexDto();
		
		saleIndexDto.setNumber(sale.getNumber());
		saleIndexDto.setDate(sale.getDate());
		saleIndexDto.setSalesMan(sale.getSalesman());
		
		return saleIndexDto;
	}

}
