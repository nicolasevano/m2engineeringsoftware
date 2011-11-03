package client.impl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.BadCredentialsException;

import server.impl.ChatRoom;


import client.ICommande;
import client.IChatUser;
import client.IChatUI;
import client.IUser;

import com.sun.security.auth.callback.DialogCallbackHandler;


public class ChatUserImpl extends UnicastRemoteObject implements IChatUser,
		Runnable, IUser{

	public ChatUserImpl(String name) throws RemoteException {
		super(); // Appel au constructeur de UnicastRemoteObject
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see client.impl.IChatUser#displayMessage(java.lang.String)
	 */
	@Override
	public void displayMessage( String message ) throws RemoteException {
		ui.displayMessage( message );
	}

	/* (non-Javadoc)
	 * @see client.impl.IChatUser#run()
	 */
	public void run() {
		ui = ( IChatUI ) beanFactory.getBean( "chatUI" );
		ui.getPostMessage().setUser(this);
		ui.getUnregister().setUser(this);
		ui.initIHM();
		try {
			lc = null;
			try {
				lc = ( SampleLoginModule ) beanFactory.getBean( "sampleLoginModule" );
			} catch ( SecurityException se ) {
				System.err.println( "Cannot create LoginContext. " + se.getMessage() );
				System.exit( -1 );
			}
			// the user has 3 attempts to authenticate successfully
			int i;
			for ( i = 0; i < 3; i++ )
				try {
					// attempt authentication
					lc.login();
					// if we return with no exception, authentication succeeded
					break;
				} catch ( LoginException le ) {
					System.err.println( "Authentication failed:" );
					System.err.println( "  " + le.getMessage() );
					try {
						Thread.currentThread().sleep( 3000 );
					} catch ( Exception e ) {/* ignore*/}
				} catch (BadCredentialsException bce){
					System.err.println( "Authentication failed:" );
					System.err.println( "  " + bce.getMessage() );
					try {
						Thread.currentThread().sleep( 3000 );
					} catch ( Exception e ) {/* ignore*/}
				}
			// did they fail three times?
			if (i == 3) {
				System.out.println( "Sorry" );
				System.exit( -1 );
			}
			System.out.println( "Authentication succeeded!" );
			this.pseudo = ui.requestPseudo();
			this.room.subscribe( this, this.pseudo );
		} catch ( RemoteException e ) { e.printStackTrace(); }
	}

	/* (non-Javadoc)
	 * @see client.impl.IChatUser#getPseudo()
	 */
	public String getPseudo() {
		return pseudo;
	}
	
	public ChatRoom getRoom() {
		return room;
	}

	public void setRoom( ChatRoom room ) {
		this.room = room;
	}
	
	public IChatUI getUi() {
		return ui;
	}

	public void setUi(IChatUI ui) {
		this.ui = ui;
	}
	
	public SampleLoginModule getLc() {
		return lc;
	}

	public void setLc(SampleLoginModule lc) {
		this.lc = lc;
	}
	
	public ApplicationContext getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(ApplicationContext beanFactory) {
		this.beanFactory = beanFactory;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 2795686112508047326L;

	private ChatRoom room = null;

	private String pseudo = null;

	private String name = null;

	private IChatUI ui;
	
	private SampleLoginModule lc;
	
	private ApplicationContext beanFactory;

}