package com.customer.billing.prototype.service;

import java.util.List;

import com.customer.billing.prototype.repository.BillingAddressRepository;
import com.customer.billing.prototype.model.BillingAddress;
import org.springframework.stereotype.Service;

@Service
public class BillingAddressService {

    private final BillingAddressRepository addressRepository;

    public BillingAddressService(BillingAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public BillingAddress createAddress(BillingAddress address) {
        BillingAddress existing = addressRepository.findByStreetAndAvenueAndPostalCodeAndDoorNo(
                address.getStreet(),
                address.getAvenue(),
                address.getPostalCode(),
                address.getDoorNo()
        ).orElse(null);

        if (existing != null) {
            throw new RuntimeException("This address already exists!");
        }

        return addressRepository.save(address);
    }

    public BillingAddress getAddressById(Integer id) {
        BillingAddress address = addressRepository.findById(id).orElse(null);
        if (address == null) {
            throw new RuntimeException("Address not found!");
        }
        return address;
    }

    public List<BillingAddress> getAllAddresses() {
        return addressRepository.findAll();
    }

    public BillingAddress updateAddress(BillingAddress address) {
        if (!addressRepository.existsById(address.getId())) {
            throw new RuntimeException("Address doesn't exist!");
        }
        return addressRepository.save(address);
    }

    public void deleteAddress(BillingAddress address) {
        if (!addressRepository.existsById(address.getId())) {
            throw new RuntimeException("Address doesn't exist!");
        }
        addressRepository.delete(address);
    }

    public void deleteAddressById(Integer id) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete: Address not found!");
        }
        addressRepository.deleteById(id);
    }
}
