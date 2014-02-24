package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class SaleItem extends EntityWithId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7167627676701057181L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Product.class)
	private Product product;

	@Column
	private Integer amount;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Sale.class)	
	private Sale sale;

	public SaleItem() {
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
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

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
}
