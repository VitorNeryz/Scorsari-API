package com.nery.Scorsari.enums;

public enum CustomerType {
	CUSTOMER(0),
	ADMIN(1);
	
	private Integer code;
	
	private CustomerType(Integer code){
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
}
