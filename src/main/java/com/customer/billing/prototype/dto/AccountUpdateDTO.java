package com.customer.billing.prototype.dto;

public class AccountUpdateDTO {
    private Integer id;           // BillingAccount id
    private Integer customerId;   // Customer id to link
    private Integer addressId;    // BillingAddress id to link

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}
