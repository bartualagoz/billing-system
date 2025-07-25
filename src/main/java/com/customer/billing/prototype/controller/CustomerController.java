package com.customer.billing.prototype.controller;

import com.customer.billing.prototype.dto.CustomerDTO;
import com.customer.billing.prototype.model.Customer;
import com.customer.billing.prototype.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(
            @RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.substring(7);
            List<Customer> customers = customerService.getAllCustomers(token);
            List<CustomerDTO> dtos = customers.stream()
                    .map(CustomerDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(
            @RequestBody Customer customer,
            @RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.substring(7);
            Customer newCustomer = customerService.createCustomer(customer, token);
            return ResponseEntity.status(HttpStatus.CREATED).body(new CustomerDTO(newCustomer));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer id) {
        try {
            Customer customer = customerService.getCustomerById(id);
            return ResponseEntity.ok(new CustomerDTO(customer));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(
            @PathVariable Integer id,
            @RequestBody Customer customer) {
        if (!id.equals(customer.getId())) {
            return ResponseEntity.badRequest().build();
        }

        try {
            customerService.getCustomerById(id); // throws if not found
            Customer updated = customerService.updateCustomer(customer);
            return ResponseEntity.ok(new CustomerDTO(updated));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Integer id) {
        try {
            customerService.getCustomerById(id); // throws if not found
            customerService.deleteCustomerById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
