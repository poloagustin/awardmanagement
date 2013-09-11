package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;

public class SaleItem extends EntityWithId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7167627676701057181L;

	public SaleItem() {
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	private Product product;
	
	private Integer amount;
}
