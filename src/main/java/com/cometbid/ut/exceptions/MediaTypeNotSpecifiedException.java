package com.cometbid.ut.exceptions;

import javax.ejb.ApplicationException;
import javax.ejb.EJBException;

@ApplicationException(rollback = true)
public class MediaTypeNotSpecifiedException extends EJBException {

    private static final long serialVersionUID = 1L;

    public MediaTypeNotSpecifiedException() {
        super("Invaid service flow detected");
    }

    public MediaTypeNotSpecifiedException(String message) {
        super(message);
    }

}
