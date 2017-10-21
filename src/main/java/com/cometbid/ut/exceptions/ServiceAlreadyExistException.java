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
public class ServiceAlreadyExistException extends ApplicationDefinedExceptions {

    public ServiceAlreadyExistException() {
        super("Vendor service already exist");
    }

    public ServiceAlreadyExistException(String message) {
        super(message);
    }

    public ServiceAlreadyExistException(String message, Throwable ex) {
        super(message, ex);
    }

}
