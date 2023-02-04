package com.car_rental.controller;


import com.car_rental.entity.Car;
import com.car_rental.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

	private CarService carService;

	 public CarController(CarService carService) {
		super();
		this.carService = carService;
	}

	//	List all cars
	@GetMapping("/cars")
	public String listStudents(Model model) {
		model.addAttribute("cars", carService.getAllCars());
		return "cars";
	}

	//	add car
	@GetMapping("/cars/new")
	public String createCarForm(Model model) {

		// created car object to hold car form data
		Car car = new Car();
		model.addAttribute("car", car);
		return "create_car";
	}

	//	save car
	@PostMapping("/cars")
	public String saveCar(@ModelAttribute("car") Car car) {
		carService.saveCar(car);
		return "redirect:/cars";
	}

	//	update car from page
	@GetMapping("/cars/edit/{id}")
	public String editCar(@PathVariable Long id, Model model) {
		Car existingCar = carService.getCarById(id);
		model.addAttribute("car", existingCar);
		return "edit_car";
	}


	//	update car actual
	@PostMapping("/cars/{id}")
	public String updateStudent(@PathVariable Long id,
								@ModelAttribute("car") Car car,
								Model model) {
		// Get car details from database
		Car existingCar = carService.getCarById(id);
		existingCar.setId(car.getId());
		existingCar.setName(car.getName());
		existingCar.setRentlRate(car.getRentalRate());

		// save updated car object
		carService.updateCar(existingCar);

		return "redirect:/cars";
	}


	//	delete car
	@GetMapping("/cars/{id}")
	public String deleteCar(@PathVariable Long id) {
		carService.deleteCar(id);
		return "redirect:/cars";
	}

}
