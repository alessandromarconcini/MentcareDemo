package model.exception;

public class IllegalHospitalException extends IllegalArgumentException{

    public IllegalHospitalException(){ super("Bad Hospital field initialization, see constructor for details");}
}
