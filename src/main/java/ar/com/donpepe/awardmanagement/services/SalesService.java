package ar.com.donpepe.awardmanagement.services;

import java.util.List;

import ar.com.donpepe.awardmanagement.dtos.*;

public interface SalesService {
	Boolean addSale(SaleDto sale);
	List<SaleIndexDto> getSalesReport(Integer userId);
	Boolean verifySaleNumber(String saleNumber);
}
