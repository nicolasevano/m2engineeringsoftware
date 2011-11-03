package server;

import java.rmi.RemoteException;

import client.IChatUser;

public interface IUserManagerService {

	public abstract void subscribe(IChatUser user, String pseudo)
			throws RemoteException;

	public abstract void unsubscribe(String pseudo) throws RemoteException;

}