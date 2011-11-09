package com.sun.demo.addressbook;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(ItemSelectedWhenDeleteTest.class);
		suite.addTestSuite(FieldsDisabledStartupTest.class);
		suite.addTestSuite(FieldsEnabledAfterNewTest.class);
		suite.addTestSuite(SaveDisabledAfterNewTest.class);
		suite.addTestSuite(DeleteDisabledAtStartupTest.class);
		//$JUnit-END$
		return suite;
	}

}
