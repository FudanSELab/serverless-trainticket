package com.openfaas.function.entity;

//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;

/**
 * @author fdse
 */
public class Balance {
//    @Valid
//    @NotNull
    private String userId;

//    @Valid
//    @NotNull
    private String balance; //NOSONAR

    public Balance(){
        //Default Constructor
        this.userId = "";
        this.balance = "";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
