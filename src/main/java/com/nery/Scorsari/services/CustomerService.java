package com.nery.Scorsari.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nery.Scorsari.entities.Customer;
import com.nery.Scorsari.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;
	
	public List<Customer> findAll(){
		return repository.findAll();
	}
	
	public Customer findById(Long id) {
		Optional<Customer> obj = repository.findById(id);
		return obj.get();
	}
}
