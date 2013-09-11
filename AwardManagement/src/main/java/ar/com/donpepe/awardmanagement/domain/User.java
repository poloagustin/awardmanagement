package ar.com.donpepe.awardmanagement.domain;

import java.io.Serializable;

public class User extends EntityWithId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1615434186671062639L;

	public User() {
	}
	
	private String firstName;
	
	private String lastName;
	
	private String dni;
	
	private String username;
	
	private String password;
	
	private Role role;
	
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
