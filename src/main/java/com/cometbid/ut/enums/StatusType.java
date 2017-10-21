/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gbenga
 */
public enum StatusType {

    ACTIVATED("Activated") {
        @Override
        String apply() {
            return "";
        }
    },
    NEW("New") {
        @Override
        String apply() {
            return "";
        }
    },
    OLD("Old") {
        @Override
        String apply() {
            return "";
        }
    },
    DEACTIVATED("Deactivated") {
        @Override
        String apply() {
            return "";
        }
    },
    INVALID("Invalid") {
        @Override
        String apply() {
            return "";
        }
    },
    VALID("Valid") {
        @Override
        String apply() {
            return "";
        }
    },
    VERIFIED("Verified") {
        @Override
        String apply() {
            return "";
        }
    };

    private final String typeName;

    StatusType(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }

    // Implementing a fromString method on an enum type
    private static final Map<String, StatusType> stringToEnum
            = new HashMap<String, StatusType>();

    static { // Initialize map from constant name to enum constant
        for (StatusType op : values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    // Returns Operation for string, or null if string is invalid
    public static StatusType fromString(String typeName) {
        return stringToEnum.get(typeName);
    }

    abstract String apply();

}
