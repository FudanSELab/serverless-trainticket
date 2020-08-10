package com.openfaas.function.entity;

/**
 * @author fdse
 */
public class GetAccountByIdInfo {

    private String accountId;

    public GetAccountByIdInfo() {
        //Default Constructor
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
