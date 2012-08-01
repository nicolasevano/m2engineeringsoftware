
package com.sodifrance.stage.esb.mule.conditional;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getAllArticleConditional complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getAllArticleConditional">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllArticleConditional", propOrder = {
    "wantedkind"
})
public class GetAllArticleConditional {

    @XmlElement(required = true)
    protected String wantedkind;

    /**
     * Obtient la valeur de la propri�t� kind.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWantedkind() {
        return wantedkind;
    }

    /**
     * D�finit la valeur de la propri�t� kind.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWantedkind(String value) {
        this.wantedkind = value;
    }

}
