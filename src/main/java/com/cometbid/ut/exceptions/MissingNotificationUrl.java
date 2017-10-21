package com.cometbid.ut.exceptions;

import javax.ejb.ApplicationException;
import javax.ejb.EJBException;

@ApplicationException(rollback = true)
public class MissingNotificationUrl extends EJBException {

    public MissingNotificationUrl() {
        super("Notification Url missing in the request");
    }

    public MissingNotificationUrl(String message) {
        super(message);
    }

}
