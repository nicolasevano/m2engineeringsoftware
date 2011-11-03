package main;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import lattitude.Contact;
import lattitude.MaPosition;
import lattitude.PublishHistoriqueService;
import lattitude.PublishPositionService;
import lattitude.PublishUserService;
import lattitude.User;

public class Client2 {
	/**
     * Default InitialContextFactory to use.
     */
    private static final String DEFAULT_INITIAL_CONTEXT_FACTORY = "org.objectweb.carol.jndi.spi.MultiOrbInitialContextFactory";



    /**
     * Main method.
     * @param args the arguments (not required)
     * @throws Exception if exception is found.
     */
    public static final void main(final String[] args) throws Exception {

        Context initialContext = getInitialContext();

        /* PublishUserService interface defined prototype*/
        
        //void publishUser( String name, String firstName, String dateNaissance );
    	
    	//public void publishAuthentication( long uid, String login, String password );
    	
    	//public User connect( String login, String password );
    	
        //void userSetVisibleRight( long uid, boolean visible );
        
    	//boolean disconnect( long uid );
    	
    	//public List<User> getUser( String name, String FirstName );
    	
    	//public void setCurrentPostion( long uid,MaPosition position );
    	
    	//public void addContact( long uidUser, long uidContact );
    	
        //Collection<User> getContact( long uid )
        
    	//public MaPosition getPosition( long uidUser );
        //statelessPositionBean.publishPosition( 1, 2, 3 );
        //System.out.println( "publish position: x = 1, y = 2, z = 3" );
        //statelessBean.publishPosition( 2, 3, 4 );
        
        /*get set position*/
        PublishPositionService statelessPositionBean = ( PublishPositionService ) initialContext
                .lookup( "publishPositionBean" );
        
        /*get user service*/
        PublishUserService statelessUserBean = ( PublishUserService ) initialContext
        		.lookup( "publishUserBean" );
        //create toto user if doesn't exist
        User toto = statelessUserBean.publishUser( "toto", "tata",  "01/05/1996" );
        if( toto != null ){
        	System.out.println( "publish user: name=toto, firstName=tata, date=01/05/1996" );
        } else {
        //otherwise get toto user
        	List<User> users = statelessUserBean.getUser( "toto", "tata" );
        	for(User currentUser: users){
        		toto = currentUser;
        	}
        	System.out.println("toto already referenced on base");
        }
        
        //set login and password for toto
        statelessUserBean.publishAuthentication( toto.getId(), "genbon", "fromage" );
        System.out.println( "upate toto authication user login=genbon and password=fromage" );
        
        //set current toto position
        MaPosition totoPosition = statelessPositionBean.publishPosition( 2, 3, 4 );
        statelessUserBean.setCurrentPostion( toto.getId(), totoPosition );

        //set toto visible
        statelessUserBean.userSetVisibleRight( toto.getId(), true );
        
        //create tutu user if doesn't exist
        User tutu = statelessUserBean.publishUser( "tutu", "titi",  "12/01/1990" );
        if(tutu != null){
        	System.out.println( "publish user: name=tutu, firstName=titi, date=12/01/1990" );
        } else {
        //otherwise get tutu user
        	List<User> users = statelessUserBean.getUser( "tutu", "titi" );
        	for(User currentUser: users){
        		tutu = currentUser;
        	}
        	System.out.println( "tutu already referenced on base" );
        }
        
        //add tutu in contact list of toto
        statelessUserBean.addContact( toto.getId(), tutu.getId() );
        System.out.println( "add tutu in contact of toto" );
        
        //connect toto user
        //TODO use LDAP authentifcatino
        toto = statelessUserBean.connect( "genbon", "fromage" );
        if(toto != null) System.out.println( "toto connected" );
        //display position of toto user
        totoPosition = toto.getCurrentPosition();
        System.out.println( "toto position: x = " + totoPosition.getX() + ", y = " + totoPosition.getY() + ", z = " + totoPosition.getZ() );
        
        //get toto contact list
        Collection<Contact> totoContacts = statelessUserBean.getContact( toto.getId() );
        
        //display toto contact list
        for( Contact u: totoContacts/*toto.getContacts()*/ ){
        	System.out.println("name = " + u.getContact().getName() + ", firstName = " + u.getContact().getFirstName() + " is a contact of toto");
        }
        
        //disconnect user toto
        if(statelessUserBean.disconnect( toto.getId() ) )System.out.println( "toto user disconnected" );
        
    }

    /**
     * @return Returns the InitialContext.
     * @throws NamingException If the Context cannot be created.
     */
    private static Context getInitialContext() throws NamingException {

        // if user don't use jclient/client container
        // we can specify the InitialContextFactory to use
        // But this is *not recommended*.
        Hashtable<String, Object> env = new Hashtable<String, Object>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, getInitialContextFactory());

        // Usually a simple new InitialContext() without any parameters is sufficent.
        // return new InitialContext();

        return new InitialContext(env);
    }

    /**
     * Returns a configurable InitialContextFactory classname.<br/>
     * Can be configured with the <code>easybeans.client.initial-context-factory</code> System property.
     * @return Returns a configurable InitialContextFactory classname.
     */
    private static String getInitialContextFactory() {
        String prop = System.getProperty("easybeans.client.initial-context-factory");
        // If not found, use the default
        if (prop == null) {
            prop = DEFAULT_INITIAL_CONTEXT_FACTORY;
        }
        return prop;
    }
}
