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
public class TimeInMethodInterceptor {

    @Inject
    @JavaUtilLogger
    private Logger logger;

    ApplicationStatistics applicationStatistics;

    @AroundTimeout
    @AroundInvoke
    public Object recordTime(InvocationContext context) throws Exception {
        logger.log(Level.INFO, "TimeInMethodInterceptor - Starting");

        String methodName = context.getMethod().getName();
        applicationStatistics = ApplicationStatistics.getInstance();

        long endTime = System.currentTimeMillis();
        long startTime = System.currentTimeMillis();
        try {
            Object result = context.proceed();
            endTime = System.currentTimeMillis();

            applicationStatistics.increaseTotalTime(methodName, endTime - startTime);
            logger.log(Level.INFO, "TimeInMethodInterceptor - Terminating");
            return result;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "!!!During invocation of: {0} exception occured: {1}", new Object[]{methodName, e});
            throw e;
        } finally {
            logger.log(Level.INFO, "{0} performed in: {1}", new Object[]{methodName, (endTime - startTime)});
        }
    }
}
