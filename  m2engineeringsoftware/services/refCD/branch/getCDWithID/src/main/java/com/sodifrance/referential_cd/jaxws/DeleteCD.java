
package com.sodifrance.referential_cd.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.0
 * Mon May 14 12:06:07 CEST 2012
 * Generated source version: 2.6.0
 */

@XmlRootElement(name = "deleteCD", namespace = "http://referential_cd.sodifrance.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteCD", namespace = "http://referential_cd.sodifrance.com/")

public class DeleteCD {

    @XmlElement(name = "arg0")
    private com.sodifrance.referential_cd.CD arg0;

    public com.sodifrance.referential_cd.CD getArg0() {
        return this.arg0;
    }

    public void setArg0(com.sodifrance.referential_cd.CD newArg0)  {
        this.arg0 = newArg0;
    }

}
