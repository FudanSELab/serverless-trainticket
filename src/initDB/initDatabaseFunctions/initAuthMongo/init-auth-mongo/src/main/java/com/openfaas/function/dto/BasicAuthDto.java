package com.openfaas.function.dto;

import java.io.Serializable;

/**
 * user login dto
 *
 * @author fdse
 */

public class BasicAuthDto implements Serializable {
    private static final long serialVersionUID = 5505144168320447022L;
    private String username;
    private String password;

    public BasicAuthDto() {
    }

    public BasicAuthDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
