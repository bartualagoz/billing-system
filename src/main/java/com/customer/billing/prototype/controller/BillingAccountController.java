package com.customer.billing.prototype.controller;

import com.customer.billing.prototype.dto.AccountRequestDTO;
import com.customer.billing.prototype.dto.AccountUpdateDTO;
import com.customer.billing.prototype.dto.BillingAccountDTO;
import com.customer.billing.prototype.model.BillingAccount;
import com.customer.billing.prototype.model.BillingAddress;
import com.customer.billing.prototype.model.Customer;
import com.customer.billing.prototype.repository.BillingAddressRepository;
import com.customer.billing.prototype.repository.CustomerRepository;
import com.customer.billing.prototype.service.BillingAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
public class BillingAccountController {

    private final BillingAccountService accountService;
    private final CustomerRepository customerRepository;
    private final BillingAddressRepository addressRepository;

    public BillingAccountController(BillingAccountService accountService,
                                    CustomerRepository customerRepository,
                                    BillingAddressRepository addressRepository) {
        this.accountService = accountService;
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    // Return safe DTO instead of entity
    @GetMapping("/{id}")
    public ResponseEntity<BillingAccountDTO> getAccountById(@PathVariable Integer id) {
        try {
            BillingAccount account = accountService.getAccountById(id);
            BillingAccountDTO dto = new BillingAccountDTO(account);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Return list of safe DTOs instead of entities
    @GetMapping
    public ResponseEntity<List<BillingAccountDTO>> getAllAccounts() {
        List<BillingAccountDTO> dtos = accountService.getAllAccounts()
                .stream()
                .map(BillingAccountDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<BillingAccount> createAccount(@RequestBody AccountRequestDTO dto) {
        try {
            Customer customer = customerRepository.findById(dto.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));

            BillingAddress address = addressRepository.findById(dto.getAddressId())
                    .orElseThrow(() -> new RuntimeException("Address not found"));

            BillingAccount account = new BillingAccount();
            account.setCustomer(customer);
            account.setAddress(address);

            BillingAccount saved = accountService.createAccount(account);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillingAccount> updateAccount(@RequestBody AccountUpdateDTO dto, @PathVariable Integer id) {
        if (!id.equals(dto.getId())) {
            return ResponseEntity.badRequest().build();
        }

        try {
            BillingAccount existingAccount = accountService.getAccountById(id);

            Customer customer = customerRepository.findById(dto.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            existingAccount.setCustomer(customer);

            BillingAddress address = addressRepository.findById(dto.getAddressId())
                    .orElseThrow(() -> new RuntimeException("Address not found"));
            existingAccount.setAddress(address);

            BillingAccount updated = accountService.updateAccount(existingAccount);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable Integer id) {
        try {
            accountService.deleteAccountById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
