package com.customer.billing.prototype.service;

import com.customer.billing.prototype.dto.CustomerDTO;
import com.customer.billing.prototype.model.Customer;
import com.customer.billing.prototype.model.User;
import com.customer.billing.prototype.repository.CustomerRepository;
import com.customer.billing.prototype.repository.UserRepository;
import com.customer.billing.prototype.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer, String token) {
        String username = jwtUtil.extractUsername(token);
        User user = userRepository.findByUsername(username).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Customer existing = customerRepository
                .findByFirstNameAndLastNameAndUser(
                        customer.getFirstName(),
                        customer.getLastName(),
                        user
                ).orElse(null);

        if (existing != null) {
            throw new RuntimeException("Customer already exists!");
        }

        customer.setUser(user);
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(String token) {
        String username = jwtUtil.extractUsername(token);
        User user = userRepository.findByUsername(username).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return customerRepository.findByUser(user);
    }

    public Customer getCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);

        if (customer == null) {
            throw new RuntimeException("Customer not found!");
        }

        return customer;
    }

    public Customer updateCustomer(Customer customer) {
        if (customer.getId() == null || !customerRepository.existsById(customer.getId())) {
            throw new RuntimeException("Customer doesn't exist!");
        }
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        if (!customerRepository.existsById(customer.getId())) {
            throw new RuntimeException("Customer doesn't exist!");
        }
        customerRepository.delete(customer);
    }

    public void deleteCustomerById(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer doesn't exist!");
        }
        customerRepository.deleteById(id);
    }
}
