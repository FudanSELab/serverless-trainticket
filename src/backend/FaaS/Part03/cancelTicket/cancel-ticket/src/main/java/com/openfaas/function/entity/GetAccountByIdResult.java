package com.openfaas.function.entity;

/**
 * @author fdse
 */
public class GetAccountByIdResult {

    private boolean status;

    private String message;

    private Account account;

    public GetAccountByIdResult() {
        //Default Constructor
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
