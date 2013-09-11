package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;

public class EntityWithId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627732352352093994L;

	public EntityWithId() {
	}
	
	private Integer Id;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
}
