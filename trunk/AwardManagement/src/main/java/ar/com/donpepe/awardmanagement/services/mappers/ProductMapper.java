package ar.com.donpepe.awardmanagement.services.mappers;

import ar.com.donpepe.awardmanagement.domain.Product;
import ar.com.donpepe.awardmanagement.dtos.ProductDto;
import ar.com.donpepe.awardmanagement.dtos.ProductoIndexDto;

public class ProductMapper {
	
	public static Product getProduct(ProductDto productDto){
		Product product = new Product();
		product.setId(productDto.getId());
		return product;
		
	}
	
	public static ProductDto getProductDto(Product product){
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setAmmount(product.getAmmount());
		productDto.setSaleCommission(product.getSaleCommission());
		return productDto;
		
	}
	
	public static ProductoIndexDto getProductoIndex(Product product){
		ProductoIndexDto productIndexDto = new ProductoIndexDto();
		productIndexDto.setId(product.getId());
		productIndexDto.setName(product.getName());
		productIndexDto.setSaleCommission(product.getSaleCommission());
		return productIndexDto;
		
	}

}
