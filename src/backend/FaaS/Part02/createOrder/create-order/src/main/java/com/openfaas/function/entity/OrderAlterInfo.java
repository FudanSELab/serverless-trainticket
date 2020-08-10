package com.openfaas.function.entity;

import java.util.UUID;

/**
 * @author fdse
 */
public class OrderAlterInfo {

    private UUID accountId;

    private UUID previousOrderId;

    private String loginToken;

    private Order newOrderInfo;

    public OrderAlterInfo(){
        newOrderInfo = new Order();
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public UUID getPreviousOrderId() {
        return previousOrderId;
    }

    public void setPreviousOrderId(UUID previousOrderId) {
        this.previousOrderId = previousOrderId;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Order getNewOrderInfo() {
        return newOrderInfo;
    }

    public void setNewOrderInfo(Order newOrderInfo) {
        this.newOrderInfo = newOrderInfo;
    }
}
