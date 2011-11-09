package com.sun.demo.addressbook;
import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
/**
 * 
 * @author Juan
 *
 */
public class SaveDisabledAfterNewTest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public SaveDisabledAfterNewTest() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}

	/**
	 * Main test method.
	 */
	public void testSaveDisabledAfterNew() throws Exception {
		IUIContext ui = getUI();
		ui.click(new JButtonLocator("New"));
		ui.assertThat(new JButtonLocator("Save").isEnabled(false));
	}

}