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
@ApplicationException(rollback=true)
public class VendorNotFoundException extends ApplicationDefinedExceptions {

    public VendorNotFoundException() {
    	super("Vendor with specified username not found.");
    }
    
    public VendorNotFoundException(String message){
    	super(message);
    }
    
     public VendorNotFoundException(String message, Throwable ex){
    	super(message, ex);
    }
}
