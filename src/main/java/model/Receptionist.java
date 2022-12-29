package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Receptionist{

    @Id @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messageList = new ArrayList<>();

    //TODO Per Ale-> Inserire l'attributo receptionistPermission come final nel class diagram in quanto l'istanza receptionist
    // presuppone l'attributo impostato a TRUE

    public Receptionist(List<Message> messageList,
                        String name, String surname, String password, String fiscalCode, String birthPlace, LocalDate birthDay) {

        //super(name,surname,password,fiscalCode,birthPlace,birthDay);

        if(messageList == null)
            throw  new IllegalArgumentException();

        this.messageList = messageList;
    }

    public Receptionist(){}

    public boolean isAReceptionist() {
        return true;
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
