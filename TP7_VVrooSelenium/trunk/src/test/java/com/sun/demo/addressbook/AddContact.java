package com.sun.demo.addressbook;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class AddContact extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testAddContact() throws Exception {
		selenium.open("/addressbook-0.1.0.BUILD-SNAPSHOT/");
		selenium.click("link=Create new Domain Address");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=_lastname_id");
		selenium.type("id=_lastname_id", "toto");
		selenium.type("id=_firstname_id", "toto");
		selenium.type("id=_middlename_id", "toto");
		selenium.type("id=_phone_id", "toto");
		selenium.type("id=_email_id", "toto@gmail");
		selenium.type("id=_phone_id", "23123142545");
		selenium.click("id=_address1_id");
		selenium.type("id=_address1_id", "1 rue test");
		selenium.type("id=_city_id", "ailleur");
		selenium.click("id=_addressState_id");
		selenium.type("id=_addressState_id", "bretagne");
		selenium.type("id=_postalCode_id", "3500");
		selenium.type("id=_country_id", "France");
		selenium.click("id=proceed");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
