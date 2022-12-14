package model.exception;

public class IllegalClinicException extends IllegalArgumentException{

    public IllegalClinicException(Long id){super("Invalid id for Clinic, see constructor for details");}
    public IllegalClinicException(){super("Invalid field initialization for Clinic, see constructor for details");}
}
