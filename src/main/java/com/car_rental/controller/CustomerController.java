package com.car_rental.controller;



import com.car_rental.entity.Customer;
import com.car_rental.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	//	List all customers
	@GetMapping("/customers")
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}

	//	add customer
	@GetMapping("/customers/new")
	public String createCustomerForm(Model model) {

		// created customer object to hold customer form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "create_customer";
	}

	//	save customer
	@PostMapping("/customers")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customers";
	}

	//	update customer from page
	@GetMapping("/customers/edit/{id}")
	public String editCustomer(@PathVariable Long id, Model model) {
		Customer existingCustomer = customerService.getCustomerById(id);
		model.addAttribute("customer", existingCustomer);
		return "edit_customer";
	}


	//	update customer actual 
	@PostMapping("/customers/{id}")
	public String updateCustomer(@PathVariable Long id,
								@ModelAttribute("customer") Customer customer,
								Model model) {
		// Get customer details from database
		Customer existingCustomer = customerService.getCustomerById(id);
		existingCustomer.setId(customer.getId());
		existingCustomer.setName(customer.getName());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setBalance(customer.getBalance());

		// save updated customer object
		customerService.updateCustomer(existingCustomer);

		return "redirect:/customers";
	}


	//	delete customer
	@GetMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return "redirect:/customers";
	}

}
