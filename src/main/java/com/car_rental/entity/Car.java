package com.car_rental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "rentalRate", unique = true)
	private int rentlRate;


	public Car() {

	}

	public Car(String name, int rentlRate) {
		super();
		this.name = name;
		this.rentlRate = rentlRate;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRentalRate() {
		return rentlRate;
	}
	public void setRentlRate(int rentlRate) {
		this.rentlRate = rentlRate;
	}

}
