package com.car_rental.service;


import java.util.List;
import com.car_rental.entity.Car;

public interface CarService {

    List<Car> getAllCars();
    Car saveCar(Car car);
    Car getCarById(Long carId);
    Car updateCar(Car car);
    void deleteCar(Long carId);
}
