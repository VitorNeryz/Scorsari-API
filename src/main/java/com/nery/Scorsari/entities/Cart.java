package com.nery.Scorsari.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Shopping_Cart")
public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer quantity;
	private Double totalValue;
	@OneToOne(mappedBy = "cart")
	private Customer customer;
	//private Status status;
	
	//@OneToMany
	//private List<CartItem> cartItens = new ArrayList<>();
}
