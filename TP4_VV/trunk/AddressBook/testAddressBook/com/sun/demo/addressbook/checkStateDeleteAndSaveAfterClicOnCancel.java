package com.sun.demo.addressbook;

import com.windowtester.runtime.swing.locator.JListLocator;
import com.windowtester.runtime.swing.locator.NamedWidgetLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.locator.JButtonLocator;

public class checkStateDeleteAndSaveAfterClicOnCancel extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public checkStateDeleteAndSaveAfterClicOnCancel() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Main test method.
	 */
	public void testcheckStateDeleteAndSaveAfterClicOnCancel() throws Exception {
		IUIContext ui = getUI();
		ui.click(new JListLocator("toto, tutu", new NamedWidgetLocator(
				"JListAddress")));
		ui.click(new JButtonLocator("Edit"));
		ui.click(new JButtonLocator("Cancel"));
		ui.assertThat(new JButtonLocator("Delete").isEnabled(false));
		ui.assertThat(new JButtonLocator("Save").isEnabled(false));
	}

}