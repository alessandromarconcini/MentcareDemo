package model.exception;

public class IllegalAppointmentException extends IllegalArgumentException{

    public IllegalAppointmentException(Integer id) { super("Invalid Appointment id, see constructor for details");}

    public IllegalAppointmentException() { super("Invalid Appointment field is null, see constructor for details");}
}