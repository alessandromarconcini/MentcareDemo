package it.univr.mentcareDemo.model.exception;

public class IllegalEventException extends IllegalArgumentException{

    public IllegalEventException(){super("Invalid field initialization for Event instance, see constructor for details");}

}
