package org.istic.m2softwareengineering.server;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class Contact implements Serializable{
	
	public Contact(User user, User contact){
		super();
		this.owner = user;
		this.contact = contact.getId();
		
	}
	
	public Contact(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IContact#getId()
	 */
	public Key getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IContact#getUser()
	 */
	public User getUser() {
		return owner;
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IContact#setUser(org.istic.m2softwareengineering.client.IUser)
	 */
	public void setUser( User user ) {
		this.owner = user;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IContact#getContact()
	 */
	public String getContact(){
		return contact;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IContact#setContact(org.istic.m2softwareengineering.client.IUser)
	 */
	public void setContact( String contact){
		this.contact = contact;
	}
	
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Key id;
	
    @Persistent
	User owner;
	
    @Persistent
	String contact;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 621202177164010504L;

}
