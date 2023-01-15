package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.*;
import it.univr.mentcareDemo.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/getPatientAllAppointments")
    public String getPatientAllAppointments(@RequestParam(name="id", required=true) Long patientId,
                                                       Model model){

        List<Appointment> appointmentList = new ArrayList<>();

        if(patientRepository.findById(patientId).isPresent()) {

            Patient p = patientRepository.findById(patientId).get();

            for (Appointment a : appointmentRepository.findAll())
                if (a.getPatient().equals(p))
                    appointmentList.add(a);
        }
        model.addAttribute("appointmentList", appointmentList);
        return "getPatientAllAppointments";
    }

    @RequestMapping("/getPatientDoctor/{patientId}/{doctorId}")
    public String getPatientDoctor(@RequestParam(name="id", required=true) Long patientId,
                                   @RequestParam(name="id", required=true) Long doctorId,
                                   Model model){

        Optional<Patient> op = patientRepository.findById(patientId);

        if(op.isPresent()){ // Check presenza nel database

            Patient p = op.get();

            if(p.isAPatient()){ //Permessi

                Optional<Doctor> od = doctorRepository.findById(doctorId);

                if(od.isPresent()){ //Check presenza nel database

                    Doctor doctor = od.get();

                   if(doctor.getPatientList().contains(p)) //Check che il dottore sia di patient
                       model.addAttribute("doctor", doctor);
                   return "getPatientDoctor";
                }
            }
        }

        //Altrimenti ritorna null
        return "notfound";
    }

    @RequestMapping("/getPatientAllDrugs")
    public String getPatientAllDrugs(@RequestParam(name="id", required=true) Long patientId,
                                     Model model){

        List<Drug> drugList = new ArrayList<>();
        Optional<Patient> op = patientRepository.findById(patientId);

        if(op.isPresent()) { //Check paziente presente
            Patient p = op.get();
            if(p.isAPatient()){ //Permessi del paziente
                for(Prescription pres:prescriptionRepository.findAll())
                    if(p.getPrescription().equals(pres)) // Verifico se stiamo parlando della stessa pres
                        model.addAttribute("drugList", drugList);
                return "getPatientAllDrugs";
            }

        }

        return "notfound";
    }
}
