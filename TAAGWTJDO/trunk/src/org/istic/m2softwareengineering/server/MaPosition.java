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
public class MaPosition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5910499101046618310L;

	public MaPosition() {
		
	}
	
	public MaPosition(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#getId()
	 */
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#getId()
	 */
	public Key getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#setId(com.google.appengine.api.datastore.Key)
	 */
	public void setId(Key id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#getX()
	 */
	public double getX() {
		return x;
	}	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#setX(int)
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#getY()
	 */
	public double getY() {
		return y;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#setY(int)
	 */
	public void setY(double y) {
		this.y = y;
	}
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#getZ()
	 */
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#getZ()
	 */
	public double getZ() {
		return z;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#setZ(int)
	 */
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#setZ(int)
	 */
	public void setZ(double z) {
		this.z = z;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IMaPosition#getDate()
	 */
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Key id;
	
    @Persistent
	double x;
	
    @Persistent
	double y;
	
    @Persistent
	double z;
	
    @Persistent
	Date date;
	
}
