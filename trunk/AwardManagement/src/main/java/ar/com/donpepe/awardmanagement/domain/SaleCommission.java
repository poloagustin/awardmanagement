package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SaleCommission extends EntityWithId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7808825386496569519L;

	public SaleCommission() {
	}

	public Integer getMinimumSalesAmount() {
		return minimumSalesAmount;
	}

	public void setMinimumSalesAmount(Integer minimumSalesAmount) {
		this.minimumSalesAmount = minimumSalesAmount;
	}

	public Integer getMaximumSalesAmount() {
		return maximumSalesAmount;
	}

	public void setMaximumSalesAmount(Integer maximumSalesAmount) {
		this.maximumSalesAmount = maximumSalesAmount;
	}

	public Float getSaleCommission() {
		return saleCommission;
	}

	public void setSaleCommission(Float saleCommission) {
		this.saleCommission = saleCommission;
	}

	@Column
	private Integer minimumSalesAmount;

	@Column
	private Integer maximumSalesAmount;

	@Column
	private Float saleCommission;
}
