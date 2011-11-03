package client.impl;

import java.rmi.RemoteException;

import client.ICommande;
import client.IUser;


import server.impl.ChatRoom;


public class CommandeUnregister implements ICommande {

	public ChatRoom getRoom() {
		return room;
	}

	public void setRoom(ChatRoom room) {
		this.room = room;
	}

	public CommandeUnregister(){
		
	}
	
	public CommandeUnregister(ChatRoom room) {
		this.room = room;
	}

	public void execute() {
		try {
			room.unsubscribe(user.getPseudo());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setUser(IUser user) {
		this.user = user;
	}
	
	ChatRoom room = null;
	
	IUser user = null;
}
