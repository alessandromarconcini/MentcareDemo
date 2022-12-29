package model;

import model.enumeration.Action;
import model.exception.IllegalEventException;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User actor;
    private LocalDate date;
    private Action action;

    public Event(User actor, LocalDate date, Action action) {

        if(actor == null || date == null || action == null)
            throw new IllegalEventException();

        this.actor = actor;
        this.date = date;
        this.action = action;
    }
    public Event(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getActor() {
        return actor;
    }

    public void setActor(User actor) {
        this.actor = actor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
