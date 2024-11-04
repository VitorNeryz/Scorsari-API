package com.nery.Scorsari.enums;

public enum TypeDiscount {
	PERCENT(1),
	FIX(2);
	
	private Integer code;
	
	private TypeDiscount(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
}
