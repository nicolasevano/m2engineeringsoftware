package auction.impl;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Account;
import auction.Auction;
import auction.Bid;


public class UserImplTest {
	
	private UserImpl userTest;
	
	@Before
	public void setUp(){
		userTest = new UserImpl( "Bon", "Jean", "jeanbon@gmail.com", "torchon", "far far away" );
		
	}
	
	@After
	public void tearDown(){
		userTest = null;
	}
	
	@Test
	public void testUserImplStringStringStringStringString() {
		assertNotNull(userTest);
	}

	/* (non-Javadoc)
	 * @see auction.impl.User#getAccount()
	 */
	@Test
	public void testGetAccount() {
		assertNotNull(userTest.getAccount());
	}

	/* (non-Javadoc)
	 * @see auction.impl.User#getBids()
	 */
	@Test
	public void testGetBids() {
		assertNotNull(userTest.getBids());
	}

	/* (non-Javadoc)
	 * @see auction.impl.User#getJoinedAuctions()
	 */
	@Test
	public void testGetJoinedAuctions() {
		assertNotNull(userTest.getJoinedAuctions());
	}
	
}
