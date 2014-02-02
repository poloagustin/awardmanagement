package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SaleCommission extends EntityWithId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7808825386496569519L;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private Integer minimumSalesAmount;

	@Column(nullable=true)
	private Integer maximumSalesAmount;

	@Column
	private Float saleCommission;

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
}
