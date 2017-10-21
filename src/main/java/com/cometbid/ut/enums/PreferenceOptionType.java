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
public enum PreferenceOptionType {

    ONE_CHOICE("One Choice",
            "Only one option is allowed for this preference option type") {
        @Override
        String apply() {
            return "";
        }
    },
    MULTIPLE_CHOICE("Multiple Choice",
            "Multiple options are allowed for this preference option type.") {
        @Override
        String apply() {
            return "";
        }
    },
    RANGE("Range",
            "The preference option type allows ranges of values.") {
        @Override
        String apply() {
            return "";
        }
    };

    private final String optionType;

    private final String description;

    PreferenceOptionType(String typeName, String desc) {
        this.optionType = typeName;
        this.description = desc;
    }

    public String getOptionType() {
        return optionType;
    }

    public String getDescription() {
        return description;
    }

    // Implementing a fromString method on an enum type
    private static final Map<String, PreferenceOptionType> stringToEnum
            = new HashMap<String, PreferenceOptionType>();

    static { // Initialize map from constant name to enum constant
        for (PreferenceOptionType op : values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    // Returns Operation for string, or null if string is invalid
    public static PreferenceOptionType fromString(String typeName) {
        return stringToEnum.get(typeName);
    }

    abstract String apply();

    @Override
    public String toString() {
        return "PreferenceOptionType{"
                + "optionType=" + optionType
                + ", description=" + description
                + '}';
    }

}
