package com.sun.demo.addressbook;
import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;

public class DeleteDisabledAtStartupTest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public DeleteDisabledAtStartupTest() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Main test method.
	 */
	public void testDeleteDisabledAtStartup() throws Exception {
		IUIContext ui = getUI();
		ui.assertThat(new JButtonLocator("Delete").isEnabled(false));
	}

}