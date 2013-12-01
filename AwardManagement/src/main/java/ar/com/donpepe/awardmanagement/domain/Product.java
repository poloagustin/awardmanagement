package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product extends EntityWithId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3828620798865602724L;

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

	public Product() {
	}

	@Column
	private String name;

	@Column
	private Float saleCommission;
	
	@Column
	private Float ammount;
	
	public Float getAmmount() {
		return ammount;
	}

	public void setAmmount(Float ammount) {
		this.ammount = ammount;
	}

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
