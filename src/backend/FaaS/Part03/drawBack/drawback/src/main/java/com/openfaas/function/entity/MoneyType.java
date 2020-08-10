package com.openfaas.function.entity;

import java.io.Serializable;

/**
 * @author fdse
 */
public enum MoneyType implements Serializable {

    /**
     * add money
     */
    A("Add Money",1),
    /**
     * draw back money
     */
    D("Draw Back Money",2);

    private String name;
    private int index;

    MoneyType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (MoneyType type : MoneyType.values()) {
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
