package model.exception;

public class IllegalDrugException extends IllegalArgumentException{

    public IllegalDrugException(Long id){ super("Invalid id for Drug, see constructor for details");}
    public IllegalDrugException(){super("Invalid Drug field initialization, see constructor dor details");}
    public IllegalDrugException(Float dose){super("Invalid values for minimum or maximum dose in Drug initialization, Actual assignedDose is " + dose);}
}
