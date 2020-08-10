package com.openfaas.function.entity;

import java.util.Map;

/**
 * @author fdse
 */
public class TravelResult {

    private boolean status;

    private double percent;

    private TrainType trainType;

    private Map<String,String> prices;

    private String message;

    public TravelResult() {
        //Default Constructor
    }

}
