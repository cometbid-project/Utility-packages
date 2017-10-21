/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.commerce.ut.cdi;

import com.cometbid.commerce.ut.qualifiers.JavaUtilLogger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Gbenga
 */
public class HitCounterInterceptor {

    @Inject
    @JavaUtilLogger
    private Logger logger;

    public HitCounterInterceptor() {

    }

    @AroundTimeout
    @AroundInvoke
    public Object incrementCounter(InvocationContext context) throws Exception {

        logger.log(Level.INFO, "HitCounterInterceptor - Starting");

        String methodName = context.getMethod().getName();
        ApplicationStatistics applicationStatistics = ApplicationStatistics.getInstance();

        applicationStatistics.incrementInvocationCount(methodName);

        try {
            Object result = context.proceed();

            logger.log(Level.INFO, "HitCounterInterceptor - Terminating");
            return result;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "!!!During invocation of: {0} exception occured: {1}", new Object[]{methodName, e});
            throw e;
        } finally {
            logger.log(Level.INFO, "Method-'{0}' has been invoked: {1} times within the last session measured",
                    new Object[]{methodName, applicationStatistics.getInvocationCount(methodName)});
        }
    }
}
