package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

	private Date date;
	
	private String number;
	
	private List<SaleItem> saleItems;
}
