package model;

import java.util.ArrayList;

@Entity
public class Patient extends User {

    private List<Appointment> appointmentList = new ArrayList<>();
    private Boolean patientPermissions;
    private String phoneNumber;
    private Boolean dangerous;
    private Prescription prescription;
    private String pathology;

    public Patient(List<Appointment> appointmentList, Boolean patientPermissions, Prescription prescription,
                   String pathology, Boolean dangerous, String phoneNumber) {

        if (appointmentList == null)
            throw new IllegalArgumentException();

        //NOTE: pathology.length() == 0 se il campo è vuoto
        if (pathology == null || pathology.length() == 0)
            throw new IllegalArgumentException();


        if (phoneNumber == null || phoneNumber.length() < 0 || phoneNumber.length() > 13)
            throw new IllegalArgumentException();

        this.appointmentList = appointmentList;
        this.patientPermissions = patientPermissions;
        this.dangerous = dangerous;
        this.pathology = pathology;
        this.phoneNumber = phoneNumber;
    }

    public Boolean isAPatient() { return patientPermissions; }

    public Boolean isDangerous() { return dangerous; }

    public List<Appointment> getAppointmentList() {return appointmentList; }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }

    public String getPhoneNumber() { return phoneNumber; }

    public Prescription getPrescription() { return prescription; }

    public void setPathology(String pathology) { this.pathology = pathology; }

    public String getPathology() { return pathology; }

}