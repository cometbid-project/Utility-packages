package com.cometbid.ut.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class MissingUsernameException extends ApplicationDefinedExceptions {

    public MissingUsernameException() {
        super("Username is missing in request");
    }

    public MissingUsernameException(String message) {
        super(message);
    }

    public MissingUsernameException(String message, Throwable ex) {
        super(message, ex);
    }
}
