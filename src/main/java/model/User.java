package model;

import model.exception.IllegalUserException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


/**
 * Classe rappresentante un utente generico del sistema Mentcare
 */

@Entity
public class User {

    //TODO Verificare di gruppo se l'id è limitabile con delle annotazioni a 8 cifre
    // Cerchiamo una funzionalità che limita il valore a 99.999.99 e poi ricomicia da 0
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private String password;
    private String fiscalCode;
    private String birthplace;
    private LocalDate birthday;

    //NOTE Nel costruttore effettuo i controlli per assicurarmi che quando creo un oggetto di tipo User, ottengo un oggetto i cui campi sono validi

    public User(String name, String surname, int id, String password, String fiscalCode, String birthplace,
                LocalDate birthday) {

        //NOTE è buona prassi mettere i controlli prima delle righe this.name=...
        if(name == null || name.length() <= 0)
            throw new IllegalUserException();
        if(surname == null || surname.length() <= 0)
            throw new IllegalUserException();
        if(id < 0)
            throw new IllegalUserException(id);
        if(password == null || password.length() <=0)
            throw new IllegalUserException();
        //NOTE Il codice fiscale è una stringa lunga 16 caratteri massimi
        if(fiscalCode == null || fiscalCode.length() != 16 )
            throw new IllegalUserException();
        if(birthplace == null || birthplace.length() <= 0)
            throw new IllegalUserException();
        //NOTE La classe LocalDate impone già di suo controlli sulla data
        if(birthday == null)
            throw new IllegalUserException(birthday);

        this.name = name;
        this.surname = surname;
        this.id = id;
        this.password = password;
        this.fiscalCode = fiscalCode;
        this.birthplace = birthplace;
        this.birthday = birthday;
    }

    // é necessario realizzare anche un costruttore vuoto per ogni classe model se si vuole utilizzare nel database
    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getBirthplace() {
        return birthplace;
    }

}
