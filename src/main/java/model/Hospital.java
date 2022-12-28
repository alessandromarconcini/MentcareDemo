package model;

import model.exception.IllegalHospitalException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hospital {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;

    @OneToMany
    private List<Patient> patientList = new ArrayList<>();
    private Integer countAvailability;

    public Hospital(String name, String phoneNumber, String address, List<Patient> patientList, Integer countAvailability) {

        if(name == null || phoneNumber == null || address == null || patientList == null || countAvailability == null)
            throw new IllegalHospitalException();
        if(name.length() == 0||phoneNumber.length() == 0 || address.length() == 0 || countAvailability < 0)
            throw new IllegalHospitalException();

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.patientList = patientList;
        this.countAvailability = countAvailability;
    }

    public Hospital() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public Integer getCountAvailability() {
        return countAvailability;
    }

    public void setCountAvailability(Integer countAvailability) {
        this.countAvailability = countAvailability;
    }
}