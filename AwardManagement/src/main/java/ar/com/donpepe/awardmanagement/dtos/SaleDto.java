package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ar.com.donpepe.awardmanagement.domain.SaleItem;


public class SaleDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2211839803226992158L;
	
	private Date date;
	private String number;
	private List<SaleItem> saleItems;

	
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
	
}
