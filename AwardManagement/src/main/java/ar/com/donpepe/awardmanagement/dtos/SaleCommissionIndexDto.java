package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class SaleCommissionIndexDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4838310520161695984L;
	private Integer id;
	private Integer maximumSalesAmount;
	private Integer minimumSalesAmount;
	private Float saleCommission;
	
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMaximumSalesAmount() {
		return maximumSalesAmount;
	}
	public void setMaximunSalesAmount(Integer maximunSalesAmount) {
		this.maximumSalesAmount = maximunSalesAmount;
	}
	public Integer getMinimumSalesAmount() {
		return minimumSalesAmount;
	}
	public void setMinimumSalesAmount(Integer minimumSalesAmount) {
		this.minimumSalesAmount = minimumSalesAmount;
	}
	public Float getSaleCommission() {
		return saleCommission;
	}
	public void setSaleCommission(Float saleCommission) {
		this.saleCommission = saleCommission;
	}
	
}
