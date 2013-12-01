package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Sale extends EntityWithId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6906835291720368879L;

	public Sale() {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<SaleItem> getSaleItems() {
		return saleItems;
	}

	public void setSaleItems(List<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}

	@Column
	private Date date;

	@Column
	private String number;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	private User salesman;

	@ElementCollection(fetch = FetchType.LAZY, targetClass = SaleItem.class)
	private List<SaleItem> saleItems;
}