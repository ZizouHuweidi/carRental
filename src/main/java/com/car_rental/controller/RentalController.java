package com.car_rental.controller;

import com.car_rental.entity.Rental;
import com.car_rental.service.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RentalController {

	private RentalService rentalService;

	public RentalController(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}

	//	List all rentals
	@GetMapping("/rentals")
	public String listRentals(Model model) {
		model.addAttribute("rentals", rentalService.getAllRentals());
		return "rentals";
	}

	//	add rental
	@GetMapping("/rentals/new")
	public String createRentalForm(Model model) {

		// created rental object to hold rental form data
		Rental rental = new Rental();
		model.addAttribute("rental", rental);
		return "create_rental";
	}

	//	save rental
	@PostMapping("/rentals")
	public String saveRental(@ModelAttribute("rental") Rental rental) {
		rentalService.saveRental(rental);
		return "redirect:/rentals";
	}

	//	update rental from page
	@GetMapping("/rentals/edit/{id}")
	public String editRental(@PathVariable Long id, Model model) {
		Rental existingRental = rentalService.getRentalById(id);
		model.addAttribute("rental", existingRental);
		return "edit_rental";
	}


	//	update rental actual
	@PostMapping("/rentals/{id}")
	public String updateRental(@PathVariable Long id,
								 @ModelAttribute("rental") Rental rental,
								 Model model) {
		// Get rental details from database
		Rental existingRental = rentalService.getRentalById(id);
		existingRental.setId(rental.getId());
		existingRental.setCstId(rental.getCstId());
		existingRental.setCarId(rental.getCarId());
		existingRental.setStartDate(rental.getStartDate());
		existingRental.setFinishDate(rental.getFinishDate());

		// save updated rental object
		rentalService.updateRental(existingRental);

		return "redirect:/rentals";
	}


	//	delete rental
	@GetMapping("/rentals/{id}")
	public String deleteRental(@PathVariable Long id) {
		rentalService.deleteRental(id);
		return "redirect:/rentals";
	}

}
