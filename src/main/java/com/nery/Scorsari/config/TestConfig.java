package com.nery.Scorsari.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nery.Scorsari.entities.Customer;
import com.nery.Scorsari.entities.Order;
import com.nery.Scorsari.enums.CustomerType;
import com.nery.Scorsari.enums.OrderStatus;
import com.nery.Scorsari.repositories.OrderRepository;
import com.nery.Scorsari.repositories.CustomerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private CustomerRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Customer u1 = new Customer(null, "Maria Brown", "maria@gmail.com", "988888888", "123456",25, Instant.now(),"88888888888",
				LocalDate.parse("2003-10-29"), null, null, CustomerType.CUSTOMER);
		
		Customer u2 = new Customer(null, "Alex Green", "alex@gmail.com", "977777777", "123456",44, Instant.now(),"99999999999", 
				LocalDate.parse("2001-07-02"), null, null, CustomerType.CUSTOMER);
		
		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), u1,OrderStatus.SHIPPED); 
		Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), u2,OrderStatus.PAID); 
		Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), u1,OrderStatus.DELIVERED);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
}
