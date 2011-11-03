package auction.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.User;

public class ReserveAuctionImplTest {
	
	private User sellerTestImpl;
	private UserImpl userImpl;
	private UserImpl userImpl2;
	private BidImpl bidTestImpl;
	private BidImpl bidTestImpl2;
	private ReserveAuctionImpl reserveAuctionImpl;
	private AccountImpl accountImpl;
	
	@Before
	public void setUp() throws Exception {
		
		sellerTestImpl = new UserImpl( "Orange", "The firme", "orangeFirme@Orange.fr", "Orange", "absolue" );
		userImpl = new UserImpl( "bon", "Jean", "jeanbon@gmail.com", "jeanbon", "torchon" );
		userImpl2 = new UserImpl( "bon", "superJean", "superjeanbon@gmail.com", "superJeanbon", "torchon" );
		reserveAuctionImpl = new ReserveAuctionImpl( sellerTestImpl, "livebox", "Inventel V1", 310, 540, 10, 40 );
		bidTestImpl = new BidImpl( userImpl, reserveAuctionImpl, 13 );
		bidTestImpl2 = new BidImpl( userImpl2, reserveAuctionImpl, 17);
		
	}

	@After
	public void tearDown() throws Exception {
		
		//sellerTestMock = null;
		sellerTestImpl = null;
		userImpl = null;
		userImpl2 = null;
		reserveAuctionImpl = null;
		bidTestImpl = null;
		bidTestImpl2 = null;
		
	}

	@Test
	public void testReserveAuctionImpl() {
		assertNotNull( reserveAuctionImpl );
	}

	@Test
	public void testGetReservePrice() {
		assertEquals( 40,reserveAuctionImpl.getReservePrice() );
	}

	@Test
	public void testSetReservePrice() {
		reserveAuctionImpl.setReservePrice( 50 );
		assertEquals( 50,reserveAuctionImpl.getReservePrice() );
	}

	@Test
	public void testSetResPrice() {
		
		reserveAuctionImpl.setResPrice( sellerTestImpl,50 );
		assertEquals( 50,reserveAuctionImpl.getReservePrice() );
		
	}

}
