package it.univr.mentcareDemo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient extends User {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointmentList = new ArrayList<>();
    private String phoneNumber;
    private Boolean dangerous = false;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Prescription prescription;
    private String pathology;

    private LocalDate bornInTheSystem;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Hospital hospital;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Nurse nurse;

    public Patient(List<Appointment> appointmentList, Prescription prescription,
                   String pathology, Boolean dangerous, String phoneNumber,Hospital hospital,
                   String name, String surname, String password, String fiscalCode, String birthPlace, String birth) {

        super(name,surname,password,fiscalCode,birthPlace,birth);

        if (appointmentList == null)
            throw new IllegalArgumentException();

        //NOTE: pathology.length() == 0 se il campo è vuoto
        if (pathology == null || pathology.length() == 0)
            throw new IllegalArgumentException();

        if (phoneNumber == null || phoneNumber.length() > 13)
            throw new IllegalArgumentException();
        if(hospital == null)
            throw new IllegalArgumentException();

        this.appointmentList = appointmentList;
        this.dangerous = dangerous;
        this.pathology = pathology;
        this.phoneNumber = phoneNumber;
        this.prescription = prescription;
        this.hospital = hospital;
        this.bornInTheSystem = LocalDate.now();
    }

    public Patient() {}

    public Boolean isAPatient() { return true; }

    public Boolean isDangerous() { return dangerous; }

    public List<Appointment> getAppointmentList() {return appointmentList; }

    public void setSetAppointment(Appointment Appointment) {
        this.appointmentList.add(Appointment);
    }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }

    public String getPhoneNumber() { return phoneNumber; }

    public Prescription getPrescription() { return prescription; }

    public void setPathology(String pathology) { this.pathology = pathology; }

    public String getPathology() { return pathology; }

    public void setPrescription(Prescription p){ this.prescription = p;}

    public LocalDate getBornInTheSystem() {
        return bornInTheSystem;
    }
}