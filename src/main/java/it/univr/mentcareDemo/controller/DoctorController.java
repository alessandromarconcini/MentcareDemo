package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.*;
import it.univr.mentcareDemo.model.repository.AppointmentRepository;
import it.univr.mentcareDemo.model.repository.DoctorRepository;
import it.univr.mentcareDemo.model.repository.PatientRepository;
import it.univr.mentcareDemo.model.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
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

    @RequestMapping("/createPrescription/{doctorId}/{patientId}")
    public String createPrescription(@RequestParam(name = "doctorId", required = true) Long doctorId,
                                           @RequestParam(name = "patientId", required = true) Long patientId,
                                           @RequestParam(name = "drugList", required = true) List<Drug> drugList, // TODO Errore nel class diagram: nel metodo createPrescription scriviamo come parametro di ingresso il nome farmaco come string, ma per creare poi la prescrizione è necessaria una lista di farmaci, modificare don List<Drug>
                                           @RequestParam(name = "textReport", required = true) String textReport // TODO Errore nel class diagram: per creare una prescription è necessario un testo come report del dottore
                                           ){
        //TODO è necessario creare anche un DrugController perché ad ora non esiste nessun controller che permette di poter popolare la lista di farmaci con nome farmaco, dose minima e massima, dose assegnata, frequenza di somministrazione
        //in altre parole quando viene creata una nuova prescrizione è necessario richiamare un drug controller che setti i parametri del farmaco e restituisca la lista dei farmaci
        //che deve essere passata a questo metodo

        LocalDate lastModify = LocalDate.now();

        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (doctor.isPresent() && patient.isPresent() && doctor.get().isDoctor()){ //se il paziente è presente allora creo la sua prescrizione

            Prescription prescription = new Prescription(textReport, drugList, lastModify);
            prescriptionRepository.save(prescription);

            Patient patient1 = patient.get();
            patient1.setPrescription(prescription);
            patientRepository.save(patient1);

            return "redirect:/getDoctorPatientList";
        }else
            return "notfound";
    }

    @RequestMapping("updatePrescription/{doctorId}/{patientId}/{prescriptionId}")
    public String updatePrescription(@RequestParam(name = "doctorId", required = true) Long doctorId,
                                   @RequestParam(name = "patientId", required = true) Long patientId,
                                   @RequestParam(name = "prescriptionId", required = true) Long prescriptionId,
                                   @RequestParam(name = "drugList", required = true) List<Drug> drugList, //TODO Errore nel class diagram: vedi riga 22
                                   @RequestParam(name = "textReport", required = true) String textReport)  //TODO Errore nel class diagram: vedi riga 23
    {

        LocalDate lastModify = LocalDate.now();


        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (doctor.isPresent() && patient.isPresent()) { //se il paziente è presente allora modifico la sua prescrizione
            prescriptionRepository.deleteById(prescriptionId); //cancello la prescrizione vecchia perché ogni paziente ha solo un unica prescrizione come da specifiche requisiti
            Prescription newPrescription = new Prescription(textReport, drugList, lastModify); // allora la vecchia viene sostituita con la nuova

            patient.get().setPrescription(newPrescription); //Assegno la nuova prescrizione al paziente
            prescriptionRepository.save(newPrescription);

            return "redirect:/getDoctorPatientList";
        }else
            return "notfound";
    }

    @RequestMapping("deleteDrugFromPrescription/{doctorId}/{patientId}/{prescriptionId}")
    public String deleteDrugFromPrescription(@RequestParam(name = "doctorId", required = true) Long doctorId,
                                           @RequestParam(name = "patientId", required = true) Long patientId,
                                           @RequestParam(name = "prescriptionId", required = true) Long prescriptionId){

        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Patient> patient = patientRepository.findById(patientId);
        Optional<Prescription> prescription = prescriptionRepository.findById(prescriptionId);

        if (doctor.isPresent() && patient.isPresent() && prescription.isPresent()){
            prescriptionRepository.deleteById(prescriptionId);
            return "redirect:/getDoctorPatientList";
        }else
            return "notfound";
    }

    @RequestMapping("getDoctorAppointmentList/{doctorId}")
    public String getDoctorAppointmentList(@RequestParam(name = "doctorId", required = true) Long doctorId,
                                            Model model){
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        List<Appointment> appointmentList;
        if(doctor.isPresent()){
            Doctor doctorToRepository = doctor.get();
            appointmentList = doctorToRepository.getAppointmentList();
            model.addAttribute("appointmentList", appointmentList);
            return  "getDoctorAppointmentList";
        }
        return "notfound";
    }

    @RequestMapping("getDoctorPatientList/{doctorId}")
    public String getDoctorPatientList(@RequestParam(name = "doctorId", required = true) Long doctorId,
                                       Model model){
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        List<Patient> patientList;
        if(doctor.isPresent()){
            Doctor doctorToRepository = doctor.get();
            patientList = doctorToRepository.getPatientList();
            model.addAttribute("patientList", patientList);
            return "getDoctorPatientList";
        }
        return "notfound";
    }

    @RequestMapping("getDoctorPrescriptionList/{doctorId}")
    public String getDoctorPrescriptionList(@RequestParam(name = "doctorId", required = true) Long doctorId,
                                            Model model){
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        List<Prescription> prescriptionList;
        if(doctor.isPresent()){
            Doctor doctorToRepository = doctor.get();
            prescriptionList = doctorToRepository.getPrescriptionList();
            model.addAttribute("prescriptionList", prescriptionList);
            return  "getDoctorPrescriptionList";
        }
        return "notfound";
    }

}
