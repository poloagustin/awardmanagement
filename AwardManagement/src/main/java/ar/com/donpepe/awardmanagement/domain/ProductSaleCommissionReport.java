package ar.com.donpepe.awardmanagement.domain;

public class ProductSaleCommissionReport {
	private Integer salesmanId;
	
	private String salesmanName;
	
	private String productName;
	
	private Integer amount;
	
	private Float commission;

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

	public Float getCommission() {
		return commission;
	}

	public void setCommission(Float commission) {
		this.commission = commission;
	}

	public Integer getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(Integer salesmanId) {
		this.salesmanId = salesmanId;
	}
}
