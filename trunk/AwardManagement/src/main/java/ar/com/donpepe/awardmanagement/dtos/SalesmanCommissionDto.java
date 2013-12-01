package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class SalesmanCommissionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3772739536990933757L;

	private String salesmanFullName;
	
	private String productName;
	
	private float amount;

	public String getSalesmanFullName() {
		return salesmanFullName;
	}

	public void setSalesmanFullName(String salesmanFullName) {
		this.salesmanFullName = salesmanFullName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}
