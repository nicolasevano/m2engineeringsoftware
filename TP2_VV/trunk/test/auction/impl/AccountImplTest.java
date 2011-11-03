/**
 * 
 */
package auction.impl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Auction;
import auction.User;

/**
 * @author 28008663
 *
 */
public class AccountImplTest {
	protected AccountImpl accountImpl;
	protected User userMock;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userMock = EasyMock.createMock( User.class );
		accountImpl = new AccountImpl( userMock );
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		accountImpl = null;
		userMock = null;
	}

	@Test
	public void testAccountImpl(){
		assertNotNull( accountImpl );
	}

	/* (non-Javadoc)
	 * @see auction.AccountItf#decCredit(int)
	 */
	@Test
	public void testDecCredit(){
		int credit = 0;
		accountImpl.decCredit(2);
		credit -= 2;
		assertEquals( credit, accountImpl.getCredit() );
	}
			
	/* (non-Javadoc)
	 * @see auction.AccountItf#getCredit()
	 */
	@Test
	public void testGetCredit() {
		assertEquals( 0, accountImpl.getCredit() );
		accountImpl.incCredit( 2 );
		assertEquals( 2, accountImpl.getCredit() );
		
	}

	/* (non-Javadoc)
	 * @see auction.AccountItf#getCredits()
	 */
	@Test
	public void testGetCredits(){
		//accountImpl.getCredit();
		//accountImpl.getFreeCredit();
		assertEquals( accountImpl.getCredit() + " " + accountImpl.getFreeCredit(),accountImpl.getCredits() );
	}

	/* (non-Javadoc)
	 * @see auction.AccountItf#getFreeCredit()
	 */
	@Test
	public void testGetFreeCredit(){
		//TODO 
		assertTrue(true);
	}

	/* (non-Javadoc)
	 * @see auction.AccountItf#incCredit(int)
	 */
	@Test
	public void testIncCredit(){
		int credit = 0;
		accountImpl.incCredit( 2 );
		credit += 2;
		assertEquals( credit, accountImpl.getCredit() );
	}
}
