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
public class PasswordResetFailedException extends ApplicationDefinedExceptions {

    public PasswordResetFailedException() {
        super("The passwords do not match");
    }

    public PasswordResetFailedException(String message) {
        super(message);
    }

    public PasswordResetFailedException(String message, Throwable ex) {
        super(message, ex);
    }
}
