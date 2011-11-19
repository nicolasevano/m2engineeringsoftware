package org.istic.m2softwareengineering.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.Transactional;

import org.datanucleus.exceptions.NucleusUserException;
import org.istic.m2softwareengineering.client.Position;
import org.istic.m2softwareengineering.client.RLatitudeService;
import org.istic.m2softwareengineering.client.ResolvedContact;
import org.istic.m2softwareengineering.client.ResolvedUser;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.gwt.dev.js.rhino.ObjToIntMap.Iterator;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RLatitudeServiceImpl extends RemoteServiceServlet implements RLatitudeService {
	
	/* (non-Javadoc)
	 * @see org.istic.m2softwareengineering.server.RTestService#sayHello()
	 */
	/**
	 * just to check if service if working
	 */
	public String sayHello(){
		return "hello";
	}
	
	/**
	 * publish a new user name with name, firstName and dateNaissance(birth date) of the user to publish
	 * @param name String: name of user to publish
	 * @param firstName String: firstName of user to publish
	 * @param dateNaissance String: birth date of user to publish
	 * @return "" empty String if user is not publish otherwise id string of the new published user
	 */
	@Override
	public String publishUser(String name, String firstName, String dateNaissance) {
		System.err.println("add user: name = "  + name + 
						   ", firstname = "     + firstName + 
						   ", dateNaissance = " + dateNaissance
						   );
		User u = null;
		String result = "";
		//String request = "select u from User as u where u.name=:name and u.firstName=:firstName";
		Query query = new Query("User");
		query.addFilter("name", FilterOperator.EQUAL, name);
		query.addFilter("firstName", FilterOperator.EQUAL, firstName);
		pm = PMF.get().getPersistenceManager();
		ds = DatastoreServiceFactory.getDatastoreService();
	    try{
	    	u = pm.getObjectById( User.class, ds.prepare(query).asSingleEntity().getKey() );
	    } catch (Exception e){
	    	System.err.println( "User not found on base gonna create it!" );
	    }
	    if( u == null ){
	    	try {
	    		u = new User( name, firstName, new SimpleDateFormat( "dd/MM/yyyy" ).parse( dateNaissance ) );
	    		Droit right = new Droit();
	    		right.setConnected(false);
	    		right.setVisible(false);
	    		u.setCurrentRight(right);
	    		pm.makePersistent( u );
	    		pm.makePersistent( right );
	    		u = pm.detachCopy( u );
	    		result = u.getId();
	    	} catch (ParseException e) {
	    		System.err.println( "Exception: " + e.getStackTrace().toString() );
	    		e.printStackTrace();
	    	} catch (Exception e) {
	    		System.err.println( "Exception: " + e.getStackTrace().toString() );
	    		e.printStackTrace();
	    	}finally{
		    	pm.close();
		    }
	    } else {
	    	u = null;
	    	System.err.println( "user already exist in base" );
	    }
		return result;
	}
	
	/**
	 * Update login and password for a user.
	 * @param uid String: id of user to update
	 * @param login String: new user login
	 * @param password String: new password user
	 */
	@Override
	public void publishAuthentication( String uid, String login, String password ){
		
		//TODO fix the fac that one user can have same login and password than an other one;
		System.err.println("user: login = "  + login + 
				   		   ", password = "   + password
				   );
		pm = PMF.get().getPersistenceManager();
		ds = DatastoreServiceFactory.getDatastoreService();
		User currentUser = pm.getObjectById(User.class, uid );
		Query query = new Query("User");
		query.addFilter("login", FilterOperator.EQUAL, login);
		query.addFilter("password", FilterOperator.EQUAL, password);
		PreparedQuery pq = ds.prepare( query );
		//allow to store a login password couple only if unic.
		if( pq != null ){
			currentUser.setLogin( login );
			currentUser.setPassword( password );
		}
		pm.makePersistent( currentUser );
		pm.close();
		
	}
	
	/**
	 * Check if login password couple given in parameter can be set on registered user
	 * @param login String: login to check
	 * @param password String: password to check.
	 * @return true if login/password couple can be set on a user false otherwise
	 */
	@Override
	public boolean checkPasswordLoginValidity( String login, String password ){
		boolean result = false;
		System.err.println("check possible authentication couple: login = "  + login + 
						   ", password = "  + password
						  );
		pm = PMF.get().getPersistenceManager();
		ds = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("User");
		query.addFilter("name", FilterOperator.EQUAL, login);
		query.addFilter("firstName", FilterOperator.EQUAL, password);
		PreparedQuery pq = ds.prepare( query );
		//allow to store a login password couple only if unik.
		if( pq != null ){
			result = true;
		}
		pm.close();
		System.err.println("result: " + result);
		return result;
		
	}
	
	/**
	 * connect a user, set user right connected to true
	 * @param login String: used to authenticate user
	 * @param password String: used to authenticate user
	 * @return id String of the connected user otherwise empty String (bad login/password couple). 
	 */
	@Override
	public String connect( String login, String password ){
		
		User u = null;
		String result = "";
		System.err.println("user try to connect with: login = "  + login + 
				   								", password = "  + password
				   );
		//TODO OK for a little number of user otherwise can take long waitting time
		//String request = "select u.id From User as u where u.login=:login and u.password=:password";
		Query query = new Query( "User" );
		query.addFilter( "login", FilterOperator.EQUAL, login );
		query.addFilter( "password", FilterOperator.EQUAL, password );
		pm = PMF.get().getPersistenceManager();
		ds = DatastoreServiceFactory.getDatastoreService();
		try{
	    	u = pm.getObjectById( User.class, ds.prepare( query ).asSingleEntity().getKey() );
	    } catch ( Exception e ){
	    	System.err.println( "User not found bad credencial!" );
	    	e.printStackTrace();
	    }
	    
	    if(u != null){
	    	u.getCurrentRight().setConnected( true );
	    	pm.makePersistent( u.getCurrentRight() );
	    	result = u.getId();
	    }
	    pm.close();
		return result;
		
	}
	
	/**
	 * disconnect user , set connected right to false
	 * @param id String: primary key of a reccorded user
	 * @return boolean true if user is disconnected false if user primary key is a fake 
	 */
	@Override
	public boolean disconnect( String uid ){
		
		pm = PMF.get().getPersistenceManager();
		User currentUser = pm.getObjectById( User.class, uid );
		boolean result = false;
		System.err.println("user try to disconnect: name = "  + currentUser.getName()  + 
					", firstName = "  + currentUser.getFirstName()
					);
		if( currentUser != null ){
			currentUser.getCurrentRight().setConnected( false );
			pm.makePersistent( currentUser.getCurrentRight() );
			result = true;
		}
		pm.close();
		return result;
		
	}
	
	/**
	 * change visibility right with user primary key and boolean value of the new visibility right.
	 * @param uid String user record primary key
	 * @param visibility boolean visibility right to update
	 * @return true if visibility right is updated false if user primary key is a fake.
	 */
	@Override
	public boolean changeMyVisibility( String uid, boolean visibility ){
		boolean result = false;
		pm = PMF.get().getPersistenceManager();
		User currentUser = pm.getObjectById( User.class, uid );
		if( currentUser != null ){
			currentUser.getCurrentRight().setVisible( visibility );
			pm.makePersistent( currentUser.getCurrentRight() );
			result = true;
		}
		pm.close();
		return result;
	}
	
	/**
	 * get visibility of one user
	 * @param uid
	 * @return boolean true if user is visible of other one false otherwise
	 */
	@Override
	public boolean getVisibility( String uid ){
		boolean result = false;
		pm = PMF.get().getPersistenceManager();
		User currentUser = pm.getObjectById( User.class, uid );
		if( currentUser != null ){
			result = currentUser.getCurrentRight().isVisible();
		}
		pm.close();
		return result;
	}
	
	/**
	 * Update current position of a user with user primary key and a position used to update user record
	 * String uid String: user primary key.
	 * Position position: position used to update user record.
	 */
	@Override
	public void setCurrentPostion( String uid,Position position ){
		
		pm = PMF.get().getPersistenceManager();
		pm.currentTransaction().begin();
		try {
			User currentUser = pm.getObjectById( User.class, uid );
			System.err.println( "user set position: name = "  + currentUser.getName()  + 
				    ", firstName = "  + currentUser.getFirstName()
				   );
			MaPosition toAdd = new MaPosition( position.getX(), position.getY(), position.getZ() );
			System.err.println( "user position  : x = " + position.getX() + 
		   		    ", y = " + position.getY()
		   		   );
			toAdd.setDate( new Date() );
			//currentUser.setCurrentPosition( toAdd );
			if( currentUser.getCurrentPosition() ==  null ) currentUser.setCurrentPosition( new MaPosition() ) ;
			currentUser.getCurrentPosition().setX( position.getX() );
			currentUser.getCurrentPosition().setY( position.getY() );
			currentUser.getCurrentPosition().setZ( position.getZ() );
			Historique currentUserHistorique = new Historique();
			currentUserHistorique.setPosition( toAdd );
			currentUserHistorique.setDate( toAdd.getDate() );
			currentUserHistorique.setUser( currentUser );
		    pm.currentTransaction().commit();
		} finally {
		    if ( pm.currentTransaction().isActive() ) {
		         pm.currentTransaction().rollback();
		    }
		}
		pm.close();
		
	}
	
	/**
	 * Add a user contact to an other user
	 * @param userid primary key of user on which we want add a contact 
	 * @param uidContact primary key user that become a contact
	 */
	@Override
	public void addContact( String uidUser, String uidContact ){
		pm = PMF.get().getPersistenceManager();
		ds = DatastoreServiceFactory.getDatastoreService();
		User currentUser = pm.getObjectById(User.class, uidUser );
		Contact toAdd = null;
		System.err.println("user add contact: name = "  + currentUser.getName()  + 
				   ", firstName = "  + currentUser.getFirstName()
				   );
		User contact = pm.getObjectById(User.class, uidContact );
		if( currentUser.getContacts().contains( uidContact ) ) System.err.println( "user contact already existing!" );
		else{

			System.err.println( "contact: name = "  + contact.getName()  + 
					", firstName = "  + contact.getFirstName()
			);
			toAdd = new Contact();
			toAdd.setUser( currentUser );
			toAdd.setContact( contact.getId() );
			currentUser.addContact( toAdd );
			pm.makePersistent( toAdd );
			pm.makePersistent( currentUser );

		}
		pm.close();
	}
	
	/**
	 * Return contact list of one user by user primary key given in parameter.
	 * @param uid primary key of user on wich we want get contact list.
	 * @return list<ResolvedContact> contact list requested.
	 */
	@Override
	public List<ResolvedContact> getContact( String uid ){
		ResolvedUser owner = null;
		ResolvedUser userContact = null;
		List< ResolvedContact > results = new ArrayList< ResolvedContact >();
		pm = PMF.get().getPersistenceManager();
		ds = DatastoreServiceFactory.getDatastoreService();
		User currentUser = pm.getObjectById( User.class, uid );
		//javax.jdo.Query queryContact = 
		//	pm.newQuery( "javax.jdo.query.SQL","SELECT * FROM Contact Contact.owner.id = ?" );
		Query queryContact = new Query( "Contact" );
		List<User> userContacts = new ArrayList<User>();
		//javax.jdo.Query queryUser = 
		//	pm.newQuery( "javax.jdo.query.SQL","SELECT * FROM User Where id = ?" );
		//List<Contact> contacts = ( List<Contact> ) queryContact.execute( uid );
		PreparedQuery pq = ds.prepare( queryContact );
		for( Entity contact: pq.asIterable() ){
			pm.close();
			pm = PMF.get().getPersistenceManager();
			Contact tmp = pm.getObjectById( Contact.class,contact.getKey());
			if( uid.equals( tmp.getUser().getId() )  ){
				System.err.println( "find a contact" );
				userContacts.add( pm.getObjectById(User.class,(String) contact.getProperty("contact") ) );
			}
		}
		for(User contact: userContacts){
			owner = new ResolvedUser( currentUser.getName(),
					currentUser.getFirstName(),
					currentUser.getDateNaissanse() );
			owner.setId( currentUser.getId() );
			userContact = new ResolvedUser( contact.getName(),
					contact.getFirstName(),
					contact.getDateNaissanse() );
			userContact.setId( contact.getId() );
			results.add( new ResolvedContact( owner, userContact ) );
		}
		if( pm != null ) pm.close();
		return results;
	}
	
	/**
	 * return a user by the name and first name given in parameter
	 * @param name String: name of the wanted user
	 * @param firstName String: firstName of the wanted user
	 * @return resolved user if exit otherwise null
	 */
	@Override
	public ResolvedUser getUser(String name, String firstName){
		User u = null;
		ResolvedUser result = null;
		Query query = new Query("User");
		query.addFilter("name", FilterOperator.EQUAL, name);
		query.addFilter("firstName", FilterOperator.EQUAL, firstName);
		pm = PMF.get().getPersistenceManager();
		ds = DatastoreServiceFactory.getDatastoreService();
	    try {
	    	u = pm.getObjectById( User.class, ds.prepare(query).asSingleEntity().getKey() );
	    	u = pm.detachCopy(u);
	    } catch (Exception e){
	    	System.err.println( "User not found on base gonna create it!" );
	    }
	    result = new ResolvedUser( u.getName(), u.getFirstName(),u.getDateNaissanse() );
	    result.setId( u.getId() );
	    if(u.getCurrentPosition() != null && u.getCurrentRight().isVisible()){
	    	result.setCurrentPosition( new Position( u.getCurrentPosition().getX(),
	    									     	 u.getCurrentPosition().getY(),
	    									     	 u.getCurrentPosition().getZ() ) );
	    }
	    
	    pm.close();
	    return result;
	}
	
	/**
	 * return a user by the user primary key given in parameter
	 * @param uid String: user primary key
	 * @return resolved user if exit otherwise null
	 */
	@Override
	public ResolvedUser getUser(String uid){
		pm = PMF.get().getPersistenceManager();
		ds = DatastoreServiceFactory.getDatastoreService();
		ResolvedUser result = null;
		User currentUser = pm.getObjectById( User.class, uid );
		//User currentUserCopy = pm.detachCopy(currentUser);
		result = new ResolvedUser( currentUser.getName(), currentUser.getFirstName(),currentUser.getDateNaissanse() );
	    result.setId( currentUser.getId() );
	    if(currentUser.getCurrentPosition() != null){
	    	result.setCurrentPosition( new Position( currentUser.getCurrentPosition().getX(),
	    											 currentUser.getCurrentPosition().getY(),
	    											 currentUser.getCurrentPosition().getZ() ) );
	    }
	    pm.close();
	    return result;
	}
	
	/**
	 * return the current position of an user by the user primary key given in parameter
	 * @param uidUser String user primary key on which we want get the position
	 * @return position current position of the user
	 */
	@Override
	public Position getPosition( String uidUser ){
		
		pm = PMF.get().getPersistenceManager();
		User currentUser = pm.getObjectById( User.class, uidUser );
		MaPosition currentMaPosition = null;
		Position result = null;
		System.err.println("user get position: name = "  + currentUser.getName()  + 
				   ", firstName = "  + currentUser.getFirstName()
				   );
		currentMaPosition = pm.detachCopy( currentUser.getCurrentPosition() );
		if(currentMaPosition != null){
			System.err.println( "user position  : x = " + currentMaPosition.getX() + 
					", y = " + currentMaPosition.getY()
			);
			result = new Position( currentMaPosition.getX(), 
								   currentMaPosition.getY(), 
								   currentMaPosition.getZ() );
		}
		pm.close();
		return result;
		
	}
	
	/**
	 * serial UID 
	 */
	private static final long serialVersionUID = -7725740488294122563L;
	
	/**
	 * pm presistence manager need to access database
	 */
	private PersistenceManager pm;
	
	/**
	 * datastore service used to get query result 
	 */
	private DatastoreService ds;
}
