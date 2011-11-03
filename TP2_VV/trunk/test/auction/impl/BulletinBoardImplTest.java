package auction.impl;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.BulletinBoard;
import auction.Message;
import auction.Moderator;
import auction.Person;

public class BulletinBoardImplTest {
	
	private BulletinBoardImpl bulletinBoardImpl;
	private MessageImpl messageImpl;
	private MessageImpl messageImpl1;
	private Moderator moderator;
	
	@Before
	public void setUp() throws Exception {

		bulletinBoardImpl = new BulletinBoardImpl();
		moderator = EasyMock.createMock( Moderator.class );
		EasyMock.expect( moderator.getEmail() ).andReturn("jeanbon@gmail.com").anyTimes();
		EasyMock.replay( moderator );
		messageImpl = new MessageImpl( bulletinBoardImpl, moderator, "test guess message" );
		messageImpl1 = new MessageImpl( bulletinBoardImpl, moderator, "test message" );
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		bulletinBoardImpl = null;
		messageImpl = null;
		messageImpl1 = null;
		moderator = null;
		
	}

	@Test
	public void testBulletinBoard(){
		
		assertNotNull( bulletinBoardImpl );
		
	}
	
	@Test
	public void testDelMessage() {
		
		assertEquals( 2, bulletinBoardImpl.getMessages().size() );
		bulletinBoardImpl.delMessage( moderator, 1 );
		assertEquals( 1, bulletinBoardImpl.getMessages().size() );
		
	}

	@Test
	public void testGetMess() {
		
		assertEquals( "1 jeanbon@gmail.com test guess message" + System.getProperty( "line.separator" ) + "2 jeanbon@gmail.com" + " test message", bulletinBoardImpl.getMess() );
		
	}

	@Test
	public void testGetMessages() {
		
		bulletinBoardImpl.getMessages().add( messageImpl );
		assertEquals( messageImpl, bulletinBoardImpl.getMessages().get( 0 ) );
		
	}

}
