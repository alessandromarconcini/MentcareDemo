package model;

import model.exception.IllegalClinicException;
import model.exception.IllegalEventException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Clinic{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String phoneNumber;
    @OneToMany
    private List<Patient> patientList = new ArrayList<>();
    @OneToMany
    private List<Doctor> doctorList = new ArrayList<>();
    @OneToMany
    private List<Nurse> nurseList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clinic(){}

    public Clinic(Long id, String name, String phoneNumber, List<Patient> patientList, List<Doctor> doctorList, List<Nurse> nurseList) {

        if(id < 0)
            throw new IllegalClinicException(id);
        if(name == null || phoneNumber == null || patientList == null || doctorList == null || nurseList == null)
            throw new IllegalClinicException();
        if(phoneNumber.length() > 13)
            throw new IllegalClinicException();

        this.id = id;
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