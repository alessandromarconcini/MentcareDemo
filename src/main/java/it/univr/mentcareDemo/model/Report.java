package it.univr.mentcareDemo.model;

import it.univr.mentcareDemo.model.exception.IllegalReportException;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private String name;

    @Column(length = 65536)
    private String text;

    private Boolean ready = false;

    public Report(){}

    public Report(LocalDate date, String name, String text) {

        if(date == null || name == null || text == null || ready == null)
            throw new IllegalReportException();

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

    public void setReady(Boolean ready) {this.ready = ready;}

    public String toString(){return this.text;}
}
