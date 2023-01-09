package it.univr.mentcareDemo.controller;
import it.univr.mentcareDemo.model.*;
import it.univr.mentcareDemo.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ManagerController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ReceptionistRepository receptionistRepository;

    //NOTE Non serve un manager che crea utenti generici
    /*@PostMapping("/createUser")
    public User createUser(@RequestParam("name") String name,
                           @RequestParam("surname") String surname,
                           @RequestParam("password") String password,
                           @RequestParam("fiscalCode") String fiscalCode,
                           @RequestParam("birthplace") String birthplace,
                           @RequestParam("birth")String birth){

        User user = new User(name,surname,password,fiscalCode,birthplace,birth);
        userRepository.save(user);
        return user;
    } */

    @PostMapping("/createNurse/{managerId}")
    public Nurse createNurse(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("password") String password,
                            @RequestParam("fiscalCode") String fiscalCode,
                            @RequestParam("birthplace") String birthplace,
                            @RequestParam("appointmentList") List<Appointment> appointmentList,
                            @RequestParam("dailyPatientList")List<Patient> dailyPatientList,
                             @RequestParam("birth") String birthDate,@PathVariable Long managerId){

        Optional<Manager> om = managerRepository.findById(managerId);

        if(om.isPresent() && om.get().isManager()) {

            Nurse n = new Nurse(appointmentList, dailyPatientList, name, surname, password, fiscalCode, birthplace, birthDate);
            nurseRepository.save(n);
            return n;
        }

        return null;
    }

    @PostMapping("/createDoctor/{managerId}")
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
                               @RequestParam("birth")String birthDate,@PathVariable Long managerId){

        Optional<Manager> om = managerRepository.findById(managerId);

        if(om.isPresent() && om.get().isManager()) {

            Doctor d = new Doctor(appointmentList, patientList, messageList, phoneNumber, prescriptionList, specialization, name, surname, password, fiscalCode, birthplace, birthDate);
            doctorRepository.save(d);

            return d;
        }

        return null;
    }

    //TODO Aggiungere nurse al costruttore?
    @PostMapping("/createPatient/{managerId}")
    public void createPatient(@RequestParam("name") String name,
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
                                 @RequestParam("birth")String birthDate,@PathVariable Long managerId){

        Optional<Manager> om = managerRepository.findById(managerId);

        if(om.isPresent() && om.get().isManager()) {
            patientRepository.save(new Patient(appointmentList, prescription, pathology, dangerous, phoneNumber, hospital, name, surname, password, fiscalCode, birthplace, birthDate));

            if (LocalDate.now().getDayOfMonth() == LocalDate.now().getMonth().maxLength() && LocalTime.now().equals(LocalTime.of(17, 0))) {
                ReportController reportController = new ReportController();
                reportController.createReport();
            }
        }
    }

    @PostMapping("/createReceptionist/{managerId}")
    public void createReceptionist(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("password") String password,
                            @RequestParam("fiscalCode") String fiscalCode,
                            @RequestParam("birthplace") String birthplace,
                                   @RequestParam("messageList")List<Message> messageList,
                                           @RequestParam("birth")String birthDate,@PathVariable Long managerId){

        Optional<Manager> om = managerRepository.findById(managerId);

        if(om.isPresent() && om.get().isManager())
            receptionistRepository.save(new Receptionist(messageList,name,surname,password,fiscalCode,birthplace,birthDate));
    }

    @GetMapping("/getManagerAllUser/{managerId}")
    public List<User> getManagerAllUser(@PathVariable Long managerId){

        Optional<Manager> om = managerRepository.findById(managerId);

        if(om.isPresent() && om.get().isManager())
            return (List<User>) userRepository.findAll();

        return new ArrayList<>();
    }

    @GetMapping("/getManagerAllReports/{managerId}")
    public List<Report> getManagerAllReports(@PathVariable Long managerId){

        Optional<Manager> om = managerRepository.findById(managerId);

        if(om.isPresent() && om.get().isManager())
            return (List<Report>) reportRepository.findAll();

        return new ArrayList<>();
    }

    @GetMapping("/getManagerReport/{managerId}/{reportId}")
    public Report getManagerReport(@PathVariable Long managerId,@PathVariable Long reportId){

        Optional<Manager> om = managerRepository.findById(managerId);
        Report r = reportRepository.findById(reportId).get();

        if(reportRepository.findById(reportId).isPresent() && om.isPresent() && om.get().isManager())
            return r;

        return null;
    }

    @PostMapping("/createManager")
    public Manager createManager(@RequestParam("name") String name,
                              @RequestParam("surname") String surname,
                              @RequestParam("password") String password,
                              @RequestParam("fiscalCode") String fiscalCode,
                              @RequestParam("birthplace") String birthplace,
                              @RequestParam("birth")String birthDate){

            Manager m = new Manager(name,surname,password,fiscalCode,birthplace,birthDate);

            managerRepository.save(m);
            return m;
    }
}
