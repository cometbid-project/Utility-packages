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
public class AuthorizationDeniedException extends ApplicationDefinedExceptions {
    
    public AuthorizationDeniedException() {
        super("Authorization Denied: your account does not have the pivilege");
    }

    public AuthorizationDeniedException(String message) {
        super(message);
    }

    public AuthorizationDeniedException(String message, Throwable ex) {
        super(message, ex);
    }
}
