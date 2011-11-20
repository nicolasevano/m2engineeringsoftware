package com.sun.demo.addressbook.web;

import com.sun.demo.addressbook.DomainAddress;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "domainaddresses", formBackingObject = DomainAddress.class)
@RequestMapping("/domainaddresses")
@Controller
public class DomainAddressController {
}
