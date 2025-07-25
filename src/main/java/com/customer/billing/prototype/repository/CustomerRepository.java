package com.customer.billing.prototype.repository;

import com.customer.billing.prototype.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.customer.billing.prototype.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByFirstNameAndLastNameAndUser(String firstName, String lastName, User user);


    List<Customer> findByUser(User user);

}
