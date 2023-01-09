package it.univr.mentcareDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
A Differenza di Drug che è legato agli utenti, drug deposit invece è l'archivio dei farmaci del deposito
 */
@Entity
public class DrugDeposit {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer counter;
    private Float price;

    public DrugDeposit(String name,Integer counter,Float price){

        if(name == null || counter == null || price == null || name.isEmpty() || counter < 0 || price < 0)
            throw new IllegalArgumentException();

        this.name = name;
        this.counter = counter;
        this.price = price;
    }

    public DrugDeposit(){}

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

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String toString(){
        return name + ": " + counter;
    }
}
