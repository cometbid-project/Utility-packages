/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.commerce.ut.cdi;

import com.cometbid.commerce.ut.qualifiers.JavaUtilLogger;
import com.cometbid.ut.exceptions.InvalidParameterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Gbenga
 */
public class ValidationInterceptor {

    @Inject
    @JavaUtilLogger
    private Logger logger;

    @AroundInvoke
    public Object validateParameters(InvocationContext context) throws
            InvalidParameterException, Exception {

        logger.log(Level.INFO, "Method Interceptor: Invoking method: {0}",
                context.getMethod().getName());

        Object parameters[] = context.getParameters();
        for (Object object : parameters) {

            if (object == null) {
                throw new InvalidParameterException(new StringBuilder(100)
                        .append("Invalid parameter supplied as: ")
                        .append(object).toString());
            }
        }
        Object result = context.proceed();

        logger.log(Level.INFO, "Method Interceptor: Returned from method: {0}",
                context.getMethod().getName());
        return result;
    }
}
