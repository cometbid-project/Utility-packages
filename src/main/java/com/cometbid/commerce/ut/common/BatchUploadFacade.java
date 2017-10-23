/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.commerce.ut.common;

import com.cometbid.commerce.ut.qualifiers.JavaUtilLogger;
import com.cometbid.ut.entities.StatisticsData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Gbenga
 * @param <T>
 */
public abstract class BatchUploadFacade<T> extends AbstractFacade<T> {

    @Inject
    @JavaUtilLogger
    private Logger logger;

    public BatchUploadFacade(Class<T> entityClass) {
        super(entityClass);
    }

    private <T> T persist(T t) {
        getEntityManager().persist(t);
       // getEntityManager().flush();
        
        return t;
    }

    private <T> T merge(T t) {
        getEntityManager().merge(t);
       // getEntityManager().flush();
        
        return t;
    }

    // @Value("${hibernate.jdbc.batch_size}")
    private final int BATCH_SIZE = 200;

    public Collection<T> bulkSave(Collection<T> entities) {
        final List<T> savedEntities = new ArrayList<T>(entities.size());
        int i = 0;
        for (T t : entities) {
            savedEntities.add(persist(t));
            i++;
            if (i % BATCH_SIZE == 0) {
                // Flush a batch of inserts and release memory.
                //  getEntityManager().flush();
            }
        }

        return savedEntities;
    }

    public Collection<T> bulkMerge(Collection<T> entities) {
        final List<T> savedEntities = new ArrayList<T>(entities.size());
        int i = 0;
        
        for (T t : entities) {
            i++;
            Object[] param = {i, t};
            logger.log(Level.INFO, "Count {0} --------------- Before Insert {1}", param);
            T t2 = merge(t);
            Object[] param2 = {i, t2};
            logger.log(Level.INFO, "Count {0} ---------------  After Insert {1}", param2);
            savedEntities.add(t2);
            if (i % BATCH_SIZE == 0) {
                // Flush a batch of inserts and release memory.
                // getEntityManager().flush();
            }
        }

        return savedEntities;
    }

    public void bulkInsertOrMerge(Map<String, T> stats) {

        Set<String> keys = stats.keySet();
        Iterator<String> iter = keys.iterator();

        int i = 0;
        while (iter.hasNext()) {
            String aKey = iter.next();
            if (aKey != null) {
                try {
                    StatisticsData myData = getEntityManager().getReference(StatisticsData.class, aKey);

                    merge(stats.get(aKey));
                } catch (EntityNotFoundException ex) {
                    logger.log(Level.INFO, "Entity not found by Key {0}", aKey);

                    persist(stats.get(aKey));
                }
            }
            i++;
            if (i % BATCH_SIZE == 0) {
                // Flush a batch of inserts and release memory.
                getEntityManager().flush();
            }
        }
    }
}
