package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.Prescription;
import it.univr.mentcareDemo.model.repository.DoctorRepository;
import it.univr.mentcareDemo.model.repository.DrugRepository;
import it.univr.mentcareDemo.model.repository.PatientRepository;
import it.univr.mentcareDemo.model.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Checker {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private DrugRepository drugRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public Boolean existingPrescription(Long prescriptionId){return prescriptionRepository.existsById(prescriptionId);}

    //TODO Da fare con l'interfaccia grafica
    public Boolean checkDose(){ return false;    }

    public Boolean existingDrug(Long drugId){ return drugRepository.existsById(drugId);

    }

    //TODO Da fare con l'interfaccia grafica
    public Boolean occupiedFields(){
        return false;
    }

    public Boolean doctorAppointmentCheck(Long doctorId){ return doctorRepository.existsById(doctorId);}

    public Boolean existingPatient(Long patientId){ return patientRepository.existsById(patientId);}
}
