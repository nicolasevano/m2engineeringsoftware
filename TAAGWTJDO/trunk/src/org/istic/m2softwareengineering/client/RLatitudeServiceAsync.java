package org.istic.m2softwareengineering.client;



import java.util.List;


import com.google.gwt.user.client.rpc.AsyncCallback;
//app engine code 1534705
public interface RLatitudeServiceAsync {

	void sayHello(AsyncCallback<String> callback);

	void publishUser(String name, String firstName, String dateNaissance,
			AsyncCallback< String > callback );
	
	void checkPasswordLoginValidity( String login, String password, AsyncCallback< Boolean > callback );
	
	void publishAuthentication( String uid, String login, String password, AsyncCallback</*IUser*/Void> callback );
	
	void connect(String login, String password, AsyncCallback< String > callback);
	
	void disconnect(String uid, AsyncCallback< Boolean > callback);
	
	void changeMyVisibility(String uid, boolean visibility,
			AsyncCallback<Boolean> callback);

	void getVisibility(String uid, AsyncCallback<Boolean> callback);
	
	void setCurrentPostion(String uid, Position position,
			AsyncCallback<Void> callback);
	
	void addContact( String uidUser, String uidContact, AsyncCallback< Void > callback );
	
	void getContact( String uid,
			AsyncCallback< List< ResolvedContact > > callback );
	
	void getUser( String name, String lastName, AsyncCallback<ResolvedUser> callback );
	
	void getUser(String uid,AsyncCallback<ResolvedUser> callback);

	void getPosition( String uidUser, AsyncCallback< Position > callback );

}
