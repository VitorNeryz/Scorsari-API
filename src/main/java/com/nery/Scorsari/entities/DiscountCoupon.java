package com.nery.Scorsari.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.nery.Scorsari.enums.TypeDiscount;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_DiscountCoupon")
public class DiscountCoupon implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id ;
	private String code;
	private LocalDateTime expirationDate;
	private String description;
	private Double discountPercent;
	private Integer useQuantity;
	private Boolean activity;
	private TypeDiscount typeDiscount;
	
	public DiscountCoupon(String code, LocalDateTime expirationDate, String description, Double discountPercent,
			Integer useQuantity,TypeDiscount typeDiscount,Boolean activity) {
		this.code = code;
		this.expirationDate = expirationDate;
		this.description = description;
		this.discountPercent = discountPercent;
		this.useQuantity = useQuantity;
		this.typeDiscount = typeDiscount;
		this.activity = activity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}


	public Integer getuseQuantity() {
		return useQuantity;
	}

	public void setuseQuantity(Integer useQuantity) {
		this.useQuantity = useQuantity;
	}


	public Long getId() {
		return id;
	}
	
	public TypeDiscount getTypeDiscount() {
		return typeDiscount;
	}

	public void setTypeDiscount(TypeDiscount typeDiscount) {
		this.typeDiscount = typeDiscount;
	}

	public Boolean getActivity() {
		return activity;
	}

	public void setActivity(Boolean activity) {
		this.activity = activity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiscountCoupon other = (DiscountCoupon) obj;
		return Objects.equals(code, other.code);
	}
	
}
