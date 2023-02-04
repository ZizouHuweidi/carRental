package com.car_rental.service.impl;

import com.car_rental.entity.Car;
import com.car_rental.repository.CarRepository;
import com.car_rental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository){
        super();
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long carId) {
        return carRepository.findById(carId).get();
    }

    @Override
    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
