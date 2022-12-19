package model.exception;

public class IllegalReceptionistException extends IllegalArgumentException{

    public IllegalReceptionistException(Integer id){super("Invalid id initialization for Receptionist, see constructor for details");}
    public IllegalReceptionistException(){super("Invalid field initialization for Receptionist, see constructor for details");}

}
