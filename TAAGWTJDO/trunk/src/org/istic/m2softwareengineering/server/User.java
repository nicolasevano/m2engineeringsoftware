package org.istic.m2softwareengineering.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Extension;



@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class User implements Serializable{
	
	public User(){
		
	}
	
	public User( String name, String firstName,Date dateNaissance ){
		super();
		this.name = name;
		this.firstName = firstName;
		this.dateNaissanse = dateNaissance;
		
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#getName()
	 */
	public String getName() {
		
		return name;
		
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#setName(java.lang.String)
	 */
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#getFirstName()
	 */
	public String getFirstName() {
		
		return firstName;
		
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#setFirstName(java.lang.String)
	 */
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#getId()
	 */
	public String getId() {
		
		return id;
		
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#getCurrentPosition()
	 */
	public MaPosition getCurrentPosition() {
		
		return currentPosition;
		
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#setCurrentPosition(org.istic.m2softwareengineering.server.MaPosition)
	 */
	public void setCurrentPosition( MaPosition currentPosition ) {
		
		this.currentPosition = ( MaPosition ) currentPosition;
		
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#addContact(org.istic.m2softwareengineering.server.Contact)
	 */
	public void addContact( Contact contact ){
		contacts.add( contact );
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#getContacts()
	 */
	public List<Contact> getContacts(){
		
		return contacts;
		
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#addHistorique(org.istic.m2softwareengineering.server.Historique)
	 */
	public void addHistorique( Historique toAdd){
		
		positions.add( toAdd );
		
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#getLogin()
	 */
	public String getLogin() {
		return login;
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#setLogin(java.lang.String)
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#getPassword()
	 */
	public String getPassword() {
		return password;
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#setPassword(java.lang.String)
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#getCurrentRight()
	 */
	public Droit getCurrentRight() {
		return currentRight;
	}

	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.IUser#setCurrentRight(org.istic.m2softwareengineering.server.Droit)
	 */
	public void setCurrentRight(Droit currentRight) {
		this.currentRight = currentRight;
	}
	
	public Date getDateNaissanse() {
		return dateNaissanse;
	}

	public void setDateNaissanse(Date dateNaissanse) {
		this.dateNaissanse = dateNaissanse;
	}
	
    @PrimaryKey
    @Persistent( valueStrategy=IdGeneratorStrategy.IDENTITY )
    @Extension( vendorName="datanucleus", key="gae.encoded-pk", value="true" )
	String id;

    @Persistent
	String firstName;
    
    @Persistent
	String name;
	
    @Persistent
	String login;
	
    @Persistent
	String password;
	
    @Persistent
	Date dateNaissanse;
	
	//@OneToMany
	//Collection<Droit> droits;
	
	@Persistent(defaultFetchGroup = "true")
	Droit currentRight;
	
	//@Persistent( mappedBy="u",fetch=FetchType.LAZY ) 
	//Collection<Historique> positions;
	@Persistent(mappedBy="u")
	@Element(dependent = "true")
	List<Historique> positions = new ArrayList<Historique>();
	
	@Persistent(defaultFetchGroup = "true")
	MaPosition currentPosition;
	
	//@Persistent( mappedBy="z",defaultFetchGroup="false" )
	//Collection<Contact> contacts;
	@Persistent(mappedBy = "owner") 
	@Element(dependent = "true")
	List<Contact> contacts = new ArrayList<Contact>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8448175690385718014L;
	
}
