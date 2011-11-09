package com.sun.demo.addressbook;

import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.locator.LabeledTextLocator;
import java.awt.event.KeyEvent;
import com.windowtester.runtime.WT;
import com.windowtester.runtime.swing.locator.JListLocator;
import com.windowtester.runtime.swing.condition.WindowDisposedCondition;

public class ItemSelectedWhenDeleteTest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public ItemSelectedWhenDeleteTest() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Main test method.
	 */
	public void testItemSelectedWhenDelete() throws Exception {
		IUIContext ui = getUI();
		ui.click(new JButtonLocator("New"));
		ui.click(new LabeledTextLocator("Last Name"));
		ui.enterText("Cadavid");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Juan");
		ui.click(new JButtonLocator("Save"));
		ui.click(new JListLocator("Cadavid, Juan"));
		ui.assertThat(new JButtonLocator("Delete").isEnabled(true));
	}

	public void testItemSelectedWhenDeleteNegative() throws Exception {
		IUIContext ui = getUI();

		ui.click(new JButtonLocator("New"));
		ui.click(new LabeledTextLocator("Last Name"));
		ui.enterText("Cadavid");
		ui.keyClick(KeyEvent.VK_TAB);
		ui.enterText("Juan");
		ui.click(new JButtonLocator("Save"));
		ui.click(new JListLocator("Cadavid, Juan"));
		try {
			ui.assertThat(new JButtonLocator("Delete").isEnabled(false));
			fail("Delete should be enabled, since there is a selected item");
		} catch (Exception e) {

		}
	}

}