/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author Gbenga
 */
@ApplicationException(rollback = true)
public class CurrencyNotFoundException extends ApplicationDefinedExceptions {

    public CurrencyNotFoundException() {
        super("Service name is missing in request");
    }

    public CurrencyNotFoundException(String message) {
        super(message);
    }

    public CurrencyNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }

}
