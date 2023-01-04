package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.*;
import it.univr.mentcareDemo.model.repository.DoctorRepository;
import it.univr.mentcareDemo.model.repository.PatientRepository;
import it.univr.mentcareDemo.model.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/createPrescription/{doctorId}/{patientId}")
    public void createPrescription(@PathVariable("doctorId") Long doctorId,
                                           @PathVariable("patientId") Long patientId,
                                           @RequestParam("drugList") List<Drug> drugList, // TODO Errore nel class diagram: nel metodo createPrescription scriviamo come parametro di ingresso il nome farmaco come string, ma per creare poi la prescrizione è necessaria una lista di farmaci, modificare don List<Drug>
                                           @RequestParam("textReport") String textReport // TODO Errore nel class diagram: per creare una prescription è necessario un testo come report del dottore
                                           ){
        //TODO è necessario creare anche un DrugController perché ad ora non esiste nessun controller che permette di poter popolare la lista di farmaci con nome farmaco, dose minima e massima, dose assegnata, frequenza di somministrazione
        //in altre parole quando viene creata una nuova prescrizione è necessario richiamare un drug controller che setti i parametri del farmaco e restituisca la lista dei farmaci
        //che deve essere passata a questo metodo

        LocalDate lastModify = LocalDate.now();


        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (doctor.isPresent() && patient.isPresent()){ //se il paziente è presente allora creo la sua prescrizione
            Prescription prescription = new Prescription(textReport, drugList, lastModify);
            prescriptionRepository.save(prescription);

            Patient patient1 = patient.get();
            patient1.setPrescription(prescription);
        }
    }

    @PutMapping("updatePrescription/{doctorId}/{patientId}/{prescriptionId}")
    public void updatePrescription(@PathVariable("doctorId") Long doctorId,
                                           @PathVariable("patientId") Long patientId,
                                           @PathVariable("prescriptionId") Long prescriptionId,
                                           @RequestParam("drugList") List<Drug> drugList, //TODO Errore nel class diagram: vedi riga 22
                                           @RequestParam("textReport") String textReport)  //TODO Errore nel class diagram: vedi riga 23
    {

        LocalDate lastModify = LocalDate.now();


        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (doctor.isPresent() && patient.isPresent()) { //se il paziente è presente allora modifico la sua prescrizione
            prescriptionRepository.deleteById(prescriptionId); //cancello la prescrizione vecchia perché ogni paziente ha solo un unica prescrizione come da specifiche requisiti
            Prescription newPrescription = new Prescription(textReport, drugList, lastModify); // allora la vecchia viene sostituita con la nuova

            prescriptionRepository.save(newPrescription);
        }
    }

    @PutMapping("deleteDrugFromPrescription/{doctorId}/{patientId}/{prescriptionId}")
    public void deleteDrugFromPrescription(@PathVariable("doctorId") Long doctorId,
                                           @PathVariable("patientId") Long patientId,
                                           @PathVariable("prescriptionId") Long prescriptionId){

        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Patient> patient = patientRepository.findById(patientId);
        Optional<Prescription> prescription = prescriptionRepository.findById(prescriptionId);

        if (doctor.isPresent() && patient.isPresent() && prescription.isPresent()){
            prescriptionRepository.deleteById(prescriptionId);
        }
    }

    @GetMapping("getDoctorAppointmentList/{doctorId}")
    public List<Appointment> getDoctorAppointmentList(@PathVariable("doctorId") Long doctorId){
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);

        if(doctor.isPresent()){
            Doctor doctorToRepository = doctor.get();
            return  doctorToRepository.getAppointmentList();
        }
        return null;
    }

    @GetMapping("getDoctorPatientList/{doctorId}")
    public List<Patient> getDoctorPatientList(@PathVariable("doctorId") Long doctorId){
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);

        if(doctor.isPresent()){
            Doctor doctorToRepository = doctor.get();
            return  doctorToRepository.getPatientList();
        }
        return null;
    }

    @GetMapping("getDoctorMessageList/{doctorId}")
    public List<Message> getDoctorMessageList(@PathVariable("doctorId") Long doctorId){
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);

        if(doctor.isPresent()){
            Doctor doctorToRepository = doctor.get();
            return  doctorToRepository.getMessageList();
        }
        return null;
    }

    @GetMapping("getDoctorPrescriptionList/{doctorId}")
    public List<Prescription> getDoctorPrescriptionList(@PathVariable("doctorId") Long doctorId){
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);

        if(doctor.isPresent()){
            Doctor doctorToRepository = doctor.get();
            return  doctorToRepository.getPrescriptionList();
        }
        return null;
    }

    @GetMapping("getDoctorPhoneNumber/{doctorId}")
    public String getDoctorPhoneNumber(@PathVariable("doctorId") Long doctorId){
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);

        if(doctor.isPresent()){
            Doctor doctorToRepository = doctor.get();
            return  doctorToRepository.getPhoneNumber();
        }
        return null;
    }
}
