package model.exception;

import java.time.LocalDate;

public class IllegalUserException extends IllegalArgumentException{

    //NOTE la keyword super si occupa di mandare la stringa in input al costruttore della superclasse, nel caso di IllegalArgumentException, il messaggio viene stampato a video da un metodo implementato in questa superclasse
    public IllegalUserException(){ super("Invalid user for void or null field initialization, see User constructor checks for details");}

    public IllegalUserException(Integer id){ super("Invalid id in user fields, see User constructor checks for details");}

    public IllegalUserException(LocalDate date){ super("Invalid BirthDay in user fields, see User constructor checks for details");}
}
