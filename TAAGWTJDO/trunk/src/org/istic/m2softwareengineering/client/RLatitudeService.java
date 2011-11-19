package org.istic.m2softwareengineering.client;




import java.util.List;


import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("latitude")
public interface RLatitudeService extends RemoteService {

	String sayHello();
	
	public String publishUser( String name, String firstName, String dateNaissance );
	
	public boolean checkPasswordLoginValidity( String login, String password );
	
	public void publishAuthentication( String uid, String login, String password );

	public String connect( String login, String password );
	
	public boolean disconnect( String uid );
	
	public boolean changeMyVisibility( String uid, boolean visibility );
	
	public boolean getVisibility( String uid );
	
	public void setCurrentPostion( String uid,Position position );
	
	public void addContact( String uidUser, String uidContact );
	
	public List<ResolvedContact> getContact( String uid );
	
	public ResolvedUser getUser( String name, String firstName );
	
	public ResolvedUser getUser(String uid);
	
	public Position getPosition( String uidUser );
	
}