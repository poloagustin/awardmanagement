package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class CampaignBestSalesmanReportDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2920879407402733964L;

	private String salesmanName;
	
	private String productName;
	
	private Integer amount;
	
	private Float price;

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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
