package com.cometbid.ut.exceptions;

import javax.ejb.ApplicationException;
import javax.ejb.EJBException;

@ApplicationException(rollback = true)
public class TransactionAlreadyBilledException extends EJBException {

    private static final long serialVersionUID = 1L;

    public TransactionAlreadyBilledException() {
        super("Transaction has already been billed");
    }

    public TransactionAlreadyBilledException(String message) {
        super(message);
    }

}
