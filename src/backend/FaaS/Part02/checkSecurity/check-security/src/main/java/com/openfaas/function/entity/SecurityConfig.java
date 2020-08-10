package com.openfaas.function.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

/**
 * @author fdse
 */
//@Document(collection = "security_config")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityConfig {

    private UUID id;

    private String name;

    private String value;

    private String description;

    public SecurityConfig() {
        //Default Constructor
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
