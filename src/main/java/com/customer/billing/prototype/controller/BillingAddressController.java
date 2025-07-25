package com.customer.billing.prototype.controller;

import com.customer.billing.prototype.model.BillingAddress;
import com.customer.billing.prototype.service.BillingAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class BillingAddressController {

    private final BillingAddressService addressService;

    public BillingAddressController(BillingAddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<BillingAddress> createAddress(@RequestBody BillingAddress address) {
        BillingAddress newAddress = addressService.createAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAddress);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillingAddress> getAddressById(@PathVariable Integer id) {
        try {
            BillingAddress address = addressService.getAddressById(id);
            return ResponseEntity.ok(address);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<BillingAddress>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillingAddress> updateAddress(@RequestBody BillingAddress address, @PathVariable Integer id) {
        if (!id.equals(address.getId())) {
            return ResponseEntity.badRequest().build();
        }

        try {
            BillingAddress updated = addressService.updateAddress(address);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable Integer id) {
        try {
            addressService.deleteAddressById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
