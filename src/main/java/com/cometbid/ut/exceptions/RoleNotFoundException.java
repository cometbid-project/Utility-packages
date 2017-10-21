/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.exceptions;

/**
 *
 * @author Gbenga
 */
public class RoleNotFoundException extends ApplicationDefinedExceptions {

    public RoleNotFoundException() {
        super("Role not found");
    }

    public RoleNotFoundException(String message) {
        super(message);
    }

    public RoleNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }
}
