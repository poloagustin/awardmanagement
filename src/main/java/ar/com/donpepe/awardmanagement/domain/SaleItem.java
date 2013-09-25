package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, targetEntity = Product.class)
	private Product product;

	@Column
	private Integer amount;
}
