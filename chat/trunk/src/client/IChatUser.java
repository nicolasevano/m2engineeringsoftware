package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatUser extends Remote {
	public void displayMessage( String fullMessage) throws RemoteException;
}