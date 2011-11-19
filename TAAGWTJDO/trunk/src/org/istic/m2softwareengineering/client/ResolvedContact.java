package org.istic.m2softwareengineering.client;

import java.io.Serializable;


public class ResolvedContact implements Serializable{
	
	public ResolvedContact(){
		
	}
	
	public ResolvedContact(ResolvedUser ownerContact,ResolvedUser contact){
		this.ownerContact = ownerContact;
		this.contact = contact;
	}

	public ResolvedUser getOwnerContact() {
		return ownerContact;
	}

	public void setOwnerContact(ResolvedUser ownerContact) {
		this.ownerContact = ownerContact;
	}

	public ResolvedUser getContact() {
		return contact;
	}

	public void setContact(ResolvedUser contact) {
		this.contact = contact;
	}
	
	private ResolvedUser ownerContact;
	
	private ResolvedUser contact;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7889160099319233942L;
}
