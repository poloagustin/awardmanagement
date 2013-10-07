package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class UserIndexDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 207745603021816033L;

	private String firstName;

	private String lastName;
	
	private String dni;
	
	private String username;

	private String role;
	
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
