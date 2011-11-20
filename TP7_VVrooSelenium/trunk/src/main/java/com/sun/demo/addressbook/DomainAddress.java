package com.sun.demo.addressbook;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class DomainAddress {

    private String lastname;

    private String firstname;

    private String middlename;

    private String phone;

    private String email;

    private String address1;

    private String address2;

    private String city;

    private String addressState;

    private String postalCode;

    private String country;
}
