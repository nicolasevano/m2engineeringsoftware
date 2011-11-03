package com.sun.demo.addressbook;

import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;

public class SaveButtonOnlyAvailableIfNewButtonClickedBefore extends
		UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public SaveButtonOnlyAvailableIfNewButtonClickedBefore() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Main test method.
	 */
	public void testSaveButtonOnlyAvailableIfNewButtonClickedBefore()
			throws Exception {
		IUIContext ui = getUI();
		ui.assertThat(new JButtonLocator("Save").isEnabled(false));
		ui.click(new JButtonLocator("New"));
		ui.assertThat(new JButtonLocator("Save").isEnabled(true));
	}

}