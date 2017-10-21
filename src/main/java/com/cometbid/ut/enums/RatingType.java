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
public enum RatingType {

    FIRST("first") {
        @Override
        String apply() {
            return "";
        }
    },
    SECOND("second") {
        @Override
        String apply() {
            return "";
        }
    },
    THIRD("third") {
        @Override
        String apply() {
            return "";
        }
    },
    FOURTH("fourth") {
        @Override
        String apply() {
            return "";
        }
    },
    FIFTH("fifth") {
        @Override
        String apply() {
            return "";
        }
    },
    SIXTH("sixth") {
        @Override
        String apply() {
            return "";
        }
    },
    SEVENTH("seventh") {
        @Override
        String apply() {
            return "";
        }
    },
    EIGTH("eigth") {
        @Override
        String apply() {
            return "";
        }
    },
    NINTH("ninth") {
        @Override
        String apply() {
            return "";
        }
    },
    TENTH("tenth") {
        @Override
        String apply() {
            return "";
        }
    };

    private final String typeName;

    RatingType(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }

    // Implementing a fromString method on an enum type
    private static final Map<String, RatingType> stringToEnum
            = new HashMap<String, RatingType>();

    static { // Initialize map from constant name to enum constant
        for (RatingType op : values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    // Returns Operation for string, or null if string is invalid
    public static RatingType fromString(String typeName) {
        return stringToEnum.get(typeName);
    }

    abstract String apply();

}
