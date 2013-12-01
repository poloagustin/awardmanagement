package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class UserCredentialDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3838467013206650283L;
	private String username;
	private String password;
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
