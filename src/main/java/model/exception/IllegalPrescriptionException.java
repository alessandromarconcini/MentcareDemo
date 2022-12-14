package model.exception;

public class IllegalPrescriptionException extends IllegalArgumentException{

    public IllegalPrescriptionException(Long id){ super("Invalid id initialization for Prescription, see constructor for details");}
    public IllegalPrescriptionException(){ super("Invalid field initialization for Prescription, see construcor for details");}
}
