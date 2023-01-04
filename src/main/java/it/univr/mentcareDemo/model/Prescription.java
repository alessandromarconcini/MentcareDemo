package it.univr.mentcareDemo.model;

import it.univr.mentcareDemo.model.exception.IllegalPrescriptionException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String textReport;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Drug> drugList = new ArrayList<>();
    private Date lastModify;

    public Prescription(){}

    public Prescription(String textReport, List<Drug> drugList, Date lastModify) {

        if(textReport == null || textReport.isEmpty() || drugList == null || lastModify == null)
            throw new IllegalPrescriptionException();

        this.textReport = textReport;
        this.drugList = drugList;
        this.lastModify = lastModify;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextReport() {
        return textReport;
    }

    public void setTextReport(String textReport) {
        this.textReport = textReport;
    }

    public List<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<Drug> drugList) {
        this.drugList = drugList;
    }

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }
}
