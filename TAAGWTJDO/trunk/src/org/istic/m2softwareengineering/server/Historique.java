package org.istic.m2softwareengineering.server;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.IdentityType;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class Historique implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3211120741835458961L;

	public Historique(User user, MaPosition position){
		super();
		this.u = user;
		this.position = position;
		
	}
	
	public Historique(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IHistorique#getId()
	 */
	public Key getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IHistorique#getUser()
	 */
	public User getUser() {
		return u;
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IHistorique#setUser(org.istic.m2softwareengineering.client.IUser)
	 */
	public void setUser( User user ) {
		this.u = user;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IHistorique#getDate()
	 */
	public Date getDate() {
		return date;
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IHistorique#setDate(java.util.Date)
	 */
	public void setDate( Date date ) {
		this.date = date;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IHistorique#getPosition()
	 */
	public MaPosition getPosition() {
		return position;
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IHistorique#setPosition(org.istic.m2softwareengineering.client.IMaPosition)
	 */
	public void setPosition(MaPosition position) {
		this.position = position;
	}
	
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Key id;
	
	@Persistent
	User u;
	
	@Persistent
	Date date;
	
	//@Persistent(defaultFetchGroup = "true")
	//@Element(dependent = "true")
	@Persistent
	MaPosition position;

}
