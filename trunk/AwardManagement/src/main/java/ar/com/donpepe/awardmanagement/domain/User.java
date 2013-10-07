package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class User extends EntityWithId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1615434186671062639L;

	public User() {
	}
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String dni;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private Role role;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
