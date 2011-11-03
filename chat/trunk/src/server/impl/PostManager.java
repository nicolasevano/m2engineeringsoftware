package server.impl;

import java.rmi.RemoteException;

import server.IPostManager;
import server.IUserManager;
import server.IUserManagerService;

import client.IChatUser;

public class PostManager implements IPostManager {
	
	IUserManager server;

	public IUserManager getServer() {
		return server;
	}

	public void setServer(IUserManager server) {
		this.server = server;
	}

	public void init(){
		System.out.println("initiate PostManager");
	}
	
	/* (non-Javadoc)
	 * @see server.IPostManager#postMessage(java.lang.String, java.lang.String)
	 */
	@Override
	public void postMessage(String pseudo, String message)
			throws RemoteException {
		String fullMessage = pseudo + " >> " + message;
		System.out.println(fullMessage);

		for (IChatUser user : server.getUsers().values()) {
			user.displayMessage(fullMessage);
		}
	}
}
