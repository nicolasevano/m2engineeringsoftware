package test.sensor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sensor.EntryVersion;

public class EntryVersionTest {

	private EntryVersion entryVersion;
	@Before
	public void setUp() throws Exception {
		entryVersion = new EntryVersion(1,2,3);
	}

	@After
	public void tearDown() throws Exception {
		entryVersion = null;
	}

	@Test
	public void decreaseTTLTest(){
		assertTrue( entryVersion.isUpTodate() );
		entryVersion.decreaseTTL();
		entryVersion.decreaseTTL();
		entryVersion.decreaseTTL();
		entryVersion.decreaseTTL();
		assertFalse( entryVersion.isUpTodate() );
	}
	
	@Test
	public void isUpTodateTest(){
		assertTrue( entryVersion.isUpTodate() );
		entryVersion.decreaseTTL();
		entryVersion.decreaseTTL();
		entryVersion.decreaseTTL();
		entryVersion.decreaseTTL();
		assertFalse( entryVersion.isUpTodate() );
	}

}
