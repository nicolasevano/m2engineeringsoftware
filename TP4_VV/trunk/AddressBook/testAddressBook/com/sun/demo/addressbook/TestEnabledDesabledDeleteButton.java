package com.sun.demo.addressbook;

import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.locator.JListLocator;
import com.windowtester.runtime.swing.locator.NamedWidgetLocator;

public class TestEnabledDesabledDeleteButton extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public TestEnabledDesabledDeleteButton() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Main test method.
	 */
	public void testTestEnabledDesabledDeleteButton() throws Exception {
		
		IUIContext ui = getUI();
		ui.assertThat( new JButtonLocator( "Delete" ).isEnabled( false ) );
		ui.click( new JListLocator("Sylvie, Auneau", new NamedWidgetLocator( "JListAddress" ) ) );
		ui.assertThat( new JButtonLocator( "Delete" ).isEnabled( true ) );
		
	}

}