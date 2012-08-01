
package com.sodifrance.stage.esb.mule;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
//import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;

/**
 * <p>Classe Java pour Article complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Article">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kind" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="cd"/>
 *               &lt;enumeration value="book"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="editor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publishDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Article", propOrder = {
    "author",
    "kind",
    "editor",
    "meta",
    "title",
    "publishDate",
    "releaseDate"
})
public class Article implements Serializable{
//		<xs:element minOccurs="0" name="author" type="xs:string"/>
//		<xs:element minOccurs="0" name="kind">
//			<xs:simpleType>
//			<xs:restriction base="xs:string">
//					<xs:enumeration value="cd"/>
//					<xs:enumeration value="book"/>
//			</xs:restriction>
//			</xs:simpleType>
//		</xs:element>
//		<xs:element minOccurs="0" name="editor" type="xs:string"/>
//		<xs:element minOccurs="0" name="meta" type="xs:string"/>
//		<xs:element minOccurs="0" name="title" type="xs:string"/>
//		<xs:element minOccurs="0" name="publishDate" type="xs:dateTime"/>
//		<xs:element minOccurs="0" name="releaseDate" type="xs:dateTime"/>
	
	/**
     * Obtient la valeur de la propriété author.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getAuthor() {
		return author;
	}
	/**
     * Définit la valeur de la propriété author.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
     * Obtient la valeur de la propriété kind.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getKind() {
		return kind;
	}
	/**
     * Définit la valeur de la propriété kind.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setKind(String kind) {
		this.kind = kind;
	}
	/**
     * Obtient la valeur de la propriété editor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getEditor() {
		return editor;
	}
	/**
     * Définit la valeur de la propriété editor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setEditor(String editor) {
		this.editor = editor;
	}
	/**
     * Obtient la valeur de la propriété meta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getMeta() {
		return meta;
	}
	/**
     * Définit la valeur de la propriété meta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setMeta(String meta) {
		this.meta = meta;
	}
	/**
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getTitle() {
		return title;
	}
	/**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
     * Obtient la valeur de la propriété publishDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
//	public XMLGregorianCalendar getPublishDate() {
//		return publishDate;
//	}
	public String getPublishDate() {
		return publishDate;
	}
	/**
     * Définit la valeur de la propriété publishDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
//    public void setPublishDate(XMLGregorianCalendar value) {
//        this.publishDate = value;
//    }
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	/**
     * Obtient la valeur de la propriété releaseDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
//	public XMLGregorianCalendar getReleaseDate() {
//		return releaseDate;
//	}
	public String getReleaseDate() {
		return releaseDate;
	}
	/**
     * Définit la valeur de la propriété releaseDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
//    public void setReleaseDate(XMLGregorianCalendar value) {
//        this.releaseDate = value;
//    }
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	private String author;
	private String kind;
	private String editor;
	private String meta;
	private String title;
	//@XmlSchemaType(name = "dateTime")
	private String publishDate;
	//@XmlSchemaType(name = "dateTime")
	private String releaseDate;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
