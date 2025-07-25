package com.customer.billing.prototype.dto;

import com.customer.billing.prototype.model.BillingAccount;
import com.customer.billing.prototype.model.BillingAddress;
import com.customer.billing.prototype.model.Customer;
import com.customer.billing.prototype.model.BillingAddress;
import com.customer.billing.prototype.model.Invoice;

import java.util.List;
import java.util.stream.Collectors;

public class BillingAccountDTO {

    private Integer id;
    private CustomerBasicDTO customer;
    private BillingAddress address;
    private List<InvoiceDTO> invoices;

    public BillingAccountDTO(BillingAccount account) {
        this.id = account.getId();

        Customer c = account.getCustomer();
        if (c != null) {
            this.customer = new CustomerBasicDTO(c);
        }

        this.address = account.getAddress();

        if (account.getInvoices() != null) {
            this.invoices = account.getInvoices().stream()
                    .map(InvoiceDTO::new)
                    .collect(Collectors.toList());
        }
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public CustomerBasicDTO getCustomer() {
        return customer;
    }

    public BillingAddress getAddress() {
        return address;
    }

    public List<InvoiceDTO> getInvoices() {
        return invoices;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustomer(CustomerBasicDTO customer) {
        this.customer = customer;
    }

    public void setAddress(BillingAddress address) {
        this.address = address;
    }

    public void setInvoices(List<InvoiceDTO> invoices) {
        this.invoices = invoices;
    }

    // Nested DTO classes for safe exposure

    public static class CustomerBasicDTO {
        private Integer id;
        private String firstName;
        private String lastName;
        private String email;

        public CustomerBasicDTO(Customer customer) {
            this.id = customer.getId();
            this.firstName = customer.getFirstName();
            this.lastName = customer.getLastName();
            this.email = customer.getEmail();
        }

        // Getters and setters

        public Integer getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class InvoiceDTO {
        private Integer invoiceId;
        private double totalCost;
        private String date;

        public InvoiceDTO(Invoice invoice) {
            this.invoiceId = invoice.getInvoiceId();
            this.totalCost = invoice.getTotalCost();
            this.date = invoice.getDate().toString();
        }

        // Getters and setters

        public Integer getInvoiceId() {
            return invoiceId;
        }

        public double getTotalCost() {
            return totalCost;
        }

        public String getDate() {
            return date;
        }

        public void setInvoiceId(Integer invoiceId) {
            this.invoiceId = invoiceId;
        }

        public void setTotalCost(double totalCost) {
            this.totalCost = totalCost;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
