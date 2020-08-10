package com.openfaas.function.entity;

/**
 * @author fdse
 */
public class OutsidePaymentInfo {
    public OutsidePaymentInfo(){
        //Default Constructor
    }

    private String orderId;
    private String price;
    private String userId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
