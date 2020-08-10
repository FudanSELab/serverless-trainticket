package com.openfaas.function.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TripInfo {
    private String startingPlace;
    private String endPlace;
    private Date departureTime;

    public TripInfo() {
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

    public String toString() {
        return "startingPlace is " + startingPlace + ";endPlace is " + endPlace + ";departureTime is " + departureTime.toString();
    }

}