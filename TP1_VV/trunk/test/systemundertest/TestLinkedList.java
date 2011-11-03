package systemundertest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import systemundertest.LinkedList;


public class TestLinkedList {
	protected LinkedList list;
	
	@Before
	public void setUp(){
		list = new LinkedList();
	}
	
	@After
	public void tearDown(){
		list = null;
	}
	
	
	@Test
	public void testSize(){
		assertEquals( "test de la méthode size avec aucun element dans la liste", 
					  0, list.size() );
	}
	
	//test de la methode remove(Object) 
	//sur une liste a 1 element
	@Test
	public void testRemove(){
		Object o = new Object();
		list.add(o);
		list.remove(o);
		assertEquals( "test de la méthode Remove", 
						0, list.size() );
	}
	
	@Test
	public void testAdd(){
		Object o = new Object();
		list.add(o);
		assertEquals( "test de la méthode add aprés ajout d'un element", 
						1, list.size() );
	}
	
	
	
	

		
	
	
}
