package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.DrugDeposit;
import it.univr.mentcareDemo.model.Patient;
import it.univr.mentcareDemo.model.Report;
import it.univr.mentcareDemo.model.repository.DrugDepositRepository;
import it.univr.mentcareDemo.model.repository.PatientRepository;
import it.univr.mentcareDemo.model.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DrugDepositRepository drugDepositRepository;

    // Si occupa di creare un report nuovo
    @GetMapping("createReport")
    public Report createReport(){

        // Creo la stringa di default di ogni report

        String text = "Report mensile del mese di " + LocalDate.now().getMonth().name() + "\n\n\n";

        // Inserimento data di creazione
        text += "Data di creazione: " + LocalDate.now().toString() + "\n";

        //Contatore pazienti inseriti

        int counter = 0;

        for(Patient p:patientRepository.findAll())
            if(p.getBornInTheSystem().getMonth() == LocalDate.now().getMonth() &&
            p.getBornInTheSystem().getYear() == LocalDate.now().getYear())
                counter++;

        text += "\nNumero pazienti inseriti nel sistema: " + counter+"\n";

        //Inizializzazione contatore pazienti cancellati
        //TODO Creare il metodo di cancellazione dei pazienti e utilizzare le entità Event

        //Inizializzazione farmaci per nome
        text += "Lista dei farmaci del mese: \n";

        float cost = 0;

        for(DrugDeposit dd:drugDepositRepository.findAll()) {
            text += dd.toString() + "\n";
            cost += dd.getPrice()*dd.getCounter();
        }

        //Inizializzazione costo complessivo farmaci
        text += "Costo complessivo dei farmaci:  \n";

        for(DrugDeposit dd: drugDepositRepository.findAll()) {
            text += dd.getName() + " " + (dd.getPrice() * dd.getCounter()) + "\n";

        }

        text += "Costo totale: " + cost + "\n";

        Report r = new Report(LocalDate.now(),"Report del "+LocalDate.now().getMonth()+ " di " +LocalDate.now().getYear(),text);
        reportRepository.save(r);

        System.out.println(r);

        return r;
    }

}
