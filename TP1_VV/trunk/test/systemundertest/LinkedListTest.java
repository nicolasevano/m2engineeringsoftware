package systemundertest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	@Before
	public void setUp() throws Exception {
		list = new LinkedList();
	}

	@After
	public void tearDown() throws Exception {
		list = null;
	}

	@Test
	public void testSize() {
		//fail("Not yet implemented");
		assertEquals( "test de la méthode size avec aucun element dans la liste", 
				  		0, list.size() );
	}

	@Test
	public void testClear() {
		//fail("Not yet implemented");
		list.clear();
		assertEquals( "test de la méthode clear sur une liste vide", 
		  				0, list.size() );

	}

	@Test
	public void testLinkedList() {
		//fail("Not yet implemented");
		assertNotNull( "test du constructeur",list );
	}

	@Test
	public void testLinkedListCollection() {
		//fail("Not yet implemented");
		Collection tmp = new ArrayList();
		tmp.add( new Object() );
		tmp.add( new Object() );
		list = null;
		list = new LinkedList( tmp );
		assertNotNull( "test du constructeur avec une collection en parametre",list );
		assertEquals( "tailler espérer 2", 
  				2, list.size() );
	}

	@Test
	public void testGetFirst() {
		//fail("Not yet implemented");
		Object o = new Object(); 
		list.add( o );
		assertEquals( "Test de la méthode getFirst sur une liste avec un element", 
  				o, list.getFirst() );
	}

	@Test
	public void testGetLast() {
		//fail("Not yet implemented");
		Object o = new Object(); 
		list.add( o );
		assertEquals( "Test de la méthode getLast sur une liste avec un element", 
  				o, list.getLast() );
	}

	@Test
	public void testRemoveFirst() {
		//fail("Not yet implemented");
		Object o = new Object(); 
		list.add( o );
		list.removeFirst();
		assertEquals( "Test de la méthode removeFirst sur une liste avec un element", 
  				0, list.size() );
	}

	@Test
	public void testRemoveLast() {
		//fail("Not yet implemented");
		Object o = new Object(); 
		list.add( o );
		list.removeLast();
		assertEquals( "Test de la méthode removeLast sur une liste avec un element", 
  				0, list.size() );
	}

	@Test
	public void testAddFirst() {
		//fail("Not yet implemented");
		Object o = new Object(); 
		list.addFirst( o );
		assertEquals( "Test de la méthode addFirst sur une vide", 
  				0, list.size() );
	}

	@Test
	public void testAddLast() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAllCollection() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAllIntCollection() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIntObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddIntObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testIndexOfObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testLastIndexOfObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testListIteratorInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInt1() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIntE() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddIntE() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveInt1() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAllIntCollectionOfQextendsE() {
		fail("Not yet implemented");
	}

	@Test
	public void testListIteratorInt1() {
		fail("Not yet implemented");
	}

	@Test
	public void testAbstractSequentialList() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddE() {
		fail("Not yet implemented");
	}

	@Test
	public void testAbstractList() {
		fail("Not yet implemented");
	}

	@Test
	public void testIndexOfObject1() {
		fail("Not yet implemented");
	}

	@Test
	public void testLastIndexOfObject1() {
		fail("Not yet implemented");
	}

	@Test
	public void testListIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubList() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveRange() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAbstractCollection() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsObject1() {
		fail("Not yet implemented");
	}

	@Test
	public void testToArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testToArrayTArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveObject1() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAllCollectionOfQextendsE() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetainAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}
	
	private LinkedList list;
}
