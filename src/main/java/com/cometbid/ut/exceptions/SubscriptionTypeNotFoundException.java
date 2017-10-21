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
public class SubscriptionTypeNotFoundException extends ApplicationDefinedExceptions {

    public SubscriptionTypeNotFoundException() {
        super("Subscription type not found");
    }

    public SubscriptionTypeNotFoundException(String message) {
        super(message);
    }

    public SubscriptionTypeNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }

}
