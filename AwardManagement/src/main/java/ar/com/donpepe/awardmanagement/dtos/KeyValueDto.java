package ar.com.donpepe.awardmanagement.dtos;

import java.io.Serializable;

public class KeyValueDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6037901340491469607L;

	private Integer key;
	
	private String value;

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
