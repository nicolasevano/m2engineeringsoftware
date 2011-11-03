package lattitude;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name="Contact" )
public class Contact implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 621202177164010504L;

	public Contact(User user, User contact){
		super();
		this.z = user;
		this.contact = contact;
		
	}
	
	public Contact(){
		
	}
	
	public long getId() {
		return id;
	}

	public User getUser() {
		return z;
	}

	public void setUser( User user ) {
		this.z = user;
	}
	
	public User getContact(){
		return contact;
	}
	
	public void setContact( User contact){
		this.contact = contact;
	}
	
	@GeneratedValue
	@Id
	long id;
	
	@ManyToOne
	User z;
	
	@OneToOne
	User contact;
	
}
