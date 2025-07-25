package com.customer.billing.prototype.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invoiceId;

    private Double totalCost;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @JsonBackReference  // ✅ Prevent infinite recursion but allow deserialization
    private BillingAccount account;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BillingAccount getAccount() {
        return account;
    }

    public void setAccount(BillingAccount account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Invoice [Invoice ID=" + invoiceId + ", Total Cost=" + totalCost + ", Date=" + date + "]";
    }
}
