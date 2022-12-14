package model;

import java.util.ArrayList;
import java.util.List;

public class Nurse {

    private List<Appointment> appointmentList = new ArrayList<>();
    private Boolean nursePermission;
    private List<Patient> dailyPatientList = new ArrayList<>();

    public Nurse(Boolean nursePermission, List<Appointment> appointmentList, List<Patient> dailyPatientList) {

        if (appointmentList == null)
            throw new IllegalArgumentException();
        if (dailyPatientList == null)
            throw new IllegalArgumentException();


        this.nursePermission = nursePermission;
        this.appointmentList = appointmentList;
        this.dailyPatientList = dailyPatientList;
    }
    public Nurse() {}

    public Boolean isANurse() { return nursePermission; }

    public List<Appointment> getAppointmentList() { return appointmentList; }

    public List<Patient> getDailyPatientList() { return dailyPatientList; }

}
