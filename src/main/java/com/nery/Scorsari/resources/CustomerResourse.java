package com.nery.Scorsari.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nery.Scorsari.entities.Customer;
import com.nery.Scorsari.services.CustomerService;

@RestController
@RequestMapping(value = "/users")
public class CustomerResourse {
	@Autowired
	private CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll(){
		List<Customer> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id){
		Customer obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
