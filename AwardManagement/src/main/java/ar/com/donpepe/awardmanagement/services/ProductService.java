package ar.com.donpepe.awardmanagement.services;

import java.util.List;

import ar.com.donpepe.awardmanagement.dtos.ProductDto;
import ar.com.donpepe.awardmanagement.dtos.ProductoIndexDto;

public interface ProductService {
	
	ProductDto getProductById(Integer id);
	List<ProductoIndexDto> getProductIndex();

}
