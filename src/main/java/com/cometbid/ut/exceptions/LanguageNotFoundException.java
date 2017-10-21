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
public class LanguageNotFoundException extends Exception {

    public LanguageNotFoundException() {
        super("Language not currently supported or cannot be found");
    }

    public LanguageNotFoundException(String message) {
        super(message);
    }
    
    public LanguageNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }

}
