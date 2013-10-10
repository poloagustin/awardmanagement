package ar.com.donpepe.awardmanagement.services;

import java.util.List;

import ar.com.donpepe.awardmanagement.domain.Sale;
import ar.com.donpepe.awardmanagement.dtos.*;

public interface SalesService {
	Boolean addSale(SaleDto sales);
	List<SaleIndexDto> getSalesReport(Integer userId);
	Boolean verifySaleNumber(String saleNumber);
	List<Sale> getSales();
	Sale getSaleByNumber(Integer number);
}
