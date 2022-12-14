package model;

import model.exception.IllegalClinicException;
import model.exception.IllegalPrescriptionException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String textReport;
    @OneToMany
    private List<Drug> drugList = new ArrayList<>();
    private LocalDate lastModify;

    public Prescription(){}

    public Prescription(Long id, String textReport, List<Drug> drugList, LocalDate lastModify) {

        if(id < 0)
            throw new IllegalPrescriptionException(id);
        if(textReport == null || textReport.isEmpty() || drugList == null || lastModify == null)
            throw new IllegalPrescriptionException();

        this.id = id;
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

    public LocalDate getLastModify() {
        return lastModify;
    }

    public void setLastModify(LocalDate lastModify) {
        this.lastModify = lastModify;
    }
}
