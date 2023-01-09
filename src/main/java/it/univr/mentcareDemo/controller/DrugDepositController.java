package it.univr.mentcareDemo.controller;

import it.univr.mentcareDemo.model.Doctor;
import it.univr.mentcareDemo.model.DrugDeposit;
import it.univr.mentcareDemo.model.Nurse;
import it.univr.mentcareDemo.model.repository.DrugDepositRepository;
import it.univr.mentcareDemo.model.repository.NurseRepository;
import it.univr.mentcareDemo.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DrugDepositController {
    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private DrugDepositRepository drugDepositRepository;

    @GetMapping("getNurseDrugDeposit/{nurseId}")
    public List<DrugDeposit> getNurseDrugDeposit(@PathVariable Long nurseId){

        List<DrugDeposit> drugDepositList = new ArrayList<>();
        Optional<Nurse> on = nurseRepository.findById(nurseId);

        if(on.isPresent() && on.get().isANurse())

            for(DrugDeposit dd:drugDepositRepository.findAll())
                drugDepositList.add(dd);


        return drugDepositList;
    }
}
