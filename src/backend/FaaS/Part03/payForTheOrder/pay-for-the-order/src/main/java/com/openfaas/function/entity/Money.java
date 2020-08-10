package com.openfaas.function.entity;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;

import java.util.UUID;

/**
 * @author fdse
 */
//@Document(collection="addMoney")
public class Money {

//    @Valid
//    @NotNull
//    @Id
    private String id;

//    @Valid
//    @NotNull
    private String userId;

//    @Valid
//    @NotNull
    private String money; //NOSONAR

//    @Valid
//    @NotNull
    private MoneyType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Money(){
        this.id = UUID.randomUUID().toString();
        this.userId = "";
        this.money = "";

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

    public MoneyType getType() {
        return type;
    }

    public void setType(MoneyType type) {
        this.type = type;
    }
}
