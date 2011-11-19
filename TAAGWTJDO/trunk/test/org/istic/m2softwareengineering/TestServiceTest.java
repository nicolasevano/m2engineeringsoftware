package org.istic.m2softwareengineering;

import org.istic.m2softwareengineering.client.RLatitudeService;

import com.gdevelop.gwt.syncrpc.SyncProxy;

import junit.framework.TestCase;

public class TestServiceTest extends TestCase {

	private static RLatitudeService testService;
	
	protected void setUp() throws Exception {
		super.setUp();
		testService = (RLatitudeService) SyncProxy.newProxyInstance(RLatitudeService.class,
		          "http://localhost/taagwtlattitude", "test");
	}

	public void testAddContactData() throws Exception{
		String result = testService.sayHello();
	    assertTrue((result != null) && ("hello".equals(result)));
	}
	
	protected void tearDown() throws Exception {
		testService = null;
	}

}
