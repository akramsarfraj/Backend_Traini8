package com.buyogo.traini8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "Centers")
public class TrainingCenter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 5, max = 39, message = "Center-Name should have a length in between 5 to 39 character")
    private String centerName;

    /*
        Training Center code must be unique for each center
    */
    @Column(unique = true)
    @Size(min = 12, max = 32, message = "Center-Code should have exactly 12 character")
    private String centerCode;

    private Address address;
    private int studentCapacity;
    private List<String> coursesOffer;
    private LocalTime createdOn;

    /*
        Training Center Email must be unique for each center
    */
    @Column(unique = true)
    @Email(message = "Please enter the valid email Id")
    private String contactEmail;

    /*
       Training Center Contact number must be  unique for each center
   */
    @Column(unique = true)
    @Size(max = 10, min = 10, message = "Please enter the 10-digit contact number")
    private String contactPhone;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public List<String> getCoursesOffer() {
        return coursesOffer;
    }

    public void setCoursesOffer(List<String> coursesOffer) {
        this.coursesOffer = coursesOffer;
    }

    public LocalTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalTime createdOn) {

        this.createdOn = createdOn;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
