package com.sodifrance.stage.esb.talend;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.sodifrance.stage.esb.talend.PossibleArticle;



/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sodifrance.stage.esb.servicemix package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {
	
	private final static QName _PossibleArticle_QNAME = new QName("http://talend.esb.stage.sodifrance.com/", "item");
	//private final static QName _Article_QNAME = new QName("http://servicemix.esb.stage.sodifrance.com/", "item");
	
	/**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sodifrance.stage.esb.servicemix
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Article }
     * 
     */
    @XmlElementDecl(namespace = "http://talend.esb.stage.sodifrance.com/", name = "item")
    public JAXBElement<PossibleArticle> createPossibleArticle(PossibleArticle value) {
    	return new JAXBElement<PossibleArticle>(_PossibleArticle_QNAME, PossibleArticle.class, null, value);
    }
    
    /**
     * Create an instance of {@link Article }
     * 
     */
//    @XmlElementDecl(namespace = "http://talend.esb.stage.sodifrance.com/", name = "item")
//    public JAXBElement<Article> createArticle(Article value) {
//    	return new JAXBElement<Article>(_Article_QNAME, Article.class, null, value);
//    }
    
}
