package com.car_rental.service.impl;

import java.util.List;

import com.car_rental.entity.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car_rental.repository.RentalRepository;
import com.car_rental.service.RentalService;


@Service
public class RentalServiceImpl implements RentalService {

    private RentalRepository rentalRepository;

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository) {
        super();
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public Rental getRentalById(Long rentalId) {
        return rentalRepository.findById(rentalId).get();
    }

    @Override
    public Rental updateRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public void deleteRental(Long rentalId) {
        rentalRepository.deleteById(rentalId);
    }
}
