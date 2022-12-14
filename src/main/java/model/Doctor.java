package model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Doctor extends User{

    final boolean PERMISSION_DOCTOR = true;
    private List<Appointment> appointmentList;
    private final boolean doctorPermission;
    @OneToMany
    private List<Patient> patientList;
    private String phoneNumber;
    private List<String> messageList;
    @OneToMany
    private List<Prescription> prescriptionList;
    private String specialization;

    public Doctor(List<Appointment> appointmentList, List<Patient> patientList, List<String> messageList,
                  String phoneNumber, List<Prescription> prescriptionList, String specialization) {
        //TODO Per Ale-> Inserire l'attributo doctorPermission come final nel class diagram in quanto l'istanza doctor
        // presuppone l'attributo impostato a TRUE
        if (appointmentList == null)
            throw new IllegalArgumentException();

        if(patientList == null)
            throw  new IllegalArgumentException();

        if (phoneNumber == null || phoneNumber.length() < 13)
            throw new IllegalArgumentException();

        if (prescriptionList == null)
            throw  new IllegalArgumentException();

        if (specialization == null || specialization.length() == 0)
            throw new IllegalArgumentException();

        this.appointmentList = appointmentList;
        this.doctorPermission = PERMISSION_DOCTOR;
        this.patientList = patientList;
        this.messageList = messageList;
        this.phoneNumber = phoneNumber;
        this.prescriptionList = prescriptionList;
        this.specialization = specialization;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public boolean isDoctor() {
        return doctorPermission;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    //TODO per Ale-> inserire nel class diagram il metodo setMessageList, in quanto deve essere associato ad una lista di
    // messaggi (in controller poi aggiungere un modifica, assegna, crea message list etc etc)
    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    public List<String> getMessageList() {
        return messageList;
    }
    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    //TODO per Ale-> inserire nel class diagram il metodo setPrescriptionList, in quanto ogni medico deve essere associato
    // ad una lista di prescrizioni da lui effettuate(in controller poi aggiungere un modifica, assegna, crea lista prescrizioni etc etc)
    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


}
