package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

import ar.com.donpepe.awardmanagement.domain.Role;

public class UserCredentialDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3838467013206650283L;
	private Integer userId;
	private String username;
	private String password;
	private int role;

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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	} 
	
}
