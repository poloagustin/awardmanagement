package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class SalesmanPriceDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617820106614822106L;

	private String salesmanFullName;
	
	private String priceName;
	
	private float amount;

	private String productName;
	
	public String getSalesmanFullName() {
		return salesmanFullName;
	}

	public void setSalesmanFullName(String salesmanFullName) {
		this.salesmanFullName = salesmanFullName;
	}

	public String getPriceName() {
		return priceName;
	}

	public void setPriceName(String priceName) {
		this.priceName = priceName;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
