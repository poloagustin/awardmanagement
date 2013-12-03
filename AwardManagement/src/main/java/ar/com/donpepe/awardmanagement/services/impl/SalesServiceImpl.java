/**
 * 
 */
package ar.com.donpepe.awardmanagement.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.donpepe.awardmanagement.daos.SaleDao;
import ar.com.donpepe.awardmanagement.domain.Sale;
import ar.com.donpepe.awardmanagement.dtos.SaleDto;
import ar.com.donpepe.awardmanagement.dtos.SaleIndexDto;
import ar.com.donpepe.awardmanagement.dtos.SaleReportDto;
import ar.com.donpepe.awardmanagement.services.SalesService;
import ar.com.donpepe.awardmanagement.services.mappers.SalesMapper;

/**
 * @author Fernando
 * 
 */
public class SalesServiceImpl implements SalesService {

	private SaleDao saleDao;

	@Override
	public Boolean addSale(SaleDto sales) {
		// TODO Auto-generated method stub
		Integer rows = null;
		Sale sale = new Sale();
		sale = SalesMapper.getSale(sales);

		try {
			rows = this.saleDao.save(sale);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (rows > 0 ? true : false);
	}

	@Override
	public List<SaleIndexDto> getSalesReport(Integer userId) {
		// TODO Auto-generated method stub
		List<SaleIndexDto> saleIndexDtos = new ArrayList<SaleIndexDto>();

		for (Sale sale : this.saleDao.getSalesByUserId(userId)) {
			saleIndexDtos.add(SalesMapper.getSaleIndexDto(sale));
		}

		return saleIndexDtos;
	}

	@Override
	public Boolean verifySaleNumber(String saleNumber) {
		// TODO Auto-generated method stub
		List<Sale> sale = null;
		Boolean check = null;
		sale = this.saleDao.getSaleByNumber(saleNumber);
		if (sale.isEmpty()) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	@Override
	public List<SaleIndexDto> getIndex() {
		// TODO Auto-generated method stub
		List<Sale> sales = new ArrayList<Sale>();
		List<SaleIndexDto> saleIndexDto = new ArrayList<SaleIndexDto>();

		sales = this.saleDao.getAll();

		for (Sale sale : sales) {
			saleIndexDto.add(SalesMapper.getSaleIndexDto(sale));
		}

		return saleIndexDto;
	}

	@Override
	public SaleDto getSaleByNumber(String saleNumber) {
		// TODO Auto-generated method stub
		List<Sale> sale = null;
		SaleDto saleDto = null;
		sale = this.saleDao.getSaleByNumber(saleNumber);
		if (sale != null) {
			saleDto = SalesMapper.getSaleDto(sale.get(0));
		}
		return saleDto;
	}

	@Override
	public SaleDto getById(Integer id) {
		// TODO Auto-generated method stub
		SaleDto saleDto = null;
		try {

			saleDto = SalesMapper.getSaleDto(this.saleDao.get(id));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return saleDto;
	}

	public SaleDao getSaleDao() {
		return saleDao;
	}

	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}

	@Override
	public List<SaleIndexDto> getSalesByPeriod(Date dateFrom, Date dateTo,
			Integer userId) {
		// TODO Auto-generated method stub
		List<Sale> sales = null;
		sales = this.saleDao.getSalesByPeriod(dateFrom, dateTo, userId);
		return SalesMapper.getSaleIndexDto(sales);
	}

	@Override
	public List<SaleReportDto> getSalesReport(List<Integer> ids, int period,
			int year) {
		List<SaleReportDto> report = null;
		try {
			List<Sale> sales = this.saleDao.getSalesByPeriod(ids, period, year);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}

}
