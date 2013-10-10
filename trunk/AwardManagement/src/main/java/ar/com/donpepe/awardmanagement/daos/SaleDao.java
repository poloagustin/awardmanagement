package ar.com.donpepe.awardmanagement.daos;

import java.util.List;

import ar.com.donpepe.awardmanagement.domain.Sale;

public interface SaleDao extends EntityWithIdDao<Sale>{
	
	List<Sale> getSalesByUserId(Integer userId);
}
