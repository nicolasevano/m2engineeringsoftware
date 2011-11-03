package auction.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Auction;
import auction.AuctionState;
import auction.Bid;
import auction.Person;
import auction.User;

public class BidImplTest {
	
	public UserImpl userImpl;
	
	public Auction auction;
	
	public BidImpl bidImpl;
	
	public Collection<BidImpl> bidList;
	
	@Before
	public void setUp() throws Exception {
		bidList = new ArrayList<BidImpl>();
		userImpl = new UserImpl( "Bon", "Jean", "jeanbon@gmail.com", "torchon", "far far away" );;
		//EasyMock.expect( userImpl.getLastName() ).andReturn( "Jean" );
		//EasyMock.expect(userImpl.getEmail() ).andReturn( "jeanbon@gmail.com" );
		//auction = new AuctionTest();
		auction = EasyMock.createMock( Auction.class );
		EasyMock.expect( auction.getName() ).andReturn( "right test auction" ).anyTimes();
		EasyMock.expect( auction.getBids() ).andReturn( bidList ).anyTimes();
		EasyMock.replay( auction );
		//constructor BidImpl take UserImpl in parameter should be User
		bidImpl = new BidImpl( userImpl, auction, 3 );
		
	}

	@After
	public void tearDown() throws Exception {
		
		userImpl = null;
		auction = null;
		bidImpl = null;
		bidList = null;
		
	}

	@Test
	public void testBidImpl() {
		assertNotNull( bidImpl );
	}

	@Test
	public void testGetAmount() {
		assertEquals( 3, bidImpl.getAmount() );
	}

	@Test
	public void testGetAuction() {
		//System.out.println("actionTest name = " + auction.getName());
		//System.out.println("actionTest name = " + bidImpl.getAuction().getName());
		//Auction testAution = bidImpl.getAuction();
		//System.out.println( testAution.getName() );
		//assertNotNull( bidImpl.getAuction() );
		assertEquals( /*auction*/ "right test auction" , bidImpl.getAuction().getName() );
		//assertTrue( ( ( bidImpl.getAuction() ) instanceof Auction ) );
		//test as fine a bug in constructor
	}

	@Test
	public void testGetUser() {
		assertEquals( "Jean", bidImpl.getUser().getLastName() );
	}

	@Test
	public void testToString() {
		//user.getEmail()+" "+amount;
		assertEquals("jeanbon@gmail.com 3", bidImpl.toString());
	}

}
