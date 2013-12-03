package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class SaleReportDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 581886246901822538L;
	
	private String salesman;
	
	private Float award;

	public String getSalesman() {
		return salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	public Float getAward() {
		return award;
	}

	public void setAward(Float award) {
		this.award = award;
	}
}
