package com.openfaas.function.entity;

/**
 * @author fdse
 */
public class TripAllDetail {
    private TripResponse tripResponse;

    private Trip trip;

    public TripAllDetail() {
    }

    public TripAllDetail(TripResponse tripResponse, Trip trip) {
        this.tripResponse = tripResponse;
        this.trip = trip;
    }

    public TripResponse getTripResponse() {
        return tripResponse;
    }

    public void setTripResponse(TripResponse tripResponse) {
        this.tripResponse = tripResponse;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
