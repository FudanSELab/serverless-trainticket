package com.openfaas.function.entity;

import java.io.Serializable;

/**
 * @author fdse
 */
public enum  PaymentType implements Serializable {

    /**
     * payment
     */
    P("Payment",1),
    /**
     * difference
     */
    D("Difference",2),
    /**
     * outside payment
     */
    O("Outside Payment",3),
    /**
     * difference and outside payment
     */
    E("Difference & Outside Payment",4);

    private String name;
    private int index;

    PaymentType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (PaymentType type : PaymentType.values()) {
            if (type.getIndex() == index) {
                return type.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    void setIndex(int index) {
        this.index = index;
    }
}
