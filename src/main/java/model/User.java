package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


/**
 * Classe rappresentante un utente generico del sistema Mentcare
 */

@Entity
public class User {

    private String name;
    private String surname;
    @Id @GeneratedValue
    private int id;
    private String password;
    private String fiscalCode;
    private String birthplace;
    private LocalDate birthday;

    public User(String name, String surname, int id, String password, String fiscalCode, String birthplace,
                LocalDate birthday) {
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
