package org.istic.m2softwareengineering.client;

import java.io.Serializable;
import java.util.Date;


public class ResolvedUser implements Serializable {

	public ResolvedUser(){
		
	}
	
	public ResolvedUser( String name, String firstName,Date dateNaissance ){
		
		this.name = name;
		this.firstName = firstName;
		this.dateNaissanse = dateNaissance;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String getFirstName() {
		
		return firstName;
		
	}
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	}
	
	public String getId() {
		
		return id;
		
	}
	
	public void setId( String id) {
		
		this.id = id;
		
	}
	
	public Position getCurrentPosition() {
		
		return currentPosition;
		
	}

	public void setCurrentPosition( Position currentPosition ) {
		
		this.currentPosition = currentPosition;
		
	}

	public Date getDateNaissanse() {
		return dateNaissanse;
	}

	public void setDateNaissanse(Date dateNaissanse) {
		this.dateNaissanse = dateNaissanse;
	}
	
	String id;

	String firstName;
    
	String name;
	
	Date dateNaissanse;
	
	Position currentPosition;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4569532694485396782L;
}
