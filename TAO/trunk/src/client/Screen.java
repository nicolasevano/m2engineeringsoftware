package client;
import java.rmi.Remote;
import java.rmi.RemoteException;

import canal.CallableServant;

public interface Screen extends Remote {

	/** 
	 * Update function change displayed value on screen.
	 * @param value int
	 */
	public abstract void update(CallableServant outputCallable) throws RemoteException;
	
	public abstract int getID() throws RemoteException;
	
}