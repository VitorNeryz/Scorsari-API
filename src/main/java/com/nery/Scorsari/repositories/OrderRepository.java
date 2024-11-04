package com.nery.Scorsari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nery.Scorsari.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
