package com.sodifrance.stage.esb.servicemix;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.0
 * 2012-05-21T17:45:05.672+02:00
 * Generated source version: 2.6.0
 * 
 */
@WebServiceClient(name = "ArticleWSImplService", 
                  wsdlLocation = "http://localhost:8085/ArticleWSImplPort?wsdl",
                  targetNamespace = "http://servicemix.esb.stage.sodifrance.com/") 
public class ArticleWSImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://servicemix.esb.stage.sodifrance.com/", "ArticleWSImplService");
    public final static QName ArticleWSImplPort = new QName("http://servicemix.esb.stage.sodifrance.com/", "ArticleWSImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8085/ArticleWSImplPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ArticleWSImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8085/ArticleWSImplPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ArticleWSImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ArticleWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ArticleWSImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns ArticleWS
     */
    @WebEndpoint(name = "ArticleWSImplPort")
    public ArticleWS getArticleWSImplPort() {
        return super.getPort(ArticleWSImplPort, ArticleWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ArticleWS
     */
    @WebEndpoint(name = "ArticleWSImplPort")
    public ArticleWS getArticleWSImplPort(WebServiceFeature... features) {
        return super.getPort(ArticleWSImplPort, ArticleWS.class, features);
    }

}
