package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class BestSalesmanReportDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8229598425047805349L;
	
	private String salesmanName;
	
	private Integer amount;
	
	private Float price;

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
