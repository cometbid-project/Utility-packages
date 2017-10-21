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
public enum PhoneNoType {

    HOME("Home") {
        @Override
        String apply() {
            return "";
        }
    },
    OFFICE("Office") {
        @Override
        String apply() {
            return "";
        }
    },
    MOBILE("Mobile") {
        @Override
        String apply() {
            return "";
        }
    },
    CELL("Cellular") {
        @Override
        String apply() {
            return "";
        }
    };

    private final String typeName;

    PhoneNoType(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }

    // Implementing a fromString method on an enum type
    private static final Map<String, PhoneNoType> stringToEnum
                         = new HashMap<String, PhoneNoType>();

    static { // Initialize map from constant name to enum constant
        for (PhoneNoType op : values()) {
            stringToEnum.put(op.toString(), op);
        }
    }
    
   // Returns Operation for string, or null if string is invalid

    public static PhoneNoType fromString(String typeName) {
        return stringToEnum.get(typeName);
    }

    abstract String apply();
}
