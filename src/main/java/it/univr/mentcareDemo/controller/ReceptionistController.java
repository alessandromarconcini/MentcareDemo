package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.*;
import it.univr.mentcareDemo.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ReceptionistController {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository; // for search and select patient
    @Autowired
    private ReceptionistRepository receptionistRepository;
    @Autowired
    private DoctorRepository doctorRepository; // for select and search doctor

    // new appointment
    @PostMapping("/createAppointment/{receptionistId}/{doctorId}/{patientId}")

    public void createAppointment(@PathVariable("receptionistId") Long receptionistId,
                                  @PathVariable("doctorId") Long doctorId,
                                  @PathVariable("patientId") Long patientId,
                                  @RequestParam("nurse") Nurse nurse,
                                  @RequestParam("patient") Patient patient,
                                  @RequestParam("doctor") Doctor doctor) {

        LocalDate date = LocalDate.now();

        Optional<Doctor> od = doctorRepository.findById(doctorId);
        Optional<Patient> op = patientRepository.findById(patientId);
        Optional<Receptionist> receptionist = receptionistRepository.findById(receptionistId);

        if (od.isPresent() && op.isPresent() && receptionist.isPresent() && receptionist.get().isAReceptionist()) {
            Appointment appointment = new Appointment(nurse, date, patient, doctor);
            appointmentRepository.save(appointment);
        }
    }


    // update appointment
    @PutMapping("updateAppointment/{receptionistId}/{appointmentId}")
    public void updateAppointment(@PathVariable("appointmentId") Long oldAppointmentId,
                                  @PathVariable("receptionistId") Long receptionistId,
                                  @RequestParam("appointment") Appointment newAppointment){

        Optional<Appointment> oldAppointment = appointmentRepository.findById(oldAppointmentId);
        Optional<Receptionist> receptionist = receptionistRepository.findById(receptionistId);

        if (receptionist.isPresent() && receptionist.get().isAReceptionist() && oldAppointment.isPresent()) { // modifico l'appuntamento vecchio

            appointmentRepository.deleteById(oldAppointmentId); //è possibile cancellare un appuntamento preso
            appointmentRepository.save(newAppointment);
        }
    }
    // Receptionist appointment list
    @GetMapping("getReceptionistAppointmentList/{recptionistId}")
    public List<Appointment> getReceptionistAppointmentList(@PathVariable("recptionistId") Long recptionistId){

        Optional<Receptionist> receptionist = receptionistRepository.findById(recptionistId);

        if(receptionist.isPresent()){
            return  (List<Appointment>) appointmentRepository.findAll();
        }
        return null;
    }
    // delete an appointment
    @PutMapping("deleteAppointment/{receptionistId}/{doctorId}/{patientId}/{appointmentId}")
    public void deleteAppointment (@PathVariable("receptionistId") Long receptionistId,
                                   @PathVariable("appointmentId") Long appointmentId){


        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
        Optional<Receptionist> or= receptionistRepository.findById(receptionistId);

        if (or.isPresent() && or.get().isAReceptionist() && appointment.isPresent()){
            appointmentRepository.deleteById(appointmentId);
        }
    }
    // search and select a patient
    @GetMapping("searchPatient/{receptionistId}/{appointmentId}/{name}")
    public Patient searchPatient(@PathVariable Long receptionistId,@PathVariable Long appointmentId,@PathVariable String name){

        Optional<Appointment> oa = appointmentRepository.findById(appointmentId);
        Optional<Patient> op = patientRepository.findByName(name);
        Optional<Receptionist> or= receptionistRepository.findById(receptionistId);


        if(oa.isPresent() && op.isPresent() && oa.get().getPatient().equals(op.get()) && or.isPresent() && or.get().isAReceptionist()){

            return op.get();
        }

        return null;
    }
    // search and select a doctor
    @GetMapping("searchDoctor/{receptionistId}/{appointmentId}/{name}")
    public Doctor searchDoctor(@PathVariable Long appointmentId, @PathVariable Long receptionistId, @PathVariable String name){

        Optional<Appointment> oa = appointmentRepository.findById(appointmentId);
        Optional<Doctor> od = doctorRepository.findByName(name);
        Optional<Receptionist> or= receptionistRepository.findById(receptionistId);

        if(oa.isPresent() && od.isPresent() && or.isPresent() && oa.get().getDoctor().equals(od.get()) && or.get().isAReceptionist()){

            return od.get();
        }

        return null;
    }

}
