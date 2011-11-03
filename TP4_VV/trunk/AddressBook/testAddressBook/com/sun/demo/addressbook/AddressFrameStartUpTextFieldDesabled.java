package com.sun.demo.addressbook;

import com.windowtester.runtime.swing.locator.LabeledTextLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.locator.NamedWidgetLocator;
import com.windowtester.runtime.swing.locator.JTextComponentLocator;
import javax.swing.JTextField;
import com.windowtester.runtime.swing.SwingWidgetLocator;

public class AddressFrameStartUpTextFieldDesabled extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public AddressFrameStartUpTextFieldDesabled() {
		super(com.sun.demo.addressbook.AddressFrame.class);
	}
	
	@Override 
	protected void setUp() throws Exception {
		super.setUp();
		//additional setup here
  	}
	@Override 
	protected void tearDown() throws Exception {
		//additional teardown here
		super.tearDown();
  	}
	
	/**
	 * Main test method.
	 */
	public void testAddressFrameStartUpTextFieldDesabled() throws Exception {
		IUIContext ui = getUI();
		ui.click(new LabeledTextLocator("Last Name"));
		ui.assertThat(new LabeledTextLocator("Last Name").isEnabled(false));
		ui.click(new LabeledTextLocator("Phone"));
		ui.assertThat(new LabeledTextLocator("Phone").isEnabled(false));
		ui.click(new LabeledTextLocator("Address 1"));
		ui.assertThat(new LabeledTextLocator("Address 1").isEnabled(false));
		ui.click(new LabeledTextLocator("Address 2"));
		ui.assertThat(new LabeledTextLocator("Address 2").isEnabled(false));
		ui.click(new LabeledTextLocator("City"));
		ui.assertThat(new LabeledTextLocator("City").isEnabled(false));
		ui.assertThat(new NamedWidgetLocator("frame0").isEnabled(false));
		ui.click(new JTextComponentLocator(JTextField.class, 3,
				new SwingWidgetLocator("AddressPanel")));
		//ui.assertThat(new JTextComponentLocator(JTextField.class)
		//		.isEnabled(false));
		ui.click(new LabeledTextLocator("Country"));
		ui.assertThat(new LabeledTextLocator("Country").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("First Name").isEnabled(false));
		ui.assertThat(new LabeledTextLocator("Email").isEnabled(false));
		ui.click(new LabeledTextLocator("Middle Name"));
		ui.assertThat(new LabeledTextLocator("Middle Name").isEnabled(false));
		//ui.assertThat(new JTextComponentLocator(JTextField.class)
		//		.isEnabled(false));
		assert_1();
	}

	protected void assert_1() throws Exception {
		// TODO Auto-generated method stub
		testAddressFrameStartUpTextFieldDesabled();
	}
	
}