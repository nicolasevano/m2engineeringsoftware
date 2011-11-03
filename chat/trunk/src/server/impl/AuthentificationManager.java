package server.impl;

import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Map;

import javax.security.auth.login.FailedLoginException;

import server.IAuthentificationManager;


public class AuthentificationManager implements IAuthentificationManager {
	
	private Map<String, char[]> alloweduser /*= new Hashtable<String, char[]>()*/;
	
	public Map<String, char[]> getAlloweduser() {
		return alloweduser;
	}

	public void setAlloweduser(Map<String, char[]> alloweduser) {
		this.alloweduser = alloweduser;
	}

	public AuthentificationManager() {
		
		//TODO do not fix user login and password inside code
		//alloweduser.put("toto", "passtoto".toCharArray());
		//alloweduser.put("titi", "passtiti".toCharArray());
		//alloweduser.put("testUser", "testPassword".toCharArray());	// TODO Auto-generated constructor stub
		
	}
	
	public void init(){
		System.out.println( "initiate AuthentificationManager" );
	}
	
	/* (non-Javadoc)
	 * @see server.IAuthentificationManager#authentification(java.lang.String, char[])
	 */
	@Override
	public boolean authentification(String username, char[] password)
			throws FailedLoginException, RemoteException {
		// verify the username/password
		boolean usernameCorrect = false;
		boolean passwordCorrect = false;
		if (this.alloweduser.containsKey(username)) {
			usernameCorrect = true;
			if (password.length == this.alloweduser.get(username).length
					&& testPassword(this.alloweduser.get(username), password)) {

				// authentication succeeded!!!
				passwordCorrect = true;
				
					System.out.println("\t\t[SampleLoginModule] "
							+ "authentication succeeded");
				return true;
			}

		}

		// authentication failed -- clean out state
	
			System.out.println("\t\t[SampleLoginModule] "
					+ "authentication failed");
		System.out.println("password = ");
		for(int i=0; i < password.length; i++)
			System.out.print( password[i] );		
		System.out.println("");
		System.out.println("referenced password for this user is:");
		for(int i=0; i < password.length; i++)
			password[i] = ' ';
		for (int i = 0; i < this.alloweduser.get(username).length; i++)
			System.out.print( this.alloweduser.get(username)[i] );
		if (!usernameCorrect) {
			throw new FailedLoginException("User Name Incorrect");
		} else {
			throw new FailedLoginException("Password Incorrect");

		}
	}

	private boolean testPassword(char[] cs, char[] password) {
		boolean result = true;
		int i = 0;
		while (i < cs.length && result) {
			if (cs[i] != password[i])
				result = false;
			i++;
		}
		return result;
	}

}
