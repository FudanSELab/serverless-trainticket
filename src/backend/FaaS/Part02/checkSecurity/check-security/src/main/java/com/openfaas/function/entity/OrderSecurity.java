package com.openfaas.function.entity;

/**
 * @author fdse
 */
public class OrderSecurity {

    private int orderNumInLastOneHour;

    private int orderNumOfValidOrder;

    public OrderSecurity() {
        //Default Constructor
    }

    public int getOrderNumInLastOneHour() {
        return orderNumInLastOneHour;
    }

    public void setOrderNumInLastOneHour(int orderNumInLastOneHour) {
        this.orderNumInLastOneHour = orderNumInLastOneHour;
    }

    public int getOrderNumOfValidOrder() {
        return orderNumOfValidOrder;
    }

    public void setOrderNumOfValidOrder(int orderNumOfValidOrder) {
        this.orderNumOfValidOrder = orderNumOfValidOrder;
    }
}
