package com.openfaas.function.entity;

import java.util.UUID;

/**
 * @author fdse
 */

public class User {

    private UUID userId;
    private String userName;
    private String password;

    private int gender;

    private int documentType;

    private String documentNum;

    private String email;

    public User() {
    }

    public User(UUID userId, String userName, String password, int gender, int documentType, String documentNum, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.documentType = documentType;
        this.documentNum = documentNum;
        this.email = email;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(String documentNum) {
        this.documentNum = documentNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
