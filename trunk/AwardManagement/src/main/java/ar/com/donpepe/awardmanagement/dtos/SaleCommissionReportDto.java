package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class SaleCommissionReportDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8263005365650199368L;

	private String salesmanName;
	
	private Integer saleAmount;
	
	private Float commissionAmount;

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	public Integer getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(Integer saleAmount) {
		this.saleAmount = saleAmount;
	}

	public Float getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(Float commissionAmount) {
		this.commissionAmount = commissionAmount;
	}
}
