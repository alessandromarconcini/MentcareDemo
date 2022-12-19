package model.exception;

public class IllegalDoctorException  extends IllegalArgumentException{

    public IllegalDoctorException(Integer id){super("Invalid id initialization for doctor, see constructor for details");}

    public IllegalDoctorException(){super("Invalid doctor field initialization, see constructor for details");}
}
