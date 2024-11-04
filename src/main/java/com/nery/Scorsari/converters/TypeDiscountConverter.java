package com.nery.Scorsari.converters;

import java.util.stream.Stream;

import com.nery.Scorsari.enums.TypeDiscount;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TypeDiscountConverter implements AttributeConverter<TypeDiscount, Integer>{

	@Override
	public Integer convertToDatabaseColumn(TypeDiscount type) {
		if(type == null) {
			return null;
		}
		return type.getCode();
	}

	@Override
	public TypeDiscount convertToEntityAttribute(Integer code) {
		if(code == null) {
			return null;
		}
		
		return Stream.of(TypeDiscount.values())
				.filter(c -> c.getCode().equals(code))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
				
	}
}
