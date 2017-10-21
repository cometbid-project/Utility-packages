/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class TransactionIdInvalidException extends ApplicationDefinedExceptions {

    public TransactionIdInvalidException() {
        super("Invalid Transaction id detected");
    }

    public TransactionIdInvalidException(String message) {
        super(message);
    }

}
