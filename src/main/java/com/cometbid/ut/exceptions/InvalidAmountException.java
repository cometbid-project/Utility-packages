/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class InvalidAmountException extends ApplicationDefinedExceptions {

    public InvalidAmountException() {
        super("Invalid amount supplied");
    }

    public InvalidAmountException(String message) {
        super(message);
    }

}
