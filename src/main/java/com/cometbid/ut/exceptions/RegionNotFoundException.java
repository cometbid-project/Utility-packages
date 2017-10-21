package com.cometbid.ut.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class RegionNotFoundException extends ApplicationDefinedExceptions {

    public RegionNotFoundException() {
        super("Region not found");
    }

    public RegionNotFoundException(String message) {
        super(message);
    }

    public RegionNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }
}
