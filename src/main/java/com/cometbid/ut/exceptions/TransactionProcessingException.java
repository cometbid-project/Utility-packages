package com.cometbid.ut.exceptions;

import javax.ejb.ApplicationException;
import javax.ejb.EJBException;

@ApplicationException(rollback = true)
public class TransactionProcessingException extends EJBException {

    private static final long serialVersionUID = 1L;

    public TransactionProcessingException() {
        super("Transaction processing failed");
    }

    public TransactionProcessingException(String message) {
        super(message);
    }

}
