package com.car_rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.car_rental.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
