package com.openfaas.function.entity;

/**
 * @author fdse
 */
public class VerifyResult {

    private boolean status;

    private String message;

    public VerifyResult() {
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
}
