package com.openfaas.function.entity;

//import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author fdse
 */
//@Document(collection="addMoney")
public class Money {
    private String userId;
    private String money; //NOSONAR


    public Money(){
        //Default Constructor
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
