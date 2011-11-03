package server.impl;

//import java.rmi.Naming;
import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.server.UnicastRemoteObject;
//import java.util.Hashtable;

import javax.security.auth.login.FailedLoginException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.Authentication;
import org.springframework.security.AuthenticationManager;
import org.springframework.security.BadCredentialsException;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;

//import server.IAuthentificationManager;
import server.IPostManager;
import server.IUserManager;
//import server.IUserManagerService;

import client.IChatUser;

public class ChatRoomImpl implements ChatRoom {
	
	public static void main(String[] args) throws Exception {
		//try {
		//	LocateRegistry.createRegistry(1099);
		//} catch (Exception e) {
		//	System.err.println("Il y a deja un registre de lancer");
		//}

		//ChatRoomImpl room = new ChatRoomImpl();
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext( "server_configuration.xml" );
		ChatRoom room  = ( ChatRoom ) beanFactory.getBean( "server" );
		//Naming.rebind("ChatRoom", room);
		//authManager = ( IAuthentificationManager ) beanFactory.getBean( "authenticationManager" );
		//postManager = ( IPostManager ) beanFactory.getBean( "postManager" );
		//userManager = ( UserManager ) beanFactory.getBean( "userManager" );
		
	}

	public ChatRoomImpl() throws RemoteException {
	}

	@Override
	public boolean authentification(String username, char[] password)
			throws FailedLoginException, RemoteException, BadCredentialsException {
		//((AuthentificationManager)authManager).init();
		//return authManager.authentification(username, password);
		String pwd = "";
		for(int i = 0; i <password.length; i++){
			pwd += password[i];
		}
		Authentication auth = authManager.authenticate( new UsernamePasswordAuthenticationToken( username, pwd ) );
        return auth.isAuthenticated();
	}

	public IPostManager getPostmanager() {
		return postManager;
	}

	public IUserManager getUsermanager() {
		return userManager;
	}
	
	//public IAuthentificationManager getAuthManager() {
	//	return authManager;
	//}

	//public void setAuthManager(IAuthentificationManager authManager) {
	//	this.authManager = authManager;
	//}
	
	public AuthenticationManager getAuthManager() {
		return authManager;
	}

	public void setAuthManager(AuthenticationManager authManager) {
		this.authManager = authManager;
	}
	
	public void setPostmanager(IPostManager postmanager) {
		this.postManager = postmanager;
	}

	public void setUsermanager(IUserManager usermanager) {
		this.userManager = usermanager;
	}

	@Override
	public void subscribe(IChatUser user, String pseudo) throws RemoteException {
		userManager.subscribe(user, pseudo);
		
	}

	@Override
	public void unsubscribe(String pseudo) throws RemoteException {
		userManager.unsubscribe(pseudo);
	}
 
	@Override
	public void postMessage(String pseudo, String message)
			throws RemoteException {
		postManager.postMessage(pseudo, message);
	}

	//private IAuthentificationManager authManager;
	private AuthenticationManager authManager;
	private IPostManager postManager;                                                                                                                                                                                                                                                                                                 

	private IUserManager userManager;


}