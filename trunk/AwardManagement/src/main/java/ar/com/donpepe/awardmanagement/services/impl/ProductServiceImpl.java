package ar.com.donpepe.awardmanagement.services.impl;

import java.util.List;
import ar.com.donpepe.awardmanagement.daos.ProductDao;
import ar.com.donpepe.awardmanagement.domain.Product;
import ar.com.donpepe.awardmanagement.dtos.ProductDto;
import ar.com.donpepe.awardmanagement.dtos.ProductoIndexDto;
import ar.com.donpepe.awardmanagement.services.ProductService;
import ar.com.donpepe.awardmanagement.services.mappers.ProductMapper;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Override
	public ProductDto getProductById(Integer id) {
		// TODO Auto-generated method stub
		ProductDto product = new ProductDto();
		
		try {
			product = ProductMapper.getProductDto(this.productDao.get(id));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return product;
	}

	@SuppressWarnings("null")
	@Override
	public List<ProductoIndexDto> getProductIndex() {
		// TODO Auto-generated method stub
		List<ProductoIndexDto> products = null;  
		try {
			for (Product product : this.productDao.getAll()) {
				products.add(ProductMapper.getProductoIndex(product));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return products;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	}
