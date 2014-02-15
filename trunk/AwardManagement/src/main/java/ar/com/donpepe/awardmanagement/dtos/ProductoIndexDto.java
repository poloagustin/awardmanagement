package ar.com.donpepe.awardmanagement.dtos;

public class ProductoIndexDto {
	
	private Integer id;
	private String name;
	private Float ammount;

	
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
	public Float getAmmount() {
		return ammount;
	}
	public void setAmmount(Float ammount) {
		this.ammount = ammount;
	}
}
