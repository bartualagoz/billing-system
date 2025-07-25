package com.customer.billing.prototype.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BillingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private BillingAddress address;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference  // ✅ Matches the @JsonBackReference in Invoice
    private List<Invoice> invoices = new ArrayList<>();

    public Integer getId() {
        return accountId;
    }

    public void setId(Integer accountId) {
        this.accountId = accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BillingAddress getAddress() {
        return address;
    }

    public void setAddress(BillingAddress address) {
        this.address = address;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "BillingAccount [accountId=" + accountId + "]";
    }
}
