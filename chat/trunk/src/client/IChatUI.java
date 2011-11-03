package client;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public interface IChatUI {

	public abstract void window_windowClosing(WindowEvent e);

	public abstract void btnSend_actionPerformed(ActionEvent e);

	public abstract void displayMessage(String message);

	public abstract String requestPseudo();

	public abstract String getMessage();
	
	public ICommande getPostMessage();
	
	public ICommande getUnregister();
	
	public void initIHM();

}