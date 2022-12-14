package model.exception;

public class IllegalEventException extends IllegalArgumentException{

    public IllegalEventException(Long id){ super("Invalid id for Event, see constructor for details");}
    public IllegalEventException(){super("Invalid field initialization for Event instance, see constructor for details");}

}
