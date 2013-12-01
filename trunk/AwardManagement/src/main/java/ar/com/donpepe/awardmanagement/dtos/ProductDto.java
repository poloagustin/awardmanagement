package ar.com.donpepe.awardmanagement.dtos;

public class ProductDto {
	
	private Integer id;
	private String name;
	private Float saleCommission;
	private Float ammount;
	
	public Float getAmmount() {
		return ammount;
	}
	public void setAmmount(Float ammount) {
		this.ammount = ammount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
