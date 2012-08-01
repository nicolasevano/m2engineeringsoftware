
package com.sodifrance.stage.esb.mule;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


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

    private final static QName _GetAllArticleResponse_QNAME = new QName("http://servicemix.esb.stage.sodifrance.com/", "getAllArticleResponse");
    private final static QName _GetAllArticle_QNAME = new QName("http://servicemix.esb.stage.sodifrance.com/", "getAllArticle");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sodifrance.stage.esb.servicemix
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllArticle }
     * 
     */
    public GetAllArticle createGetAllArticle() {
        return new GetAllArticle();
    }

    /**
     * Create an instance of {@link GetAllArticleResponse }
     * 
     */
    public GetAllArticleResponse createGetAllArticleResponse() {
        return new GetAllArticleResponse();
    }

    /**
     * Create an instance of {@link Article }
     * 
     */
    public Article createArticle() {
        return new Article();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllArticleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemix.esb.stage.sodifrance.com/", name = "getAllArticleResponse")
    public JAXBElement<GetAllArticleResponse> createGetAllArticleResponse(GetAllArticleResponse value) {
        return new JAXBElement<GetAllArticleResponse>(_GetAllArticleResponse_QNAME, GetAllArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicemix.esb.stage.sodifrance.com/", name = "getAllArticle")
    public JAXBElement<GetAllArticle> createGetAllArticle(GetAllArticle value) {
        return new JAXBElement<GetAllArticle>(_GetAllArticle_QNAME, GetAllArticle.class, null, value);
    }

}
