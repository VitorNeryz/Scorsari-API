package com.nery.Scorsari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nery.Scorsari.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
