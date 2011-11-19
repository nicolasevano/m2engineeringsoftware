package org.istic.m2softwareengineering.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * presistance manager factory singleton
 * ref: http://code.google.com/intl/fr/appengine/docs/java/datastore/jdo/overview.html
 * @author nicolas
 *
 */
public class PMF {
	private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PMF() {}

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
}
