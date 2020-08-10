package com.openfaas.function.entity;

/**
 * @author fdse
 */
public class GetOrderByIdInfo {

    private String orderId;

    public GetOrderByIdInfo() {
        //Default Constructor
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
