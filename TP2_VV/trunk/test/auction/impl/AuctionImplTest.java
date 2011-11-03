package auction.impl;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Person;
import auction.User;
import auction.states.Open;

public class AuctionImplTest {
	//private User sellerTestMock;
	private User sellerTestImpl;
	private UserImpl userImpl;
	private UserImpl userImpl2;
	private BidImpl bidTestImpl;
	private BidImpl bidTestImpl2;
	private AuctionImpl auctionImpl;
	private AccountImpl accountImpl;
	
	@Before
	public void setUp() throws Exception {
		
		//sellerTestMock = EasyMock.createMock( User.class );
		sellerTestImpl = new UserImpl( "Orange", "The firme", "orangeFirme@Orange.fr", "Orange", "absolue" );
		userImpl = new UserImpl( "bon", "Jean", "jeanbon@gmail.com", "jeanbon", "torchon" );
		userImpl2 = new UserImpl( "bon", "superJean", "superjeanbon@gmail.com", "superJeanbon", "torchon" );
		auctionImpl = new AuctionImpl( sellerTestImpl, "livebox", "Inventel V1", 310, 540, 10 );
		bidTestImpl = new BidImpl( userImpl, auctionImpl, 13 );
		bidTestImpl2 = new BidImpl( userImpl2, auctionImpl, 17);
	}

	@After
	public void tearDown() throws Exception {
		
		//sellerTestMock = null;
		sellerTestImpl = null;
		userImpl = null;
		userImpl2 = null;
		auctionImpl = null;
		bidTestImpl = null;
		bidTestImpl2 = null;
		
	}

	@Test
	public void testAuctionImpl() {
		
		assertNotNull( auctionImpl );
		
	}

	@Test
	public void testCancelAuction() {
		
		auctionImpl.cancelAuction( sellerTestImpl );
		assertEquals( "CANCELLED", auctionImpl.getState().getName() );
		
	}

	@Test
	public void testClose() {
		auctionImpl.open();
		//sellerTestImpl = new UserImpl( "Orange", "The firme", "orangeFirme@Orange.fr", "Orange", "absolue" );
		//userImpl = new UserImpl( "bon", "Jean", "jeanbon@gmail.com", "jeanbon", "torchon" );
		auctionImpl.placeBid(userImpl, 16 );
		auctionImpl.close();
		assertEquals( "CLOSED", auctionImpl.getState().getName() );
		
	}

	@Test
	public void testGetBidHistory() {
		//result.append(b) was commented sound like a bug find with testGetBidHistory
		//auctionImpl.getBids().add( bidTestImpl );
		auctionImpl.getBidHistory();
		String expectedResult = "jeanbon@gmail.com 13"+System.getProperty("line.separator")+"superjeanbon@gmail.com 17";
		assertEquals( expectedResult, auctionImpl.getBidHistory() );
		
	}

	@Test
	public void testGetBids() {
		assertTrue( auctionImpl.getBids().contains( bidTestImpl ) );
	}

	@Test
	public void testGetBulletinBoard() {
		assertNotNull( auctionImpl.getBulletinBoard() );
	}

	@Test
	public void testGetCurrentBid() {
		auctionImpl.open();
		assertEquals(bidTestImpl2.toString(),auctionImpl.getCurrentBid());
	}

	@Test
	public void testGetDescription() {
		assertEquals( "Inventel V1",auctionImpl.getDescription() );
	}

	@Test
	public void testGetEndD() {
		assertEquals( "540", auctionImpl.getEndD() );
	}

	@Test
	public void testGetEndDate() {
		assertEquals( 540, auctionImpl.getEndDate() );
	}

	@Test
	public void testGetJoinedUsers() {
		auctionImpl.open();
		auctionImpl.join( userImpl );
		assertTrue( auctionImpl.getJoinedUsers().contains( userImpl ) );
	}

	@Test
	public void testGetMaxBid() {
		assertEquals( bidTestImpl2,auctionImpl.getMaxBid() );
	}

	@Test
	public void testGetMinBid() {
		assertEquals( "10",auctionImpl.getMinBid() );
	}

	@Test
	public void testGetMinimumBid() {
		assertEquals( 10,auctionImpl.getMinimumBid() );
	}

	@Test
	public void testGetName() {
		assertEquals( "livebox", auctionImpl.getName());
	}

	@Test
	public void testGetSeller() {
		assertEquals( sellerTestImpl,auctionImpl.getSeller() );
	}

	@Test
	public void testGetStartD() {
		assertEquals( "310", auctionImpl.getStartD() );
	}

	@Test
	public void testGetStartDate() {
		assertEquals( 310, auctionImpl.getStartDate() );
	}

	@Test
	public void testGetState() {
		assertEquals( "PENDING", auctionImpl.getState().getName() );
	}

	@Test
	public void testJoin() {
		
		auctionImpl.open();
		//auctionImpl.join( userImpl );
		assertEquals( "OK",auctionImpl.join( userImpl ) );
		
	}

	@Test
	public void testLeave() {
		
		auctionImpl.open();
		auctionImpl.join( userImpl );
		auctionImpl.join( userImpl2 );
		//auctionImpl.leave( userImpl );
		assertEquals( "ERROR: you cannot leave an auction when you have the best bid",
					  auctionImpl.leave( userImpl2 ) );
		assertEquals( "OK",
				  auctionImpl.leave( userImpl ) );
		
	}

	@Test
	public void testMinimumAmount() {

		assertEquals( ( ( 17*11 ) /10 ),auctionImpl.minimumAmount() );
	
	}

	@Test
	public void testOpen() {
		
		auctionImpl.open();
		assertEquals( "OPEN",auctionImpl.getState().getName() );
		
	}

	@Test
	public void testPlaceBid() {
		auctionImpl.placeBid( userImpl, 17 );
		assertEquals( 2,auctionImpl.getBids().size() );
	}

	@Test
	public void testPostMessage() {
		//auctionImpl.placeBid( userImpl, 17 );
		//assertEquals( 2,auctionImpl.getBids().size() );
		auctionImpl.open();
		String result = auctionImpl.postMessage( sellerTestImpl, "good price!" );
		System.out.println("result = " + result);
		assertEquals( "orangeFirme@Orange.fr good price!",auctionImpl.getBulletinBoard().getMessages().get( 0 ).toString() );
	}

	@Test
	public void testSetDesc() {
		assertEquals( "OK",auctionImpl.setDesc(sellerTestImpl, "Sagem V1") );
		assertEquals( "Sagem V1",auctionImpl.getDescription() );
	}

	@Test
	public void testSetDescription() {
		auctionImpl.setDescription("Sagem V1");
		assertEquals( "Sagem V1",auctionImpl.getDescription() );
	}

	@Test
	public void testSetEndD() {
		auctionImpl.setEndD( sellerTestImpl, 600 );
		assertEquals( "600",auctionImpl.getEndD() );
	}

	@Test
	public void testSetEndDate() {
		auctionImpl.setEndDate( 600 );
		assertEquals( "600", auctionImpl.getEndD() );
	}

	@Test
	public void testSetMinBid() {
		auctionImpl.setMinBid(sellerTestImpl, 13);
		assertEquals( "13", auctionImpl.getMinBid() );
	}

	@Test
	public void testSetMinimumBid() {
		auctionImpl.setMinimumBid(13);
		assertEquals( "13", auctionImpl.getMinBid() );
	}

	@Test
	public void testSetStartD() {
		auctionImpl.setStartD(sellerTestImpl, 210);
		assertEquals( "210",auctionImpl.getStartD() );
	}

	@Test
	public void testSetStartDate() {
		auctionImpl.setStartDate(210);
		assertEquals( "210",auctionImpl.getStartD() );
	}

	@Test
	public void testSetState() {
		auctionImpl.setState( new Open() );
		assertEquals( "OPEN",auctionImpl.getState().getName() );
	}

	@Test
	public void testToString() {
		assertEquals( "livebox" + " " + "Inventel V1" + " " + "PENDING" + " " + "540" ,auctionImpl.toString() );
	}

}
