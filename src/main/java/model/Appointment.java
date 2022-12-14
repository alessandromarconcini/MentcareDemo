package model;

import model.exception.IllegalAppointmentException;
import model.exception.IllegalUserException;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    //NOTE Considerare i campi con il @Join come elementi per la relazione nel database
    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;

    private LocalDate date;

    @OneToOne
    private Patient patient;

    @OneToOne
    private Doctor doctor;

    public Appointment() {}

    public Appointment(Integer id, Nurse nurse, LocalDate date, Patient patient, Doctor doctor) {

        if(id < 0)
            throw new IllegalAppointmentException(id);
        if(nurse == null || date == null || patient == null || doctor == null)
            throw new IllegalAppointmentException();

        this.id = id;
        this.nurse = nurse;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
