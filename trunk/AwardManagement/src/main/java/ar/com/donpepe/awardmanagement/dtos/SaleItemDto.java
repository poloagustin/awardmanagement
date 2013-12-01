package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class SaleItemDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7546250958423555351L;

	private Integer productId;
	
	private Integer amount;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
