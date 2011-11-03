package lattitude;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name="Historique" )
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
	
	public long getId() {
		return id;
	}

	public User getUser() {
		return u;
	}

	public void setUser( User user ) {
		this.u = user;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate( Date date ) {
		this.date = date;
	}
	
	public MaPosition getPosition() {
		return position;
	}

	public void setPosition(MaPosition position) {
		this.position = position;
	}
	
	@GeneratedValue
	@Id
	long id;
	
	@ManyToOne
	User u;
	
	Date date;
	
	@OneToOne
	MaPosition position;

}
