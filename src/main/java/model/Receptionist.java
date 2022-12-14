package model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Receptionist extends User{

    final boolean RECEPTIONIST_PERMISSION = true;
    @OneToMany
    private List<String> messageList;

    //TODO Per Ale-> Inserire l'attributo receptionistPermission come final nel class diagram in quanto l'istanza receptionist
    // presuppone l'attributo impostato a TRUE
    private final boolean receptionistPermission;

    public Receptionist(List<String> messageList) {
        if(messageList == null)
            throw  new IllegalArgumentException();

        this.messageList = messageList;
        this.receptionistPermission = RECEPTIONIST_PERMISSION;
    }

    public boolean isAReceptionist() {
        return this.receptionistPermission;
    }

    //TODO per Ale-> inserire nel class diagram il metodo setMessageList, in quanto un receptionist
    // deve essere associato ad una lista di messaggi, che sarebbero i messaggi associati alla reception
    // (in controller poi aggiungere un modifica, assegna, crea lista prescrizioni etc etc)
    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    //TODO per Ale-> Inserire nel class diagram il metodo getMessageList() in quanto per ogni istanza di receptionist sicuramente
    // nel controllore ci servirà un metodo per ottenere la lista dei messaggi associata alla reception
    public List<String> getMessageList() {
        return messageList;
    }

}
