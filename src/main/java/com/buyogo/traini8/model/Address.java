package com.buyogo.traini8.model;

import jakarta.persistence.*;

@Embeddable
public class Address {

    private String detailAddress;
    private String city;
    private String state;
    private long pincode;

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }
}
