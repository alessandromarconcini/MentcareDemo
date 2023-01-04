package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.Prescription;
import it.univr.mentcareDemo.model.repository.PrescriptionRepository;
import org.springframework.stereotype.Controller;

@Controller
public class Checker {
    private final PrescriptionRepository prescriptionRepository;

    public Checker(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Boolean existingPrescription(Prescription p){

        return prescriptionRepository.existsById(p.getId());
    }
}
