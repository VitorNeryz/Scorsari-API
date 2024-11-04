package com.nery.Scorsari.converters;

import java.util.stream.Stream;

import com.nery.Scorsari.enums.CustomerType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CustomerTypeConverter implements AttributeConverter<CustomerType,Integer>{

	@Override
	public Integer convertToDatabaseColumn(CustomerType type) {
		if(type == null) {
			return null;
		}
		return type.getCode();
	}

	@Override
	public CustomerType convertToEntityAttribute(Integer code) {
		if(code == null) {
			return null;
		}
		
		return Stream.of(CustomerType.values())
		          .filter(c -> c.getCode().equals(code))
		          .findFirst()
		          .orElseThrow(IllegalArgumentException::new);
	}

}
