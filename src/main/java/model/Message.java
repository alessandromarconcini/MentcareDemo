package model;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ManyToOne
    private Doctor doctor;

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
