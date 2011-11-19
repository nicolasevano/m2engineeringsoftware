package org.istic.m2softwareengineering.client;

import java.io.Serializable;
import java.util.Date;


public class Position implements Serializable {

	public Position(){
		
	}
	
	public Position(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Date getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	public double getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	public double getZ() {
		// TODO Auto-generated method stub
		return this.z;
	}

	public void setX(double x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	public void setY(double y) {
		// TODO Auto-generated method stub
		this.y = y;
	}

	public void setZ(double z) {
		// TODO Auto-generated method stub
		this.z = z;
	}
	
	private double x;
	
	private double y;
	
	private double z;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1861413403941838967L;
	
}
