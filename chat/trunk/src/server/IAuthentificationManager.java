package server;

import java.rmi.RemoteException;

import javax.security.auth.login.FailedLoginException;

public interface IAuthentificationManager {

	public abstract boolean authentification(String username, char[] password)
			throws FailedLoginException, RemoteException;

}