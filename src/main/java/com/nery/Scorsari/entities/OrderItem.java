package com.nery.Scorsari.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_OrderItem")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "fk_pedido")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "fk_produto")
	private Product product; 
	
	
}
