package com.sodifrance.stage.esb.mule.conditional;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Classe Java pour getArticleConditional complex type.
 * 
 * <p>Le fragment de schema suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getArticleConditional">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getArticleConditional", propOrder = {
    "wantedkind","id"
})
public class GetArticleConditional {

	@XmlElement( required = true )
    protected String wantedkind;
	
	@XmlElement( required = true )
    protected String id;

    /**
     * Obtient la valeur de la propriete kind.
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
     * Definit la valeur de la propriete kind.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWantedkind(String value) {
        this.wantedkind = value;
    }
    
    /**
     * Obtient la valeur de la propriete id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Definit la valeur de la propriete id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }
    
}
