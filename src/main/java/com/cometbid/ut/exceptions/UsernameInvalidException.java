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
public class UsernameInvalidException extends ApplicationDefinedExceptions {

    public UsernameInvalidException() {
        super("Invalid username supplied");
    }

    public UsernameInvalidException(String message) {
        super(message);
    }

    public UsernameInvalidException(String message, Throwable ex) {
        super(message, ex);
    }

}
