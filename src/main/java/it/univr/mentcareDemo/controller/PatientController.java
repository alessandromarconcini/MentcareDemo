package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.*;
import it.univr.mentcareDemo.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @GetMapping("/getPatientAllAppointments/{patientId}")
    public List<Appointment> getPatientAllAppointments(@PathVariable Long patientId){

        List<Appointment> appointmentList = new ArrayList<>();

        if(patientRepository.findById(patientId).isPresent()) {

            Patient p = patientRepository.findById(patientId).get();

            for (Appointment a : appointmentRepository.findAll())
                if (a.getPatient().equals(p))
                    appointmentList.add(a);
        }

        return appointmentList;
    }

    @GetMapping("/getPatientDoctor/{patientId}/{doctorId}")
    public Doctor getPatientDoctor(@PathVariable Long patientId,@PathVariable Long doctorId){

        Optional<Patient> op = patientRepository.findById(patientId);

        if(op.isPresent()){ // Check presenza nel database

            Patient p = op.get();

            if(p.isAPatient()){ //Permessi

                Optional<Doctor> od = doctorRepository.findById(doctorId);

                if(od.isPresent()){ //Check presenza nel database

                    Doctor d = od.get();

                   if(d.getPatientList().contains(p)) //Check che il dottore sia di patient
                       return d;
                }
            }
        }

        //Altrimenti ritorna null
        return null;
    }

    @GetMapping("/getPatientAllDrugs/{patientId}")
    public List<Drug> getPatientAllDrugs(@PathVariable Long patientId){

        List<Drug> drugList = new ArrayList<>();
        Optional<Patient> op = patientRepository.findById(patientId);

        if(op.isPresent()) { //Check paziente presente
            Patient p = op.get();
            if(p.isAPatient()){ //Permessi del paziente
                for(Prescription pres:prescriptionRepository.findAll())
                    if(p.getPrescription().equals(pres)) // Verifico se stiamo parlando della stessa pres
                        return pres.getDrugList();
            }

        }

        return null;
    }
}
