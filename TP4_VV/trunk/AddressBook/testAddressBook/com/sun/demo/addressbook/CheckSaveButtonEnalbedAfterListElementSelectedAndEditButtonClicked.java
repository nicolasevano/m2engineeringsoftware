package com.sun.demo.addressbook;

import com.windowtester.runtime.swing.locator.JListLocator;
import com.windowtester.runtime.swing.locator.NamedWidgetLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.locator.JButtonLocator;

public class CheckSaveButtonEnalbedAfterListElementSelectedAndEditButtonClicked
		extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public CheckSaveButtonEnalbedAfterListElementSelectedAndEditButtonClicked() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Main test method.
	 */
	public void testCheckSaveButtonEnalbedAfterListElementSelectedAndEditButtonClicked()
			throws Exception {
		IUIContext ui = getUI();
		ui.click(new JListLocator("toto, tutu", new NamedWidgetLocator("JListAddress")));
		ui.click(new JButtonLocator("Edit"));
		ui.assertThat( new JButtonLocator("Save").isEnabled( true ) );
	}

}