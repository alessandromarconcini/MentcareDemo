package it.univr.mentcareDemo.controller;
import it.univr.mentcareDemo.model.*;
import it.univr.mentcareDemo.model.repository.ReportRepository;
import it.univr.mentcareDemo.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReportRepository reportRepository;

    @PostMapping("/createUser")
    public User createUser(@RequestParam("name") String name,
                           @RequestParam("surname") String surname,
                           @RequestParam("password") String password,
                           @RequestParam("fiscalCode") String fiscalCode,
                           @RequestParam("birthplace") String birthplace,
                           @RequestParam("birth")String birth){

        User user = new User(name,surname,password,fiscalCode,birthplace,birth);
        userRepository.save(user);
        return user;
    }

    @PostMapping("/createNurse")
    public Nurse createNurse(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("password") String password,
                            @RequestParam("fiscalCode") String fiscalCode,
                            @RequestParam("birthplace") String birthplace,
                            @RequestParam("appointmentList") List<Appointment> appointmentList,
                            @RequestParam("dailyPatientList")List<Patient> dailyPatientList,
                             @RequestParam("birth") String birthDate){

        Nurse nurse = new Nurse(appointmentList,dailyPatientList,name,surname,password,fiscalCode,birthplace,birthDate);
        userRepository.save(nurse);
        return nurse;
    }

    @PostMapping("/createDoctor")
    public Doctor createDoctor(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("password") String password,
                            @RequestParam("fiscalCode") String fiscalCode,
                            @RequestParam("birthplace") String birthplace,
                            @RequestParam("appointmentList") List<Appointment> appointmentList,
                            @RequestParam("patientList")List<Patient> patientList,
                             @RequestParam("messageList")List<Message> messageList,
                             @RequestParam("prescriptionList")List<Prescription> prescriptionList,
                             @RequestParam("specialization")String specialization,
                             @RequestParam("phoneNumber")String phoneNumber,
                               @RequestParam("birth")String birthDate){

        Doctor doctor = new Doctor(appointmentList,patientList,messageList,phoneNumber,prescriptionList,specialization,name,surname,password,fiscalCode,birthplace,birthDate);
        userRepository.save(doctor);
        return doctor;
    }

    //TODO Aggiungere nurse al costruttore?
    @PostMapping("/createPatient")
    public Patient createPatient(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("password") String password,
                            @RequestParam("fiscalCode") String fiscalCode,
                            @RequestParam("birthplace") String birthplace,
                            @RequestParam("appointmentList") List<Appointment> appointmentList,
                              @RequestParam("phoneNumber")String phoneNumber,
                              @RequestParam("dangerous")Boolean dangerous,
                              @RequestParam("prescription")Prescription prescription,
                              @RequestParam("pathology")String pathology,
                              @RequestParam("hospital")Hospital hospital,
                                 @RequestParam("birth")String birthDate){

        Patient patient = new Patient(appointmentList,prescription,pathology,dangerous,phoneNumber,hospital,name,surname,password,fiscalCode,birthplace,birthDate);
        userRepository.save(patient);
        return patient;
    }

    @PostMapping("/createReceptionist")
    public Receptionist createReceptionist(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("password") String password,
                            @RequestParam("fiscalCode") String fiscalCode,
                            @RequestParam("birthplace") String birthplace,
                                   @RequestParam("messageList")List<Message> messageList,
                                           @RequestParam("birth")String birthDate){

        Receptionist receptionist = new Receptionist(messageList,name,surname,password,fiscalCode,birthplace,birthDate);
        userRepository.save(receptionist);
        return receptionist;
    }

    @GetMapping("/getManagerAllUser")
    public List<User> getManagerAllUser(){

        List<User> userList = new ArrayList<>();

        for(User u:userRepository.findAll())
            userList.add(u);

        return userList;
    }

    @GetMapping("/getManagerAllReports")
    public List<Report> getManagerAllReports(){
        List<Report> reportList = new ArrayList<>();

        for(Report r:reportRepository.findAll())
            reportList.add(r);

        return reportList;
    }

    @GetMapping("/getManagerReport/{reportId}")
    public Report getManagerReport(@PathVariable Long reportId){

        Report r = reportRepository.findById(reportId).get();

        if(reportRepository.findById(reportId).isPresent())
            return r;

        return r;
    }
}
