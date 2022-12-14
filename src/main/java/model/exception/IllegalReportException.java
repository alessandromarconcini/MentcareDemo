package model.exception;

public class IllegalReportException extends IllegalArgumentException{

    public IllegalReportException(Long id){super("Invalid id for Report initialization, see constructor for details");}
    public IllegalReportException(){super("Invalid field for Report initialization, see constructor for details");}
}
