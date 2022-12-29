package it.univr.mentcareDemo.model.exception;

public class IllegalReportException extends IllegalArgumentException{

    public IllegalReportException(){super("Invalid field for Report initialization, see constructor for details");}
}
