package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;

public class Product extends EntityWithId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3828620798865602724L;

	public Product() {
	}

	private String name;
	
	private Float saleCommission;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSaleCommission() {
		return saleCommission;
	}

	public void setSaleCommission(Float saleCommission) {
		this.saleCommission = saleCommission;
	}
}
