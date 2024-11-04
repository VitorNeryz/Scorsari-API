package com.nery.Scorsari.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nery.Scorsari.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_Customer_order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private OrderStatus status;
	private Double totalPrice;
	private String trackingNumber;
	
	@ManyToOne
	@JoinColumn(name = "fk_client_id")
	private Customer client; 
	
	@OneToMany
	List<OrderItem> orderItens = new ArrayList<>();
	
	public Order() {}
	
	public Order(Instant moment, Customer client,OrderStatus status) {
		this.moment = moment;
		this.client = client;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Customer getClient() {
		return client;
	}

	public void setClient(Customer client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, id, moment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(client, other.client) && Objects.equals(id, other.id)
				&& Objects.equals(moment, other.moment);
	}
	
	
	
}
