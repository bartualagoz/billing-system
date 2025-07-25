package com.customer.billing.prototype.model;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer customerId;

    private String firstName;
    private String lastName;
    private String nationalId;
    private String phoneNo;
    private String email;

    // Relation to User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Customer() {}

    public Customer(String firstName, String lastName, String nationalId, String phoneNo, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public void setId(Integer id) {
        this.customerId = id;
    }


    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Integer getId(){
        return customerId;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public String getEmail(){
        return email;
    }

    public String getNationalId(){
        return nationalId;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    @Override
    public String toString() {
        return "Customer[ID =" + customerId + ", firstName ='" + firstName + "', lastName ='" + lastName +
                ", NationalId =" + nationalId + ", PhoneNo = " + phoneNo + ", Email =" + email + "]";
    }
}
