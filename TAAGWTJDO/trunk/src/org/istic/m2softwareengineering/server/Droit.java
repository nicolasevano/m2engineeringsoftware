package org.istic.m2softwareengineering.server;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.IdentityType;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class Droit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6507283273567115733L;

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IDroit#isVisible()
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IDroit#setVisible(boolean)
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IDroit#isConnected()
	 */
	public boolean isConnected() {
		return isConnected;
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IDroit#setConnected(boolean)
	 */
	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}
	
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Key id;
	
    @Persistent
	boolean isVisible;
	
    @Persistent
	boolean isConnected;
	
}
