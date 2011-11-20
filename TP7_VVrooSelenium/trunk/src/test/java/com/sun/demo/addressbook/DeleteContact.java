package com.sun.demo.addressbook;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class DeleteContact extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testDeleteContact() throws Exception {
		selenium.open("/addressbook-0.1.0.BUILD-SNAPSHOT/");
		selenium.click("link=List all Domain Addresses");
		selenium.waitForPageToLoad("30000");
		selenium.click("//tr[2]/td[9]/form/input[2]");
		assertTrue(selenium.getConfirmation().matches("^Are you sure want to delete this item[\\s\\S]$"));
		selenium.click("link=List all Domain Addresses");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='_title_pl_com_sun_demo_addressbook_DomainAddress_id_pane']/table/tbody/tr[2]/td[8]/a/img");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=_firstname_id", "tata");
		selenium.click("id=proceed");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
