package it.univr.mentcareDemo.model.exception;

public class IllegalClinicException extends IllegalArgumentException{

    public IllegalClinicException(){super("Invalid field initialization for Clinic, see constructor for details");}
}
