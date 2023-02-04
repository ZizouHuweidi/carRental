package com.car_rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.car_rental.entity.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
