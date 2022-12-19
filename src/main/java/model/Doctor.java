package model;

import model.exception.IllegalDoctorException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor extends User{

    final boolean PERMISSION_DOCTOR = true;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany
    private List<Appointment> appointmentList = new ArrayList<>();
    private boolean doctorPermission;
    @OneToMany
    private List<Patient> patientList;
    private String phoneNumber;
    @OneToMany
    private List<Message> messageList = new ArrayList<>();
    @OneToMany
    private List<Prescription> prescriptionList;
    private String specialization;

    public Doctor(List<Appointment> appointmentList, List<Patient> patientList, List<Message> messageList,
                  String phoneNumber, List<Prescription> prescriptionList, String specialization) {
        //TODO Per Ale-> Inserire l'attributo doctorPermission come final nel class diagram in quanto l'istanza doctor
        // presuppone l'attributo impostato a TRUE
        if (appointmentList == null)
            throw new IllegalDoctorException();

        if(patientList == null)
            throw new IllegalDoctorException();

        if (phoneNumber == null || phoneNumber.length() < 13)
            throw new IllegalDoctorException();

        if (prescriptionList == null)
            throw new IllegalDoctorException();

        if (specialization == null || specialization.length() == 0)
            throw new IllegalDoctorException();

        if(id< 0)
            throw new IllegalDoctorException(id);

        this.appointmentList = appointmentList;
        this.doctorPermission = PERMISSION_DOCTOR;
        this.patientList = patientList;
        this.messageList = messageList;
        this.phoneNumber = phoneNumber;
        this.prescriptionList = prescriptionList;
        this.specialization = specialization;
    }

    public Doctor() { //NOTE Servono anche dei costruttori vuoti per consentire a springboot il funzionamento del database
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
    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<Message> getMessageList() {
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

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
