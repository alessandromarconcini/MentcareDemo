package model;

import model.exception.IllegalPrescriptionException;
import model.exception.IllegalReportException;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private String name;
    private String text;

    public Report(){}

    public Report(LocalDate date, String name, String text) {

        if(date == null || name == null || text == null)
            throw new IllegalReportException();

        this.id = id;
        this.date = date;
        this.name = name;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
