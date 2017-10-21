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
public class AuthCredentialInvalidException extends ApplicationDefinedExceptions {

    public AuthCredentialInvalidException() {
        super("Invalid authentication credentials supplied");
    }

    public AuthCredentialInvalidException(String message) {
        super(message);
    }

    public AuthCredentialInvalidException(String message, Throwable ex) {
        super(message, ex);
    }
}
