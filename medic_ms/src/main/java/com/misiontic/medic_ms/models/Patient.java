package com.misiontic.medic_ms.models;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;

public class Patient {
    @Id
    final private Long id;
    private String name;
    private String lastname;
    private LocalDate dateBirth;
    private Long phoneNumber;
    private String email;
    private String bloodType;
    private Boolean is_active;

    public Patient(Long id, String name,String lastname,LocalDate dateBirth,Long phoneNumber,String email,String bloodType){
        this.id=id;
        this.name=name;
        this.lastname=lastname;
        this.dateBirth=dateBirth;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.bloodType=bloodType;
        this.is_active=true;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setPhoneNumber(Long phoneNumber) {
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