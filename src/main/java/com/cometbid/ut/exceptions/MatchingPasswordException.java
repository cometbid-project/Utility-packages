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
public class MatchingPasswordException extends ApplicationDefinedExceptions {

    public MatchingPasswordException() {
        super("The passwords match: expected, must not match");
    }

    public MatchingPasswordException(String message) {
        super(message);
    }

    public MatchingPasswordException(String message, Throwable ex) {
        super(message, ex);
    }
}
