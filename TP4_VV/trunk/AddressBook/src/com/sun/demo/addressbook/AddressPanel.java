/*
 * AddressPanel.java
 *
 * Copyright 2006 Sun Microsystems, Inc. ALL RIGHTS RESERVED Use of 
 * this software is authorized pursuant to the terms of the license 
 * found at http://developers.sun.com/berkeley_license.html .
 *
 */

package com.sun.demo.addressbook;

import java.awt.event.ActionListener;

/**
 * 
 * @author John O'Conner
 */
public class AddressPanel extends javax.swing.JPanel {

	/** Creates new form AddressPanel */
	public AddressPanel() {
		initComponents();
		address = new Address();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
	// desc=" Generated Code ">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		lblAddress1 = new javax.swing.JLabel();
		txtAddress1 = new javax.swing.JTextField();
		lblAddress2 = new javax.swing.JLabel();
		txtAddress2 = new javax.swing.JTextField();
		lblCity = new javax.swing.JLabel();
		txtCity = new javax.swing.JTextField();
		txtState = new javax.swing.JTextField();
		txtPostalCode = new javax.swing.JTextField();
		lblState = new javax.swing.JLabel();
		lblPostalCode = new javax.swing.JLabel();
		lblLastName = new javax.swing.JLabel();
		txtLastName = new javax.swing.JTextField();
		lblFirstName = new javax.swing.JLabel();
		txtFirstName = new javax.swing.JTextField();
		lblMiddleName = new javax.swing.JLabel();
		txtMiddleName = new javax.swing.JTextField();
		lblPhone = new javax.swing.JLabel();
		txtPhone = new javax.swing.JTextField();
		lblEmail = new javax.swing.JLabel();
		txtEmail = new javax.swing.JTextField();
		lblCountry = new javax.swing.JLabel();
		txtCountry = new javax.swing.JTextField();

		setLayout(new java.awt.GridBagLayout());

		lblAddress1.setText("Address 1");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(lblAddress1, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(txtAddress1, gridBagConstraints);

		lblAddress2.setText("Address 2");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(lblAddress2, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(txtAddress2, gridBagConstraints);

		lblCity.setText("City");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(lblCity, gridBagConstraints);

		txtCity.setMinimumSize(new java.awt.Dimension(100, 21));
		txtCity.setPreferredSize(new java.awt.Dimension(100, 21));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(txtCity, gridBagConstraints);

		txtState.setMinimumSize(new java.awt.Dimension(30, 21));
		txtState.setPreferredSize(new java.awt.Dimension(30, 21));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(txtState, gridBagConstraints);

		txtPostalCode.setMinimumSize(new java.awt.Dimension(80, 21));
		txtPostalCode.setPreferredSize(new java.awt.Dimension(80, 21));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(txtPostalCode, gridBagConstraints);

		lblState.setText("State");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(lblState, gridBagConstraints);

		lblPostalCode.setText("ZIP");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(lblPostalCode, gridBagConstraints);

		lblLastName.setText("Last Name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(lblLastName, gridBagConstraints);

		txtLastName.setMinimumSize(new java.awt.Dimension(100, 21));
		txtLastName.setPreferredSize(new java.awt.Dimension(100, 21));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(txtLastName, gridBagConstraints);

		lblFirstName.setText("First Name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(lblFirstName, gridBagConstraints);

		txtFirstName.setMinimumSize(new java.awt.Dimension(80, 21));
		txtFirstName.setPreferredSize(new java.awt.Dimension(80, 21));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(txtFirstName, gridBagConstraints);

		lblMiddleName.setText("Middle Name");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(lblMiddleName, gridBagConstraints);

		txtMiddleName.setMinimumSize(new java.awt.Dimension(80, 21));
		txtMiddleName.setPreferredSize(new java.awt.Dimension(80, 21));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(txtMiddleName, gridBagConstraints);

		lblPhone.setText("Phone");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(lblPhone, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(txtPhone, gridBagConstraints);

		lblEmail.setText("Email");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(lblEmail, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(txtEmail, gridBagConstraints);

		lblCountry.setText("Country");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(lblCountry, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		add(txtCountry, gridBagConstraints);

	}// </editor-fold>//GEN-END:initComponents

	void setLastName(String lastName) {
		address.setLastName(lastName);
		txtLastName.setText(lastName);
	}

	String getLastName() {
		String lastName = txtLastName.getText();
		address.setLastName(lastName);
		return lastName;
	}

	void setFirstName(String firstName) {
		address.setFirstName(firstName);
		txtFirstName.setText(firstName);

	}

	String getFirstName() {
		String firstName = txtFirstName.getText();
		address.setFirstName(firstName);
		return firstName;
	}

	void setMiddleName(String middleName) {
		address.setMiddleName(middleName);
		txtMiddleName.setText(middleName);
	}

	String getMiddleName() {
		String middleName = txtMiddleName.getText();
		address.setMiddleName(middleName);
		return middleName;
	}

	void setPhone(String phone) {
		address.setPhone(phone);
		txtPhone.setText(phone);
	}

	String getPhone() {
		String phone = txtPhone.getText();
		address.setPhone(phone);
		return phone;
	}

	void setEmail(String email) {
		address.setEmail(email);
		txtEmail.setText(email);
	}

	String getEmail() {
		String email = txtEmail.getText();
		address.setEmail(email);
		return email;
	}

	void setAddress1(String address1) {
		address.setAddress1(address1);
		txtAddress1.setText(address1);
	}

	String getAddress1() {
		String address1 = txtAddress1.getText();
		address.setAddress1(address1);
		return address1;
	}

	void setAddress2(String address2) {
		address.setAddress2(address2);
		txtAddress2.setText(address2);
	}

	String getAddress2() {
		String address2 = txtAddress2.getText();
		address.setAddress2(address2);
		return address2;
	}

	void setCity(String city) {
		address.setCity(city);
		txtCity.setText(city);
	}

	String getCity() {
		String city = txtCity.getText();
		address.setCity(city);
		return city;
	}

	void setState(String state) {
		address.setState(state);
		txtState.setText(state);
	}

	String getState() {
		String state = txtState.getText();
		address.setState(state);
		return state;
	}

	void setPostalCode(String postalCode) {
		address.setPostalCode(postalCode);
		txtPostalCode.setText(postalCode);
	}

	String getPostalCode() {
		String postalCode = txtPostalCode.getText();
		address.setPostalCode(postalCode);
		return postalCode;
	}

	void setCountry(String country) {
		address.setCountry(country);
		txtCountry.setText(country);
	}

	String getCountry() {
		String country = txtCountry.getText();
		address.setCountry(country);
		return country;
	}

	void setId(int id) {
		address.setId(id);
		this.id = id;
	}

	int getId() {
		int id = this.id;
		address.setId(id);
		return id;
	}

	public void setAddress(Address address) {
		if (address != null) {
			setLastName(address.getLastName());
			setFirstName(address.getFirstName());
			setMiddleName(address.getMiddleName());
			setPhone(address.getPhone());
			setEmail(address.getEmail());
			setAddress1(address.getAddress1());
			setAddress2(address.getAddress2());
			setCity(address.getCity());
			setState(address.getState());
			setPostalCode(address.getPostalCode());
			setCountry(address.getCountry());
			setId(address.getId());
		}
	}

	public Address getAddress() {
		getLastName();
		getFirstName();
		getMiddleName();
		getPhone();
		getEmail();
		getAddress1();
		getAddress2();
		getCity();
		getState();
		getPostalCode();
		getCountry();
		getId();
		return address;
	}

	public void clear() {
		txtLastName.setText(null);
		txtMiddleName.setText(null);
		txtFirstName.setText(null);
		txtPhone.setText(null);
		txtEmail.setText(null);
		txtAddress1.setText(null);
		txtAddress2.setText(null);
		txtCity.setText(null);
		txtState.setText(null);
		txtPostalCode.setText(null);
		txtCountry.setText(null);
		id = -1;
		address = new Address();
	}

	public void setEditable(boolean bEditable) {
		txtFirstName.setEnabled(bEditable);
		txtLastName.setEnabled(bEditable);
		txtMiddleName.setEnabled(bEditable);
		txtAddress1.setEnabled(bEditable);
		txtAddress2.setEnabled(bEditable);
		txtCity.setEnabled(bEditable);
		txtState.setEnabled(bEditable);
		txtPostalCode.setEnabled(bEditable);
		txtCountry.setEnabled(bEditable);
		txtPhone.setEnabled(bEditable);
		txtEmail.setEnabled(bEditable);

		txtFirstName.setEditable(bEditable);
		txtLastName.setEditable(bEditable);
		txtMiddleName.setEditable(bEditable);
		txtAddress1.setEditable(bEditable);
		txtAddress2.setEditable(bEditable);
		txtCity.setEditable(bEditable);
		txtState.setEditable(bEditable);
		txtPostalCode.setEditable(bEditable);
		txtCountry.setEditable(bEditable);
		txtPhone.setEditable(bEditable);
		txtEmail.setEditable(bEditable);
		isEditable = bEditable;

	}

	public boolean isEditable() {
		return isEditable;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel lblAddress1;
	private javax.swing.JLabel lblAddress2;
	private javax.swing.JLabel lblCity;
	private javax.swing.JLabel lblCountry;
	private javax.swing.JLabel lblEmail;
	private javax.swing.JLabel lblFirstName;
	private javax.swing.JLabel lblLastName;
	private javax.swing.JLabel lblMiddleName;
	private javax.swing.JLabel lblPhone;
	private javax.swing.JLabel lblPostalCode;
	private javax.swing.JLabel lblState;
	private javax.swing.JTextField txtAddress1;
	private javax.swing.JTextField txtAddress2;
	private javax.swing.JTextField txtCity;
	private javax.swing.JTextField txtCountry;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtFirstName;
	private javax.swing.JTextField txtLastName;
	private javax.swing.JTextField txtMiddleName;
	private javax.swing.JTextField txtPhone;
	private javax.swing.JTextField txtPostalCode;
	private javax.swing.JTextField txtState;
	// End of variables declaration//GEN-END:variables
	int id;
	boolean isEditable;
	Address address;

}
