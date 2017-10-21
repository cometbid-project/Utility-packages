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
public class RedirectUserAccountException extends ApplicationDefinedExceptions {

    public RedirectUserAccountException() {
        super("User redirected to change password, password reset detected.");
    }

    public RedirectUserAccountException(String message) {
        super(message);
    }

    public RedirectUserAccountException(String message, Throwable ex) {
        super(message, ex);
    }
}
