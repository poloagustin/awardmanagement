package ar.com.donpepe.awardmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EntityWithId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627732352352093994L;

	public EntityWithId() {
	}
	
	@Id
	private Integer Id;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
}
