package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class SaleDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2211839803226992158L;
	
	private Date date;
	private String number;
	private Integer salesmanId;
	private List<SaleItemDto> saleItems;
		
	public List<SaleItemDto> getSaleItems() {
		return saleItems;
	}
	
	public void setSaleItems(List<SaleItemDto> saleItems) {
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
	
//	public Float getTotal() {
//		//saco total
//		Float total = null;
//		for (SaleItem item : saleItems ) {
//			total = total + item.getAmount();
//		}
//	
//		return total;
//	}

//	public void setTotal(Float total) {
//		this.total = total;
//	}

	public Integer getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(Integer salesmanId) {
		this.salesmanId = salesmanId;
	}

}
