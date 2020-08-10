package com.openfaas.function.entity;

import java.io.Serializable;

/**
 * @author fdse
 */
public class TripId implements Serializable {
    private Type type;
    private String number;

    public TripId(Type type, String number) {
        this.type = type;
        this.number = number;
    }

    public TripId() {
        //Default Constructor
    }

    public TripId(String trainNumber) {
        char type0 = trainNumber.charAt(0);
        switch (type0) {
            case 'G':
                this.type = Type.G;
                break;
            case 'D':
                this.type = Type.D;
                break;
            default:
                break;
        }

        this.number = trainNumber.substring(1);
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return type.getName() + number;
    }
}
