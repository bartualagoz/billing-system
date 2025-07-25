package com.customer.billing.prototype.service;

import com.customer.billing.prototype.model.BillingAccount;
import com.customer.billing.prototype.model.BillingAddress;
import com.customer.billing.prototype.model.Customer;
import com.customer.billing.prototype.repository.BillingAccountRepository;
import com.customer.billing.prototype.repository.BillingAddressRepository;
import com.customer.billing.prototype.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingAccountService {

    private final BillingAccountRepository billingAccountRepository;
    private final CustomerRepository customerRepository;
    private final BillingAddressRepository addressRepository;

    public BillingAccountService(BillingAccountRepository billingAccountRepository,
                                 CustomerRepository customerRepository,
                                 BillingAddressRepository addressRepository) {
        this.billingAccountRepository = billingAccountRepository;
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    public BillingAccount createAccount(BillingAccount billingAccount) {
        if (billingAccount.getId() != null && billingAccountRepository.existsById(billingAccount.getId())) {
            throw new RuntimeException("Billing account already exists!");
        }

        // Attach managed Customer entity
        Integer customerId = billingAccount.getCustomer().getId();
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
        billingAccount.setCustomer(customer);

        // Attach managed BillingAddress entity
        Integer addressId = billingAccount.getAddress().getId();
        BillingAddress address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found with ID: " + addressId));
        billingAccount.setAddress(address);

        return billingAccountRepository.save(billingAccount);
    }

    public BillingAccount getAccountById(Integer id) {
        Optional<BillingAccount> optional = billingAccountRepository.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("Account doesn't exist!"));
    }

    public List<BillingAccount> getAllAccounts() {
        return billingAccountRepository.findAll();
    }

    public BillingAccount updateAccount(BillingAccount account) {
        if (!billingAccountRepository.existsById(account.getId())) {
            throw new RuntimeException("Account doesn't exist!");
        }

        // Attach managed Customer entity
        Integer customerId = account.getCustomer().getId();
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
        account.setCustomer(customer);

        // Attach managed BillingAddress entity
        Integer addressId = account.getAddress().getId();
        BillingAddress address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found with ID: " + addressId));
        account.setAddress(address);

        return billingAccountRepository.save(account);
    }

    public void deleteAccount(BillingAccount account) {
        if (!billingAccountRepository.existsById(account.getId())) {
            throw new RuntimeException("Account doesn't exist!");
        }
        billingAccountRepository.delete(account);
    }

    public void deleteAccountById(Integer id) {
        if (!billingAccountRepository.existsById(id)) {
            throw new RuntimeException("Account doesn't exist!");
        }
        billingAccountRepository.deleteById(id);
    }
}
