package com.openfaas.function.entity;

//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author fdse
 */
public class Seat {
//    @Valid
//    @NotNull
    private Date travelDate;

//    @Valid
//    @NotNull
    private String trainNumber;


//    @Valid
//    @NotNull
    private String startStation;

//    @Valid
//    @NotNull
    private String destStation;

//    @Valid
//    @NotNull
    private int seatType;

    public Seat(){
        //Default Constructor
        this.travelDate = new Date();
        this.trainNumber = "";
        this.startStation = "";
        this.destStation = "";
        this.seatType = 0;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getDestStation() {
        return destStation;
    }

    public void setDestStation(String destStation) {
        this.destStation = destStation;
    }

    public int getSeatType() {
        return seatType;
    }

    public void setSeatType(int seatType) {
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "travelDate=" + travelDate +
                ", trainNumber='" + trainNumber + '\'' +
                ", startStation='" + startStation + '\'' +
                ", destStation='" + destStation + '\'' +
                ", seatType=" + seatType +
                '}';
    }
}
