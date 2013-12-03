package ar.com.donpepe.awardmanagement.services.impl;

import java.util.List;

import ar.com.donpepe.awardmanagement.daos.SaleCommissionDao;
import ar.com.donpepe.awardmanagement.domain.SaleCommission;
import ar.com.donpepe.awardmanagement.dtos.SaleCommissionDto;
import ar.com.donpepe.awardmanagement.services.SaleCommissionService;
import ar.com.donpepe.awardmanagement.services.mappers.SaleCommissionMapper;


public class SaleCommissionServiceImpl implements SaleCommissionService {

	private SaleCommissionDao saleCommissionDao;
	
	public SaleCommissionDao getSaleComissionDao() {
		return saleCommissionDao;
	}

	public void setSaleComissionDao(SaleCommissionDao saleComissionDao) {
		this.saleCommissionDao = saleComissionDao;
	}

	@Override
	public Boolean updateSaleCommission(SaleCommissionDto saleCommission) {
		Boolean success = false;
		try {
			this.saleCommissionDao.update(SaleCommissionMapper.getSaleCommission(saleCommission));;
			success = true;
		} catch (Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	public Boolean deleteSaleCommission(SaleCommissionDto saleCommission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer newSaleCommission(SaleCommissionDto saleCommission) {
		Integer result = null;
		try {
			Integer id = this.saleCommissionDao.save(SaleCommissionMapper.getSaleCommission(saleCommission));
			result = id;
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
	

	@Override
	public SaleCommission getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SaleCommission getSaleCommissionByAmount(Integer amount) {
		SaleCommission commission = this.saleCommissionDao.getCommission(amount);
		return commission;
	}

	@Override
	public List<SaleCommission> getSalesCommissionByAmount(Integer amount) {
		 List<SaleCommission> commissions = this.saleCommissionDao.getByAmmount(amount);
		 return commissions;
	}

}
