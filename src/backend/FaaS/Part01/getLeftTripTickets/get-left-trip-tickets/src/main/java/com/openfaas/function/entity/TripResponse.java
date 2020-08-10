package com.openfaas.function.entity;

import java.util.Date;


public class TripResponse {

    private TripId tripId;

    private String trainTypeId;

    private String startingStation;

    private String terminalStation;

    private Date startingTime;

    private Date endTime;

    private int economyClass;

    private int confortClass;

    private String priceForEconomyClass;

    private String priceForConfortClass;

    public TripResponse(){
        //Default Constructor
    }

    public TripId getTripId() {
        return tripId;
    }

    public void setTripId(TripId tripId) {
        this.tripId = tripId;
    }

    public String getTrainTypeId() {
        return trainTypeId;
    }

    public void setTrainTypeId(String trainTypeId) {
        this.trainTypeId = trainTypeId;
    }

    public String getStartingStation() {
        return startingStation;
    }

    public void setStartingStation(String startingStation) {
        this.startingStation = startingStation;
    }

    public String getTerminalStation() {
        return terminalStation;
    }

    public void setTerminalStation(String terminalStation) {
        this.terminalStation = terminalStation;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getEconomyClass() {
        return economyClass;
    }

    public void setEconomyClass(int economyClass) {
        this.economyClass = economyClass;
    }

    public int getConfortClass() {
        return confortClass;
    }

    public void setConfortClass(int confortClass) {
        this.confortClass = confortClass;
    }

    public String getPriceForEconomyClass() {
        return priceForEconomyClass;
    }

    public void setPriceForEconomyClass(String priceForEconomyClass) {
        this.priceForEconomyClass = priceForEconomyClass;
    }

    public String getPriceForConfortClass() {
        return priceForConfortClass;
    }

    public void setPriceForConfortClass(String priceForConfortClass) {
        this.priceForConfortClass = priceForConfortClass;
    }

}
