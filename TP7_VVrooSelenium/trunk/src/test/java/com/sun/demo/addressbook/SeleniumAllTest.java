package com.sun.demo.addressbook;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SeleniumAllTest {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(AddContact.class);
		suite.addTestSuite(AfterAddUpdateContact.class);
		suite.addTestSuite(DeleteContact.class);
		return suite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
