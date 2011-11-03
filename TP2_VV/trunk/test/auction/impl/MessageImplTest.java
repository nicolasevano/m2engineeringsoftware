package auction.impl;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.BulletinBoard;
import auction.Person;
import auction.User;

public class MessageImplTest {

	private MessageImpl message;
	
	//private BulletinBoard bulletinBordMock;
	private BulletinBoardImpl bulletinBoardImpl;
	
	public Person author;
	
	@Before
	public void setUp() throws Exception {
		
		//bulletinBordMock = EasyMock.createMock( BulletinBoard.class );
		bulletinBoardImpl = new BulletinBoardImpl(); 
		author = EasyMock.createMock( Person.class );
		EasyMock.expect( author.getEmail() ).andReturn( "jeanbon@gmail.com" );
		message = new MessageImpl(bulletinBoardImpl/*bulletinBordMock*/, author, "coucou test");
		
	}

	@After
	public void tearDown() throws Exception {
		
		message = null;
		author = null;
		bulletinBoardImpl = null;
		
	}

	@Test
	public void testMessageImpl() {
		
		assertNotNull( message );
		
	}

	@Test
	public void testGetAuthor() {
		
		assertEquals( author, message.getAuthor() );
		
	}

	@Test
	public void testGetBulletinBoard() {
		
		assertEquals( bulletinBoardImpl/*bulletinBordMock*/, message.getBulletinBoard());
		
	}

	@Test
	public void testGetMessage() {
		
		assertEquals( "coucou test", message.getMessage() );
		
	}

	@Test
	public void testToString() {
		
		EasyMock.replay(author);
		assertEquals( "jeanbon@gmail.com coucou test", message.toString() );
		
	}

}
