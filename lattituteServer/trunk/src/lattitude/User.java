package lattitude;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name="User" )
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8448175690385718014L;

	public User(){
		
	}
	
	public User( String name, String firstName,Date dateNaissance ){
		super();
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
	
	public long getId() {
		
		return id;
		
	}
	
	public MaPosition getCurrentPosition() {
		
		return currentPosition;
		
	}

	public void setCurrentPosition( MaPosition currentPosition ) {
		
		this.currentPosition = currentPosition;
		
	}

	public void addContact(Contact contact){
		contacts.add( contact );
	}
	
	public Collection<Contact> getContacts(){
		
		return contacts;
		
	}
	
	public void addHistorique( Historique toAdd){
		
		positions.add( toAdd );
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Droit getCurrentRight() {
		return currentRight;
	}

	public void setCurrentRight(Droit currentRight) {
		this.currentRight = currentRight;
	}
	
	@GeneratedValue
	@Id
	long id;

	String firstName;
	
	String name;
	
	String login;
	
	String password;
	
	@Temporal( TemporalType.TIMESTAMP )
	Date dateNaissanse;
	
	//@OneToMany
	//Collection<Droit> droits;
	
	@OneToOne
	Droit currentRight;
	
	@OneToMany( mappedBy="u",fetch=FetchType.LAZY ) 
	Collection<Historique> positions;
	
	@OneToOne
	MaPosition currentPosition;
	
	@OneToMany( mappedBy="z",fetch=FetchType.LAZY )
	Collection<Contact> contacts;
	
}
