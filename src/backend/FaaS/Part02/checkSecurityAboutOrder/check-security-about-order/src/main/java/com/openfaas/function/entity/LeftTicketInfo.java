package com.openfaas.function.entity;

//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author fdse
 */
public class LeftTicketInfo {
//    @Valid
//    @NotNull
    private Set<Ticket> soldTickets;

    public LeftTicketInfo(){
        //Default Constructor
    }

    public Set<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(Set<Ticket> soldTickets) {
        this.soldTickets = soldTickets;
    }

    @Override
    public String toString() {
        return "LeftTicketInfo{" +
                "soldTickets=" + soldTickets +
                '}';
    }
}
