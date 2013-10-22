package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;
import java.util.Date;
import ar.com.donpepe.awardmanagement.domain.User;

public class SaleIndexDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8032815645367357876L;
	
	private Date date;
	private String number;
	private User salesMan;
	private Float total;
	
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
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
}
