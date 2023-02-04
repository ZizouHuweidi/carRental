package com.car_rental.service;


import java.util.List;
import com.car_rental.entity.Customer;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer saveCustomer(Customer customer);
    Customer getCustomerById(Long customerId);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long customerId);

}
