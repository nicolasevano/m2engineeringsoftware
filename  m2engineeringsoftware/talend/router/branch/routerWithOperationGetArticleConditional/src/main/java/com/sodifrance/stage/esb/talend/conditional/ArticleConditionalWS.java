package com.sodifrance.stage.esb.talend.conditional;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.0
 * 2012-06-14T12:19:00.163+02:00
 * Generated source version: 2.6.0
 * 
 */
@WebService(targetNamespace = "http://conditional.talend.esb.stage.sodifrance.com/", name = "ArticleConditionalWS")
public interface ArticleConditionalWS {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getAllArticleConditional", targetNamespace = "http://conditional.talend.esb.stage.sodifrance.com/", className = "com.sodifrance.stage.esb.talend.conditional.GetAllArticleConditional")
    @WebMethod(action = "urn:getAllArticleConditional")
    @ResponseWrapper(localName = "getAllArticleConditionalResponse", targetNamespace = "http://conditional.talend.esb.stage.sodifrance.com/", className = "com.sodifrance.stage.esb.talend.conditional.GetAllArticleConditionalResponse")
    public java.util.List<com.sodifrance.stage.esb.talend.conditional.ArticleConditional> getAllArticleConditional(
        @WebParam(name = "wantedkind")
        java.lang.String kind
    );
    
    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getArticleConditional", targetNamespace = "http://conditional.talend.esb.stage.sodifrance.com/", className = "com.sodifrance.stage.esb.talend.conditional.GetArticleConditional")
    @WebMethod(action = "urn:getAllArticleConditional")
    @ResponseWrapper(localName = "getArticleConditionalResponse", targetNamespace = "http://conditional.talend.esb.stage.sodifrance.com/", className = "com.sodifrance.stage.esb.talend.conditional.GetArticleConditionalResponse")
    public java.util.List<com.sodifrance.stage.esb.talend.conditional.ArticleConditional> getArticleConditional(
        @WebParam(name = "wantedkind")
        java.lang.String kind,
        @WebParam(name = "wantedkind")
        java.lang.String id
    );
}
