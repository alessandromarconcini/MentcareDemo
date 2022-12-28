package model;

import model.enumeration.DrugCost;
import model.exception.IllegalDrugException;

import javax.persistence.*;

@Entity
public class Drug {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Float minimumDose;
    private Float maximumDose;
    private Float assignedDose;
    private String frequency;
    private DrugCost cost;
    @ManyToOne
    private Prescription prescription;

    public Drug(){}

    public Drug(String name, Float minimumDose, Float maximumDose, Float assignedDose, String frequency, DrugCost cost) {

        if(name == null || minimumDose == null || maximumDose == null || assignedDose == null || frequency == null || cost == null)
            throw new IllegalDrugException();
        if(minimumDose < 0 || maximumDose < 0 || assignedDose < 0 || maximumDose < minimumDose)
            throw  new IllegalDrugException(assignedDose);

        this.name = name;
        this.minimumDose = minimumDose;
        this.maximumDose = maximumDose;
        this.assignedDose = assignedDose;
        this.frequency = frequency;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMinimumDose() {
        return minimumDose;
    }

    public void setMinimumDose(Float minimumDose) {
        this.minimumDose = minimumDose;
    }

    public Float getMaximumDose() {
        return maximumDose;
    }

    public void setMaximumDose(Float maximumDose) {
        this.maximumDose = maximumDose;
    }

    public Float getAssignedDose() {
        return assignedDose;
    }

    public void setAssignedDose(Float assignedDose) {
        this.assignedDose = assignedDose;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public DrugCost getCost() {
        return cost;
    }

    public void setCost(DrugCost cost) {
        this.cost = cost;
    }
}
