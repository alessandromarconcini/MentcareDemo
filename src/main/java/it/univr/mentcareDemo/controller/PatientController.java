package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.Appointment;
import it.univr.mentcareDemo.model.Doctor;
import it.univr.mentcareDemo.model.Drug;
import it.univr.mentcareDemo.model.repository.AppointmentRepository;
import it.univr.mentcareDemo.model.repository.DoctorRepository;
import it.univr.mentcareDemo.model.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DrugRepository drugRepository;

    @GetMapping("/getPatientAllAppointments")
    public List<Appointment> getPatientAllAppointments(){

        List<Appointment> appointmentList = new ArrayList<>();

        for(Appointment a: appointmentRepository.findAll())
            appointmentList.add(a);

        return appointmentList;
    }

    @GetMapping("/getPatientDoctor/{doctorId}")
    public Doctor getPatientDoctor(@PathVariable Long doctorId){

        Doctor d = doctorRepository.findById(doctorId).get();

        if(doctorRepository.findById(doctorId).isPresent())
            return d;

        return d;
    }

    @GetMapping("/getPatientAllDrugs")
    public List<Drug> getPatientAllDrugs(){

        List<Drug> drugList = new ArrayList<>();

        for(Drug d: drugRepository.findAll())
            drugList.add(d);

        return drugList;
    }
}
