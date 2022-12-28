package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Manager extends User{



    public Manager(String name, String surname, String password, String fiscalCode, String birthPlace, LocalDate birthDay) {

        super(name,surname,password,fiscalCode,birthPlace,birthDay);
    }
    public Manager() {}

    public Boolean isManager() { return true; }
}
