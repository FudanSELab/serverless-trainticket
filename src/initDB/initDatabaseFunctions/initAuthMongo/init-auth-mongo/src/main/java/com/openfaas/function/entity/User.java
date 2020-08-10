package com.openfaas.function.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author fdse
 */
public class User {

    private UUID userId;

    private String username;

    private String password;

    private Set<String> roles = new HashSet<>();


    public User() {
    }

    public User(UUID userId, String username, String password,Set<String> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roles=roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
