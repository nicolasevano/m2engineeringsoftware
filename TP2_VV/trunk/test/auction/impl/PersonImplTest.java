package auction.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.impl.PersonImpl;

public class PersonImplTest {
	protected PersonTest person;
	
	class PersonTest extends PersonImpl{
		protected PersonTest() {
			super();
		}
		
		public PersonTest(String firstName,String lastName,String email,String password,String address) {
			super(firstName,lastName,email,password,address);
		}
	};
	
	@Before
	public void setUp(){
		person = new PersonTest( "Bon", "Jean", "jeanbon@gmail.com", "torchon", "far far away" );;
		
	}
	
	@After
	public void tearDown(){
		person = null;
	}
	
	@Test
	public void testPersonImpl() {
		person = new PersonTest();
		assertNotNull( person );
	}

	@Test
	public void testPersonImplStringStringStringStringString() {
		assertNotNull( person );
	}

	@Test
	public void testGetAdress() {
		assertEquals("far far away", person.getAdress());
	}

	@Test
	public void testGetEmail() {
		assertEquals("jeanbon@gmail.com", person.getEmail());
	}

	@Test
	public void testGetFirstName() {
		assertEquals("Bon", person.getFirstName());
	}

	@Test
	public void testGetLastName() {
		assertEquals("Jean", person.getLastName());
	}

	@Test
	public void testGetPassword() {
		assertEquals("torchon", person.getPassword());
	}

}
