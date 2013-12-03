package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class SaleCommissionDto implements Serializable {
	/**
	 * 
	 */
	private Integer id;
	private Integer maximumSalesAmount;
	private Integer minimumSalesAmount;
	private Float saleCommission;
	
	private static final long serialVersionUID = -4705121995745343008L;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMaximumSalesAmount() {
		return maximumSalesAmount;
	}
	public void setMaximumSalesAmount(Integer maximunSalesAmount) {
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
