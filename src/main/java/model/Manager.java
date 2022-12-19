package model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Manager extends User{
    public Boolean adminPermissions = true;
    public Manager(
                   String name, String surname, String password, String fiscalCode, String birthPlace, LocalDate birthDay) {

        super(name,surname,password,fiscalCode,birthPlace,birthDay);
    }
    public Manager() {}

    public Boolean IsAnAdmin() { return adminPermissions; }
}
