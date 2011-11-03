package lattitude;

import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface PublishUserService {
	
	public User publishUser( String name, String firstName, String dateNaissance );
	
	public void publishAuthentication( long uid, String login, String password );
	
	public User connect( String login, String password );
	
	public void userSetVisibleRight( long uid, boolean visible );
	
	public boolean disconnect( long uid );
	
	public List<User> getUser( String name, String FirstName );
	
	public void setCurrentPostion( long uid,MaPosition position );
	
	public void addContact( long uidUser, long uidContact );
	
	public Collection<Contact> getContact( long uid );
	
	public MaPosition getPosition( long uidUser );
	
}
