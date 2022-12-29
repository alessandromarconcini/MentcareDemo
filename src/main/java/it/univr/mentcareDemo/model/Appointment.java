package it.univr.mentcareDemo.model;

import it.univr.mentcareDemo.model.exception.IllegalAppointmentException;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //NOTE Considerare i campi con il @Join come elementi per la relazione nel database
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Nurse nurse;

    private LocalDate date;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Doctor doctor;

    public Appointment() {}

    public Appointment(Nurse nurse, LocalDate date, Patient patient, Doctor doctor) {

        if(nurse == null || date == null || patient == null || doctor == null)
            throw new IllegalAppointmentException();

        this.nurse = nurse;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
