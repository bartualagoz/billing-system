package com.customer.billing.prototype.dto;

import java.time.LocalDate;

public class InvoiceRequestDTO {
    private Double totalCost;
    private LocalDate date;
    private Integer accountId;

    public Double getTotalCost() { return totalCost; }
    public void setTotalCost(Double totalCost) { this.totalCost = totalCost; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Integer getAccountId() { return accountId; }
    public void setAccountId(Integer accountId) { this.accountId = accountId; }
}
