package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    //NOTE Considerare i campi con il @Join come elementi per la relazione nel database
    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;

    private LocalDate date;

    @OneToOne
    private Patient patient;

    @OneToOne
    private Doctor doctor;

    public Appointment() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
}
