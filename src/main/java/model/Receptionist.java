package model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Receptionist extends User{
    @OneToMany
    private List<Message> messageList;

    //TODO Per Ale-> Inserire l'attributo receptionistPermission come final nel class diagram in quanto l'istanza receptionist
    // presuppone l'attributo impostato a TRUE
    private final boolean receptionistPermission = true;

    public Receptionist(List<Message> messageList,
                        String name, String surname, String password, String fiscalCode, String birthPlace, LocalDate birthDay) {

        super(name,surname,password,fiscalCode,birthPlace,birthDay);

        if(messageList == null)
            throw  new IllegalArgumentException();

        this.messageList = messageList;
    }

    public Receptionist(){}

    public boolean isAReceptionist() {
        return this.receptionistPermission;
    }

    //TODO per Ale-> inserire nel class diagram il metodo setMessageList, in quanto un receptionist
    // deve essere associato ad una lista di messaggi, che sarebbero i messaggi associati alla reception
    // (in controller poi aggiungere un modifica, assegna, crea lista prescrizioni etc etc)
    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    //TODO per Ale-> Inserire nel class diagram il metodo getMessageList() in quanto per ogni istanza di receptionist sicuramente
    // nel controllore ci servirà un metodo per ottenere la lista dei messaggi associata alla reception
    public List<Message> getMessageList() {
        return messageList;
    }

}
