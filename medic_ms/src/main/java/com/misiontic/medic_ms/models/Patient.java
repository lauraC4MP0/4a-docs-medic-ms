package com.misiontic.medic_ms.models;
import org.springframework.data.annotation.Id;
import java.util.Date;

public class Patient {
    @Id
    private String id;
    private String name;
    private String lastname;
    private Date dateBirth;
    private String phoneNumber;
    private String email;
    private String bloodType;
    private Boolean is_active;

    public Patient(String id, String name,String lastname,Date dateBirth,String phoneNumber,String email,String bloodType){
        this.id=id;
        this.name=name;
        this.lastname=lastname;
        this.dateBirth=dateBirth;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.bloodType=bloodType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active){
        this.is_active=is_active;
    }
}