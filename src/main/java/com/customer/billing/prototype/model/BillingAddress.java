package com.customer.billing.prototype.model;

import jakarta.persistence.*;

@Entity
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String street;
    private String avenue;
    private Integer postalCode;
    private Integer buildingNo;
    private Integer doorNo;
    private String city;
    private String country;

    protected BillingAddress() {}

    public BillingAddress(Integer id, Integer postalCode, Integer buildingNo, Integer doorNo,
                          String street, String avenue, String city, String country){
        this.id = id;
        this.street = street;
        this.avenue = avenue;
        this.postalCode = postalCode;
        this.buildingNo = buildingNo;
        this.doorNo = doorNo;
        this.city = city;
        this.country = country;
    }

    public Integer getId(){
        return id;
    }

    public Integer getPostalCode(){
        return postalCode;
    }

    public Integer getBuildingNo(){
        return buildingNo;
    }

    public Integer getDoorNo(){
        return doorNo;
    }

    public String getStreet(){
        return street;
    }

    public String getAvenue(){
        return avenue;
    }

    public String getCity(){
        return city;
    }

    public String getCountry(){
        return country;
    }

    @Override
    public String toString() {
        return "Billing Address[Address ID = " + id +
                ", Street = " + street +
                ", Avenue = " + avenue +
                ", Postal Code = " + postalCode +
                ", Apartment No = " + buildingNo +
                ", Door No = " + doorNo +
                ", City = " + city +
                ", Country = " + country + "]";
    }
}
