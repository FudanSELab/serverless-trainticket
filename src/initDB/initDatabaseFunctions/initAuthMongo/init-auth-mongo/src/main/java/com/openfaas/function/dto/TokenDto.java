package com.openfaas.function.dto;

import java.io.Serializable;
import java.util.UUID;

/**
 * create token and back to user
 *
 * @author fdse
 */

public class TokenDto implements Serializable {
    private static final long serialVersionUID = 8460179745119402516L;
    private UUID userId;
    private String username;
    private String token;

    public TokenDto() {
    }

    public TokenDto(UUID userId, String username, String token) {
        this.userId = userId;
        this.username = username;
        this.token = token;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
