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
		productIndexDto.setAmmount(product.getAmmount());
		return productIndexDto;
	}
	
	public static Product getProductofromDto(ProductDto productDto){
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setAmmount(productDto.getAmmount());
		product.setSaleCommission(productDto.getSaleCommission());
		return product;
	}
}
