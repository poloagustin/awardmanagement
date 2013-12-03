package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sale extends EntityWithId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6906835291720368879L;

	public Sale() {
	}

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

	public User getSalesman() {
		return salesman;
	}

	public void setSalesman(User salesman) {
		this.salesman = salesman;
	}

	private Date date;

	@Column(length = 13, nullable = false)
	private String number;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	private User salesman;

	//@ElementCollection(fetch = FetchType.LAZY, targetClass = SaleItem.class)
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = SaleItem.class)
	@JoinTable(name = "Sale_SaleItem",joinColumns = @JoinColumn(name="SaleId"),inverseJoinColumns=@JoinColumn(name="SaleItemID"))
	private List<SaleItem> saleItems;
}
