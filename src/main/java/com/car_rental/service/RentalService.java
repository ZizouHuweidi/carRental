package com.car_rental.service;

import java.util.List;

import com.car_rental.entity.Rental;

public interface RentalService {

    List<Rental> getAllRentals();
    Rental saveRental(Rental rental);
    Rental getRentalById(Long rentalId);
    Rental updateRental(Rental rental);
    void deleteRental(Long rentalId);
}
