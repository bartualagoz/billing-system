package com.customer.billing.prototype.dto;

import com.customer.billing.prototype.model.Customer;

public class CustomerDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String nationalId;
    private String phoneNo;
    private String email;

    // Constructor using Customer entity
    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.nationalId = customer.getNationalId();
        this.phoneNo = customer.getPhoneNo();
        this.email = customer.getEmail();
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
