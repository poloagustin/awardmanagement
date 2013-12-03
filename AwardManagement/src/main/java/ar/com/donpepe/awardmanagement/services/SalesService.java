package ar.com.donpepe.awardmanagement.services;

import java.util.Date;
import java.util.List;
import ar.com.donpepe.awardmanagement.dtos.*;

public interface SalesService {
	Boolean addSale(SaleDto sales);
	List<SaleIndexDto> getSalesReport(Integer userId);
	Boolean verifySaleNumber(String saleNumber);
	List<SaleIndexDto> getIndex();
	SaleDto getSaleByNumber(String salenumber);
	SaleDto getById(Integer id);
	List<SaleIndexDto> getSalesByPeriod(Date dateFrom , Date dateTo, Integer userId);
	List<SaleReportDto> getSalesReport(List<Integer> ids, int period, int year);
}
