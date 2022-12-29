package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Manager{

    @Id @GeneratedValue
    private Long id;

    public Manager() {

        //super(name,surname,password,fiscalCode,birthPlace,birthDay);
    }

    public Boolean isManager() { return true; }
}
