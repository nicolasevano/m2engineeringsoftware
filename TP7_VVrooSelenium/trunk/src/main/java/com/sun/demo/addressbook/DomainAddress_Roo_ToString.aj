// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sun.demo.addressbook;

import java.lang.String;

privileged aspect DomainAddress_Roo_ToString {
    
    public String DomainAddress.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address1: ").append(getAddress1()).append(", ");
        sb.append("Address2: ").append(getAddress2()).append(", ");
        sb.append("AddressState: ").append(getAddressState()).append(", ");
        sb.append("City: ").append(getCity()).append(", ");
        sb.append("Country: ").append(getCountry()).append(", ");
        sb.append("Email: ").append(getEmail()).append(", ");
        sb.append("Firstname: ").append(getFirstname()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Lastname: ").append(getLastname()).append(", ");
        sb.append("Middlename: ").append(getMiddlename()).append(", ");
        sb.append("Phone: ").append(getPhone()).append(", ");
        sb.append("PostalCode: ").append(getPostalCode()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}