package client.impl;

import java.rmi.RemoteException;

import client.ICommande;
import client.IChatUI;
import client.IUser;


import server.impl.ChatRoom;


public class CommandPost implements ICommande {

	public CommandPost() {
		
	}
	
	public CommandPost(ChatRoom room) {
		this.room = room;
	}

	public void execute() {
		try {
			room.postMessage(user.getPseudo(), ui.getMessage());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void setUser(IUser user) {
		this.user = user;
	}

	public ChatRoom getRoom() {
		return room;
	}

	public void setRoom(ChatRoom room) {
		this.room = room;
	}
	
	public IChatUI getUi() {
		return ui;
	}

	public void setUi(IChatUI ui) {
		this.ui = ui;
	}
	
	ChatRoom room = null;
	IUser user = null;
	IChatUI ui = null;
	
}
