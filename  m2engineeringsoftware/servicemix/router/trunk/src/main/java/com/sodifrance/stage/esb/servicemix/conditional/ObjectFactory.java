
package com.sodifrance.stage.esb.servicemix.conditional;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sodifrance.stage.esb.servicemix.conditional package. 
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

    private final static QName _GetAllArticleConditionalResponse_QNAME = new QName("http://conditional.servicemix.esb.stage.sodifrance.com/", "getAllArticleConditionalResponse");
    private final static QName _GetAllArticleConditional_QNAME = new QName("http://conditional.servicemix.esb.stage.sodifrance.com/", "getAllArticleConditional");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sodifrance.stage.esb.servicemix.conditional
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllArticleConditional }
     * 
     */
    public GetAllArticleConditional createGetAllArticleConditional() {
        return new GetAllArticleConditional();
    }

    /**
     * Create an instance of {@link GetAllArticleConditionalResponse }
     * 
     */
    public GetAllArticleConditionalResponse createGetAllArticleConditionalResponse() {
        return new GetAllArticleConditionalResponse();
    }

    /**
     * Create an instance of {@link ArticleConditional }
     * 
     */
    public ArticleConditional createArticleConditional() {
        return new ArticleConditional();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllArticleConditionalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conditional.servicemix.esb.stage.sodifrance.com/", name = "getAllArticleConditionalResponse")
    public JAXBElement<GetAllArticleConditionalResponse> createGetAllArticleConditionalResponse(GetAllArticleConditionalResponse value) {
        return new JAXBElement<GetAllArticleConditionalResponse>(_GetAllArticleConditionalResponse_QNAME, GetAllArticleConditionalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllArticleConditional }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conditional.servicemix.esb.stage.sodifrance.com/", name = "getAllArticleConditional")
    public JAXBElement<GetAllArticleConditional> createGetAllArticleConditional(GetAllArticleConditional value) {
        return new JAXBElement<GetAllArticleConditional>(_GetAllArticleConditional_QNAME, GetAllArticleConditional.class, null, value);
    }

}
