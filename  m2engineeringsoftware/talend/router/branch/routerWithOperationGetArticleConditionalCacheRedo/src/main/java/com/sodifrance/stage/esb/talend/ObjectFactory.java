
package com.sodifrance.stage.esb.talend;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.sodifrance.stage.esb.talend.conditional.ArticleConditional;
import com.sodifrance.stage.esb.talend.conditional.GetAllArticleConditional;
import com.sodifrance.stage.esb.talend.conditional.GetAllArticleConditionalResponse;
import com.sodifrance.stage.esb.talend.conditional.GetArticleConditional;
import com.sodifrance.stage.esb.talend.conditional.GetArticleConditionalResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sodifrance.stage.esb.talend package. 
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

    private final static QName _GetAllArticleResponse_QNAME = new QName("http://talend.esb.stage.sodifrance.com/", "getAllArticleResponse");
    private final static QName _GetAllArticle_QNAME = new QName("http://talend.esb.stage.sodifrance.com/", "getAllArticle");
    private final static QName _GetAllArticleConditionalResponse_QNAME = new QName("http://conditional.talend.esb.stage.sodifrance.com/", "getAllArticleConditionalResponse");
    private final static QName _GetAllArticleConditional_QNAME = new QName("http://conditional.talend.esb.stage.sodifrance.com/", "getAllArticleConditional");
    private final static QName _GetArticleConditionalResponse_QNAME = new QName("http://conditional.talend.esb.stage.sodifrance.com/", "getArticleConditionalResponse");
    private final static QName _GetArticleConditional_QNAME = new QName("http://conditional.talend.esb.stage.sodifrance.com/", "getArticleConditional");
    
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sodifrance.stage.esb.talend
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
    @XmlElementDecl(namespace = "http://talend.esb.stage.sodifrance.com/", name = "getAllArticleResponse")
    public JAXBElement<GetAllArticleResponse> createGetAllArticleResponse(GetAllArticleResponse value) {
        return new JAXBElement<GetAllArticleResponse>(_GetAllArticleResponse_QNAME, GetAllArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllArticle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://talend.esb.stage.sodifrance.com/", name = "getAllArticle")
    public JAXBElement<GetAllArticle> createGetAllArticle(GetAllArticle value) {
        return new JAXBElement<GetAllArticle>(_GetAllArticle_QNAME, GetAllArticle.class, null, value);
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
    @XmlElementDecl(namespace = "http://conditional.talend.esb.stage.sodifrance.com/", name = "getAllArticleConditionalResponse")
    public JAXBElement<GetAllArticleConditionalResponse> createGetAllArticleConditionalResponse(GetAllArticleConditionalResponse value) {
        return new JAXBElement<GetAllArticleConditionalResponse>(_GetAllArticleConditionalResponse_QNAME, GetAllArticleConditionalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllArticleConditional }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conditional.talend.esb.stage.sodifrance.com/", name = "getAllArticleConditional")
    public JAXBElement<GetAllArticleConditional> createGetAllArticleConditional(GetAllArticleConditional value) {
        return new JAXBElement<GetAllArticleConditional>(_GetAllArticleConditional_QNAME, GetAllArticleConditional.class, null, value);
    }
    
    /**
     * Create an instance of {@link GetAllArticleConditional }
     * 
     */
    public GetArticleConditional createGetArticleConditional() {
        return new GetArticleConditional();
    }

    /**
     * Create an instance of {@link GetAllArticleConditionalResponse }
     * 
     */
    public GetArticleConditionalResponse createGetArticleConditionalResponse() {
        return new GetArticleConditionalResponse();
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllArticleConditionalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conditional.talend.esb.stage.sodifrance.com/", name = "getArticleConditionalResponse")
    public JAXBElement<GetArticleConditionalResponse> createGetArticleConditionalResponse(GetArticleConditionalResponse value) {
        return new JAXBElement<GetArticleConditionalResponse>(_GetArticleConditionalResponse_QNAME, GetArticleConditionalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllArticleConditional }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conditional.talend.esb.stage.sodifrance.com/", name = "getArticleConditional")
    public JAXBElement<GetArticleConditional> createGetArticleConditional(GetArticleConditional value) {
        return new JAXBElement<GetArticleConditional>(_GetArticleConditional_QNAME, GetArticleConditional.class, null, value);
    }

}
