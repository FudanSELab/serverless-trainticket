package com.openfaas.function.dto;

/**
 * user-service register user , then send to auth-service
 *
 * @author fdse
 */
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class AuthDto {

    private String userId;
    private String userName;
    private String password;

    public AuthDto(){}

    public AuthDto(String userId,String userName,String password){
        this.userId=userId;
        this.userName=userName;
        this.password=password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
}
