package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;

//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class EntityWithId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627732352352093994L;

	public EntityWithId() {
	}

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;

	public abstract Integer getId();

	public abstract void setId(Integer id);
	
	@Override
	public boolean equals(Object arg0) {
		EntityWithId entity = null;
		if (arg0 instanceof EntityWithId) {
			entity = (EntityWithId)arg0;
			if (entity.getId() != null) {
				return entity.getId().equals(this.getId());				
			}
		} 
		return false;
	}
}
