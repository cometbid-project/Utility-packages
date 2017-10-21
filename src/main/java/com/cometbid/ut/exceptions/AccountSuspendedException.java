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
public class AccountSuspendedException extends ApplicationDefinedExceptions {

    public AccountSuspendedException() {
        super("This user account has been suspended");
    }

    public AccountSuspendedException(String message) {
        super(message);
    }

    public AccountSuspendedException(String message, Throwable ex) {
        super(message, ex);
    }

}
