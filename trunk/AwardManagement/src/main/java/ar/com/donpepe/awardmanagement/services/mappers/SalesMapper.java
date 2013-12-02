package ar.com.donpepe.awardmanagement.services.mappers;

import java.util.ArrayList;
import java.util.List;
import ar.com.donpepe.awardmanagement.domain.Sale;
import ar.com.donpepe.awardmanagement.domain.SaleItem;
import ar.com.donpepe.awardmanagement.domain.User;
import ar.com.donpepe.awardmanagement.dtos.SaleDto;
import ar.com.donpepe.awardmanagement.dtos.SaleIndexDto;

public class SalesMapper {

	public static SaleDto getSaleDto(Sale sale) {
		SaleDto saleDto = new SaleDto();

		saleDto.setNumber(sale.getNumber());
		saleDto.setDate(sale.getDate());
		saleDto.setSaleItems(SaleItemMapper.getSaleItemDto(sale.getSaleItems()));
		saleDto.setSalesmanId(sale.getSalesman().getId());
		return saleDto;

	}

	public static Sale getSale(SaleDto saleDto) {
		Sale sale = new Sale();
		User user = new User();
		List<SaleItem> s = null;

		sale.setDate(saleDto.getDate());
		sale.setNumber(saleDto.getNumber());

		s = SaleItemMapper.getSaleItem(saleDto.getSaleItems());
		user.setId(saleDto.getSalesmanId());

		sale.setSaleItems(s);
		sale.setSalesman(user);
		
		return sale;

	}

	public static SaleIndexDto getSaleIndexDto(Sale sale) {

		SaleIndexDto saleIndexDto = new SaleIndexDto();
		saleIndexDto.setNumber(sale.getNumber());
		saleIndexDto.setDate(sale.getDate());
		saleIndexDto.setSalerman(sale.getId());

		return saleIndexDto;
	}
	
	public static List<SaleIndexDto> getSaleIndexDto(List<Sale> sales){
		List<SaleIndexDto> s = new ArrayList<SaleIndexDto>();
		for (Sale sale : sales) {
			s.add(getSaleIndexDto(sale));
		}
		return s;
	}

}
