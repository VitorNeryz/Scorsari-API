package com.nery.Scorsari.enums;

public enum OrderStatus {
	WAITING_PAYMENT(0),
	PAID(1),
	SHIPPED(2),
	DELIVERED(3),
	CANCELED(4);
	
	private Integer code;
	
	private OrderStatus(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
}
