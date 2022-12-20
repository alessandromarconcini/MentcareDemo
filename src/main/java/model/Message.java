package model;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String text;

    @JoinColumn(name = "doctor_id")
    @ManyToOne
    private Doctor doctor;

    @JoinColumn(name = "receptionist_id")
    @ManyToOne
    private Receptionist receptionist;

    public Message(String text) {
        this.text = text;
    }

    public Message(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
