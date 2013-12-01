package ar.com.donpepe.awardmanagement.services.mappers;

import java.util.ArrayList;
import java.util.List;
import ar.com.donpepe.awardmanagement.domain.Product;
import ar.com.donpepe.awardmanagement.domain.SaleItem;
import ar.com.donpepe.awardmanagement.dtos.SaleItemDto;

public class SaleItemMapper {

	public static List<SaleItemDto> getSaleItemDto(List<SaleItem> item) {
		List<SaleItemDto> itemDto = new ArrayList<SaleItemDto>();
		for (SaleItem s : item) {
			itemDto.add(getSaleItemDto(s));
		}

		return itemDto;
	}

	public static SaleItemDto getSaleItemDto(SaleItem item) {
		SaleItemDto itemDto = new SaleItemDto();
		itemDto.setProductId(item.getProduct().getId());
		itemDto.setAmount(item.getAmount());

		return itemDto;
	}
	
	public static List<SaleItem> getSaleItem(List<SaleItemDto> itemsDto){
		List<SaleItem> items = new ArrayList<SaleItem>();
		for (SaleItemDto saleItem : itemsDto) {
			items.add(getSaleItem(saleItem));
		}
		return items;
		
	}

	public static SaleItem getSaleItem(SaleItemDto itemDto) {
		SaleItem item = new SaleItem();
		Product p = new Product();
		
		p.setId(itemDto.getProductId());
		item.setProduct(p);
		item.setAmount(itemDto.getAmount());
		
		return item;
	}
}
