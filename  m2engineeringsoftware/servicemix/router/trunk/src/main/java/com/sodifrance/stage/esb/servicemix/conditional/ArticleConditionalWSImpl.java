
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.sodifrance.stage.esb.servicemix.conditional;

import java.util.logging.Logger;

/**
 * This class was generated by Apache CXF 2.6.0
 * 2012-06-14T12:19:00.099+02:00
 * Generated source version: 2.6.0
 * 
 */

@javax.jws.WebService(
                      serviceName = "ArticleConditionalWSImplService",
                      portName = "ArticleConditionalWSImplPort",
                      targetNamespace = "http://conditional.servicemix.esb.stage.sodifrance.com/",
                      wsdlLocation = "http://localhost:8085/ArticleConditionalWSImplPort?wsdl",
                      endpointInterface = "com.sodifrance.stage.esb.servicemix.conditional.ArticleConditionalWS")
                      
public class ArticleConditionalWSImpl implements ArticleConditionalWS {

    private static final Logger LOG = Logger.getLogger(ArticleConditionalWSImpl.class.getName());

    /* (non-Javadoc)
     * @see com.sodifrance.stage.esb.servicemix.conditional.ArticleConditionalWS#getAllArticleConditional(java.lang.String  kind )*
     */
    public java.util.List<com.sodifrance.stage.esb.servicemix.conditional.ArticleConditional> getAllArticleConditional(java.lang.String kind) { 
        LOG.info("Executing operation getAllArticleConditional");
        System.out.println(kind);
        try {
            java.util.List<com.sodifrance.stage.esb.servicemix.conditional.ArticleConditional> _return = new java.util.ArrayList<com.sodifrance.stage.esb.servicemix.conditional.ArticleConditional>();
            com.sodifrance.stage.esb.servicemix.conditional.ArticleConditional _returnVal1 = new com.sodifrance.stage.esb.servicemix.conditional.ArticleConditional();
            _returnVal1.setAuthor("Author-889754468");
            _returnVal1.setKind("Kind-85340724");
            _returnVal1.setEditor("Editor1367717262");
            _returnVal1.setMeta("Meta2051651139");
            _returnVal1.setTitle("Title1083248741");
            _returnVal1.setPublishDate("PublishDate-335569149");
            _returnVal1.setReleaseDate("ReleaseDate-523790698");
            _return.add(_returnVal1);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
