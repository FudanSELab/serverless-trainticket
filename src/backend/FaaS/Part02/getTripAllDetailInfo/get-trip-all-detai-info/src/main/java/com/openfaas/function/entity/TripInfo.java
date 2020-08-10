package com.openfaas.function.entity;

//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author fdse
 */
public class TripInfo {

//    @Valid
//    @NotNull
    private String startingPlace;

//    @Valid
//    @NotNull
    private String endPlace;

//    @Valid
//    @NotNull
    private Date departureTime;

    public TripInfo(){
        //Default Constructor
        this.startingPlace = "";
        this.endPlace = "";
        this.departureTime = new Date();
    }

    public String getStartingPlace() {
        return startingPlace;
    }

    public void setStartingPlace(String startingPlace) {
        this.startingPlace = startingPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
}
