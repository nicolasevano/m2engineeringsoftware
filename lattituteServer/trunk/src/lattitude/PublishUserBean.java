package lattitude;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lattitude.MaPosition;
import lattitude.User;


@Stateless(mappedName="publishUserBean")
public class PublishUserBean implements PublishUserService {

	@PersistenceContext EntityManager em;
	
	@Override
	public User publishUser(String name, String firstName, String dateNaissance) {
		System.err.println("add user: name = "  + name + 
						   ", firstname = "     + firstName + 
						   ", dateNaissance = " + dateNaissance
						   );
		User u = null;
		String request = "select u from User as u where u.name=:name and u.firstName=:firstName";
		Query query = em.createQuery( request ); 
	    query.setParameter( "name", name );
	    query.setParameter( "firstName", firstName );
	    try{
	    	u = (User)query.getSingleResult();
	    } catch (Exception e){
	    	System.err.println( "User not found on base gonna create it!" );
	    }
	    if( u == null ){
	    	try {
	    		u = new User( name, 
	    				firstName, 
	    				new SimpleDateFormat( "dd/MM/yyyy" ).parse( dateNaissance ) );
	    		Droit right = new Droit();
	    		right.setConnected(false);
	    		right.setVisible(false);
	    		u.setCurrentRight(right);
	    		em.persist( u );
	    		em.persist( right );
	    	} catch (ParseException e) {
	    		System.err.println( "Exception: " + e.getStackTrace().toString() );
	    	} catch (Exception e) {
	    		System.err.println( "Exception: " + e.getStackTrace().toString() );
	    	}
	    }else{
	    	u = null;
	    	System.err.println( "user already exist in base" );
	    }
		return u;
	}
	
	public void publishAuthentication( long uid, String login, String password ){
		
		//TODO fix the fac that one user can have same login and password than an other one;
		System.err.println("user: login = "  + login + 
				   ", password = "           + password
				   );
		User currentUser = em.find( User.class, uid );
		currentUser.setLogin( login );
		currentUser.setPassword( password );
		em.persist( currentUser );
		
	}
	
	public Collection<Contact> getContact( long uid ){
		User currentUser = em.find( User.class, uid );
		System.err.println("user getcontact: name = " + currentUser.getName() + 
				   		   ", firstName = " + currentUser.getFirstName()
				   		   );
		String request = "select c from Contact as c where c.z.id=:uid";
		Query query = em.createQuery( request ); 
	    query.setParameter( "uid", currentUser.id );
		return (List<Contact>) query.getResultList();
	}
	
	public void userSetVisibleRight( long uid, boolean visible ){
		
		User currentUser = em.find( User.class, uid );
		System.err.println("user visible right update: name = " + currentUser.getName() + 
				   							   ", firstName = " + currentUser.getFirstName()
				   );
		currentUser.getCurrentRight().setVisible(visible);
		em.persist( currentUser.getCurrentRight() );
	}
	
	public User connect( String login, String password ){
		
		System.err.println("user try to connect with: login = "  + login + 
				   								", password = "  + password
				   );
		//TODO OK for a little number of user otherwise can take long waitting time
		String request = "select u.id From User as u where u.login=:login and u.password=:password";
		Query query = em.createQuery( request ); 
	    query.setParameter( "login", login );
	    query.setParameter( "password", password );
		long uid = (Long) query.getSingleResult();
		return em.find( User.class, uid );
		
	}
	
	public boolean disconnect( long uid ){
		
		User currentUser = em.find( User.class, uid );
		System.err.println("user try to disconnect: name = "  + currentUser.getName()  + 
					", firstName = "  + currentUser.getFirstName()
					);
		currentUser.getCurrentRight().setConnected( false );
		em.persist( currentUser.getCurrentRight() );
		em.persist( currentUser );
		return true;
		
	}
	
	
	
	public void setCurrentPostion( long uid,MaPosition position ){
		
		User currentUser = em.find( User.class, uid );
		System.err.println("user set position: name = "  + currentUser.getName()  + 
						   ", firstName = "  + currentUser.getFirstName()
						   );
		currentUser.setCurrentPosition( position );
		Historique currentUserHistorique = new Historique();
		currentUserHistorique.setPosition( position );
		currentUserHistorique.setDate( position.getDate() );
		currentUserHistorique.setUser( currentUser );
		currentUser.addHistorique( currentUserHistorique );
		em.persist( currentUser );
		em.persist( currentUserHistorique );
		
	}

	public List<User> getUser( String name, String firstName ){
		//TODO
		String request = "select u from User as u where u.name=:name and u.firstName=:firstName";
		Query query = em.createQuery( request ); 
	    query.setParameter( "name", name );
	    query.setParameter( "firstName", firstName );
	    return query.getResultList();
	}
	
	public void addContact( long uidUser, long uidContact ){
		User currentUser = em.find( User.class, uidUser );
		Contact toAdd = null;
		List<Contact> currentConntacts = null;
		System.err.println("user add contact: name = "  + currentUser.getName()  + 
				   ", firstName = "  + currentUser.getFirstName()
				   );
		User contact = em.find( User.class, uidContact );
		String request = "select c from Contact as c where c.z.id=:uid and c.contact.id=:uidContact";
		Query query = em.createQuery( request ); 
		query.setParameter( "uid", currentUser.id );
		query.setParameter( "uidContact", uidContact );
		try{
			currentConntacts = query.getResultList();
		} catch( Exception e ) {
			//nothing to do
		}//check if contact already exist
		if(currentConntacts == null){
			toAdd = new Contact(currentUser,contact);
			em.persist(toAdd);
			currentUser.addContact( toAdd );
			em.persist( currentUser );
		} else {//this contact already exist no need to add it
			System.err.println( "user contact already existing!" );
		}
		
	}
	
	public MaPosition getPosition( long uidUser ){
		User currentUser = em.find( User.class, uidUser );
		System.err.println("user get position: name = "  + currentUser.getName()  + 
				   ", firstName = "  + currentUser.getFirstName()
				   );
		return currentUser.getCurrentPosition();
		
	}
	
}
