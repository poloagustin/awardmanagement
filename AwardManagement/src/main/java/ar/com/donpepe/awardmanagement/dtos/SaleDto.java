package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ar.com.donpepe.awardmanagement.domain.SaleItem;
import ar.com.donpepe.awardmanagement.domain.User;


public class SaleDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2211839803226992158L;
	
	private Date date;
	private String number;
	private User salesMan;
	private List<SaleItem> saleItems;
	Float total;
	

	
	public List<SaleItem> getSaleItems() {
		return saleItems;
	}
	
	public void setSaleItems(List<SaleItem> saleItems) {
		this.saleItems = saleItems;
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

	public User getSalesMan() {
		return salesMan;
	}

	public void setSalesMan(User salesMan) {
		this.salesMan = salesMan;
	}
	
	public Float getTotal() {
		//saco total
		Float total = null;
		for (SaleItem item : saleItems ) {
			total = total + item.getAmount();
		}
	
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

}
