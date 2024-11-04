package com.nery.Scorsari.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nery.Scorsari.enums.CustomerType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="TB_user")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone ;
	@JsonIgnore
	private String password ;
	private Integer age;
	private Instant registerDate;
	private String cpf;
	
	private LocalDate birthdate;
	private LocalDateTime updated_at;
	private LocalDateTime lastAccess;
	private CustomerType CustomerType;
	
	@OneToMany
	private List<Address> addresses = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Review> reviews = new ArrayList<>(); 
	
	@OneToOne
	@JoinColumn(name = "fk_customer_cart")
	private Cart cart; // instancia o objeto ??
	
	public Customer(){
	}

	public Customer(Long id, String name, String email, String phone, String password, Integer age,
			Instant registerDate, String cpf, LocalDate birthdate, LocalDateTime updated_at, LocalDateTime lastAccess,
			com.nery.Scorsari.enums.CustomerType customerType) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.age = age;
		this.registerDate = registerDate;
		this.cpf = cpf;
		this.birthdate = birthdate;
		this.updated_at = updated_at;
		this.lastAccess = lastAccess;
		CustomerType = customerType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Instant getCreationDate() {
		return registerDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.registerDate = creationDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public LocalDateTime getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(LocalDateTime lastAccess) {
		this.lastAccess = lastAccess;
	}

	public CustomerType getCustomerType() {
		return CustomerType;
	}

	public void setCustomerType(CustomerType customerType) {
		CustomerType = customerType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}
}