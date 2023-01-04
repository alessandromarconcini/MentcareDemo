package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.*;
import it.univr.mentcareDemo.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class NurseController {
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @GetMapping("/getNurseHospitalList/{nurseId}")
    public List<Hospital> getNurseHospitalList(@PathVariable Long nurseId){

        List<Hospital> hospitalList = new ArrayList<>();

        Optional<Nurse> on = nurseRepository.findById(nurseId);

        if(on.isPresent()){

            Nurse n = on.get();

            if(n.isANurse())
                for(Hospital h:hospitalRepository.findAll())
                    hospitalList.add(h);
        }

        return hospitalList;
    }

    @GetMapping("searchPatient/{nurseId}/{name}")
    public Patient searchPatient(@PathVariable Long nurseId,@PathVariable String name){

        Optional<Nurse> on = nurseRepository.findById(nurseId);

        if(on.isPresent()){
            Nurse n = on.get();
            if(n.isANurse())
                return patientRepository.findByName(name);
        }

        return null;
    }

    // La prescrizione dettagliata viene fornita dalla view
    @PutMapping("makeDosing/{nurseId}/{patientId}/{prescriptionId}")
    public void makeDosing(@PathVariable Long nurseId,@PathVariable Long patientId,@PathVariable Long prescriptionId){

        Optional<Nurse> on = nurseRepository.findById(nurseId);
        Optional<Patient> op = patientRepository.findById(patientId);
        Optional<Prescription> opres = prescriptionRepository.findById(prescriptionId);


        if(on.isPresent() && op.isPresent() && opres.isPresent()){
            Nurse n = on.get();
            Patient p = op.get();

            if(n.isANurse()) {
                p.setPrescription(opres.get());
                patientRepository.save(p);
            }
        }
    }

    @GetMapping("getNurseAppointmentList/{nurseId}")
    public List<Appointment> getNurseAppointmentList(@PathVariable Long nurseId){

        List<Appointment> appointmentList = new ArrayList<>();
        Optional<Nurse> on = nurseRepository.findById(nurseId);

        if(on.isPresent()){
            Nurse n = on.get();

            if(n.isANurse())
                for(Appointment a: appointmentRepository.findAll())
                    if(a.getNurse().equals(n))
                        appointmentList.add(a); //TODO soluzione diversa trovata in DoctorController per recuperare la lista degli appuntamenti senza crearne una nuova e ripopolarla. Usa il metodo "getNurseAppointmentList" richiamato su "n"
        }

        return appointmentList;
    }

    @GetMapping("getNurseDailyPatientList/{nurseId}")
    public List<Patient> getNurseDailyPatientList(@PathVariable Long nurseId){

        List<Patient> dailyPatientList= new ArrayList<>();
        LocalDate now = LocalDate.now();
        Optional<Nurse> on = nurseRepository.findById(nurseId);

        if(on.isPresent()){
            Nurse n = on.get();

            if(n.isANurse())
                for (Appointment a:appointmentRepository.findAll()) //Cerco gli appuntamenti per la data di oggi
                    if(a.getDate().equals(now))
                        dailyPatientList.add(a.getPatient()); // Ma mi interessano i pazienti
        }

        return dailyPatientList;
    }


    //NOTE Non è possibile mettere nella path tutto il text
    @PutMapping("postRegistrationMessage/{nurseId}")
    public void postRegistrationMessage(@PathVariable Long nurseId,@RequestParam String text){

        Optional<Nurse> on = nurseRepository.findById(nurseId);

        if(on.isPresent() && on.get().isANurse())
            messageRepository.save(new Message(text));
    }
}
