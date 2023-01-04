package it.univr.mentcareDemo.model;

import it.univr.mentcareDemo.model.exception.IllegalNurseException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Nurse  extends User{

    //NOTE In Java il tipo List<T> con T generico si differenzia in Vector,ArrayList e LinkedList, a noi interessa il secondo
    //NOTE  L'annotazione @OneToMany è uno strumentopolo misterioso che ci servirà più tardi
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointmentList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patient> dailyPatientList = new ArrayList<>();

    public Nurse(List<Appointment> appointmentList, List<Patient> dailyPatientList,
                 String name, String surname, String password, String fiscalCode, String birthPlace, String birth) {

        super(name,surname,password,fiscalCode,birthPlace,birth);

        if (appointmentList == null)
            throw new IllegalNurseException();
        if (dailyPatientList == null)
            throw new IllegalNurseException();

        this.appointmentList = appointmentList;
        this.dailyPatientList = dailyPatientList;
    }
    public Nurse() {}

    public Boolean isANurse() {return true; }

    public List<Appointment> getAppointmentList() { return appointmentList; }

    public List<Patient> getDailyPatientList() { return dailyPatientList; }

}
