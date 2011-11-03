package server.impl;

import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Map;

import server.IPostManager;
import server.IUserManager;

import client.IChatUser;

public class UserManager implements IUserManager {
	
	IPostManager post;
	
	private Map<String, IChatUser> users /*= new Hashtable<String, IChatUser>()*/;
	
	public IPostManager getPost() {
		return post;
	}

	public void setPost(IPostManager post) {
		this.post = post;
	}

	/* (non-Javadoc)
	 * @see server.IUserManager#getUsers()
	 */
	@Override
	public Map<String, IChatUser> getUsers() {
		return users;
	}

	public void setUsers(Map<String, IChatUser> users) {
		this.users = users;
	}

	public void init(){
		System.out.println("initiate UserManager");
	}
	
	/* (non-Javadoc)
	 * @see server.IUserManager#subscribe(client.ChatUser, java.lang.String)
	 */
	@Override
	public void subscribe(IChatUser user, String pseudo) throws RemoteException {
		String message = "Connexion de " + pseudo;
		post.postMessage("ChatRoom", message);
		System.out.println(message);
		this.users.put(pseudo, user);
	}

	/* (non-Javadoc)
	 * @see server.IUserManager#unsubscribe(java.lang.String)
	 */
	@Override
	public void unsubscribe(String pseudo) throws RemoteException {
		String message = "Deconnexion de " + pseudo;
		System.out.println(message);
		this.users.remove(pseudo);
		post.postMessage("ChatRoom", message);
	}
	
}
