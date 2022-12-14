package model.exception;

public class IllegalHospitalException extends IllegalArgumentException{

    public IllegalHospitalException(Long id){ super("Invalid Hospital id, see constructor for details");}

    public IllegalHospitalException(){ super("Bad Hospital field initialization, see constructor for details");}
}
