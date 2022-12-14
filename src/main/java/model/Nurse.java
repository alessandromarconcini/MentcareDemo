package model;

import model.exception.IllegalNurseException;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Nurse extends User{

    //NOTE In Java il tipo List<T> con T generico si differenzia in Vector,ArrayList e LinkedList, a noi interessa il secondo
    //NOTE  L'annotazione @OneToMany è uno strumentopolo misterioso che ci servirà più tardi
    @OneToMany(fetch = FetchType.LAZY)
    private List<Appointment> appointmentList = new ArrayList<>();
    private Boolean nursePermission;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Patient> dailyPatientList = new ArrayList<>();

    public Nurse(Boolean nursePermission, List<Appointment> appointmentList, List<Patient> dailyPatientList) {

        if (appointmentList == null)
            throw new IllegalNurseException();
        if (dailyPatientList == null)
            throw new IllegalNurseException();

        this.nursePermission = nursePermission;
        this.appointmentList = appointmentList;
        this.dailyPatientList = dailyPatientList;
    }
    public Nurse() {}

    public Boolean isANurse() { return nursePermission; }

    public List<Appointment> getAppointmentList() { return appointmentList; }

    public List<Patient> getDailyPatientList() { return dailyPatientList; }

}
