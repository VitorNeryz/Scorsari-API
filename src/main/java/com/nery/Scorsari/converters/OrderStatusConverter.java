package com.nery.Scorsari.converters;

import java.util.stream.Stream;

import com.nery.Scorsari.enums.OrderStatus;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Integer> {

	@Override
	public Integer convertToDatabaseColumn(OrderStatus status) {
		if(status == null) {
			return null;
		}
		return status.getCode();
	}

	@Override
	public OrderStatus convertToEntityAttribute(Integer code) {
		if(code == null) {
			return null;
		}
		
		return Stream.of(OrderStatus.values())
		          .filter(c -> c.getCode().equals(code))
		          .findFirst()
		          .orElseThrow(IllegalArgumentException::new);
	}

}
