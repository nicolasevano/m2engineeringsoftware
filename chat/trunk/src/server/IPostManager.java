package server;

import java.rmi.RemoteException;

public interface IPostManager {

	public abstract void postMessage(String pseudo, String message)
			throws RemoteException;

}