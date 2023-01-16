package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.*;
import it.univr.mentcareDemo.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.LinkedList;
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

    @RequestMapping("/")
    public String index() {
        return "login.html";
    }

    // new appointment
    @RequestMapping("/createAppointment/{receptionistId}/{doctorId}/{patientId}")
    public String createAppointment(@RequestParam(name="doctorId", required=true) Long doctorId,
                                  @RequestParam(name="patientId", required=true) Long patientId,
                                  @RequestParam(name="receptionistId", required=true) Long receptionistId,
                                  @RequestParam(name= "nurse", required=true) Nurse nurse,
                                  @RequestParam(name= "patient", required=true) Patient patient,
                                  @RequestParam(name= "doctor", required=true) Doctor doctor,
                                  @RequestParam(name= "hour", required=true) String hour){
//Nota: non metto model per fare model.addattribute perchè seguo la linea del prof, basta fare save
        LocalDate date = LocalDate.now();

        Optional<Doctor> od = doctorRepository.findById(doctorId);
        Optional<Patient> op = patientRepository.findById(patientId);
        Optional<Receptionist> receptionist = receptionistRepository.findById(receptionistId);

        if (od.isPresent() && op.isPresent() && receptionist.isPresent() && receptionist.get().isAReceptionist()) {
            Appointment appointment = new Appointment(nurse, date, patient, doctor, hour);
            op.get().setSetAppointment(appointment);
            appointmentRepository.save(appointment);
            return "redirect:/getReceptionistAppointmentList";
        }
        return "notfound";
    }


    // update appointment
    @RequestMapping("updateAppointment/{receptionistId}/{appointmentId}")
    public String updateAppointment(@RequestParam(name = "appointmentId", required = true) Long oldAppointmentId,
                                    @RequestParam(name = "patientId", required = true) Long patientId,
                                  @RequestParam(name = "receptionistId", required = true) Long receptionistId,
                                  @RequestParam(name = "appointment", required = true) Appointment newAppointment,
                                  Model model){

        Optional<Appointment> oldAppointment = appointmentRepository.findById(oldAppointmentId);
        Optional<Receptionist> receptionist = receptionistRepository.findById(receptionistId);
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (receptionist.isPresent() && receptionist.get().isAReceptionist() && oldAppointment.isPresent()
        && patient.isPresent()) { // modifico l'appuntamento vecchio

            appointmentRepository.deleteById(oldAppointmentId); //è possibile cancellare un appuntamento preso
            appointmentRepository.save(newAppointment);
            patientRepository.delete(patient.get());

            patient.get().setSetAppointment(newAppointment);

            patientRepository.save(patient.get());
            model.addAttribute("newAppointment", newAppointment);
            return "redirect:/getReceptionistAppointmentList";
        }else
            return "notfound";
    }

    // Receptionist appointment list
    @RequestMapping("getReceptionistAppointmentList/{recptionistId}")
    public String getReceptionistAppointmentList(@RequestParam(name = "recptionistId", required = true) Long recptionistId,
                                                            Model model){

        Optional<Receptionist> receptionist = receptionistRepository.findById(recptionistId);
        List<Appointment> dataAppointment = new LinkedList<>();
        if(receptionist.isPresent()){
            for (Appointment p: appointmentRepository.findAll()){
                dataAppointment.add(p);
            }
            model.addAttribute("dataAppointment", dataAppointment);
            return "getReceptionistAppointmentList/{recptionistId}";
        }
        return "notfound";
    }

    // delete an appointment
    @RequestMapping("deleteAppointment/{receptionistId}/{doctorId}/{patientId}/{appointmentId}")
    public String deleteAppointment (@RequestParam(name= "receptionistId", required = true) Long receptionistId,
                                   @RequestParam(name = "appointmentId", required = true) Long appointmentId){


        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
        Optional<Receptionist> or= receptionistRepository.findById(receptionistId);

        if (or.isPresent() && or.get().isAReceptionist() && appointment.isPresent()){
            appointmentRepository.deleteById(appointmentId);
            return "redirect:/getReceptionistAppointmentList";
        }else
            return "notfound";
    }
    // search and select a patient
    @RequestMapping("searchPatient/{receptionistId}/{appointmentId}/{name}")
    public String searchPatient(@PathVariable Long receptionistId,
                                @PathVariable Long appointmentId,
                                @PathVariable String name,
                                Model model){

        Optional<Appointment> oa = appointmentRepository.findById(appointmentId);
        Optional<Patient> op = patientRepository.findByName(name);
        Optional<Receptionist> or= receptionistRepository.findById(receptionistId);


        if(oa.isPresent() && op.isPresent() && oa.get().getPatient().equals(op.get()) && or.isPresent() && or.get().isAReceptionist()){
            model.addAttribute("patient", op);
            return "searchPatient/{receptionistId}/{appointmentId}/{name}";
        }

        return "notfound";
    }

}
