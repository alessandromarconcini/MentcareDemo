package it.univr.mentcareDemo.model;

import it.univr.mentcareDemo.model.exception.IllegalClinicException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Clinic{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patient> patientList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Doctor> doctorList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Nurse> nurseList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clinic(){}

    public Clinic(String name, String phoneNumber, List<Patient> patientList, List<Doctor> doctorList, List<Nurse> nurseList) {

        if(name == null || phoneNumber == null || patientList == null || doctorList == null || nurseList == null)
            throw new IllegalClinicException();
        if(phoneNumber.length() > 13)
            throw new IllegalClinicException();

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.patientList = patientList;
        this.doctorList = doctorList;
        this.nurseList = nurseList;
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

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public List<Nurse> getNurseList() {
        return nurseList;
    }

    public void setNurseList(List<Nurse> nurseList) {
        this.nurseList = nurseList;
    }
}