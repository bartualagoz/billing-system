package com.customer.billing.prototype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customer.billing.prototype.model.BillingAddress;
import java.util.Optional;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, Integer> {

    Optional<BillingAddress> findByStreetAndAvenueAndPostalCodeAndDoorNo(
            String street, String avenue, Integer postalCode, Integer doorNo
    );

}
