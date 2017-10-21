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
public class RoleAlreadyExistException extends ApplicationDefinedExceptions {

    public RoleAlreadyExistException() {
        super("Role already exist");
    }

    public RoleAlreadyExistException(String message) {
        super(message);
    }

    public RoleAlreadyExistException(String message, Throwable ex) {
        super(message, ex);
    }
}
