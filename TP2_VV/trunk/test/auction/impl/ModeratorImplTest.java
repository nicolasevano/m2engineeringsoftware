package auction.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.impl.PersonImplTest.PersonTest;


public class ModeratorImplTest {
	
	protected ModeratorImpl moderator;
	
	@Before
	public void setUp(){
		moderator = new ModeratorImpl( "Bon", "Jean", "jeanbon@gmail.com", "torchon", "far far away" );;
		
	}
	
	@After
	public void tearDown(){
		moderator = null;
	}
	
	@Test
	public void testModeratorImplStringStringStringStringString() {
		assertNotNull( moderator );
	}
}
