package main;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import lattitude.PublishPositionService;

public class Client {
    /**
     * Default InitialContextFactory to use.
     */
    private static final String DEFAULT_INITIAL_CONTEXT_FACTORY = "org.objectweb.carol.jndi.spi.MultiOrbInitialContextFactory";



    /**
     * Main method.
     * @param args the arguments (not required)
     * @throws Exception if exception is found.
     */
    public static final void main(final String[] args) throws Exception {

        Context initialContext = getInitialContext();

        PublishPositionService statelessBean = (PublishPositionService) initialContext
                .lookup("publishPositionBean");

        statelessBean.publishPosition( 1, 2, 3 );
      //statelessBean.publishPosition( 2, 3, 4 );

 

    }

    /**
     * @return Returns the InitialContext.
     * @throws NamingException If the Context cannot be created.
     */
    private static Context getInitialContext() throws NamingException {

        // if user don't use jclient/client container
        // we can specify the InitialContextFactory to use
        // But this is *not recommended*.
        Hashtable<String, Object> env = new Hashtable<String, Object>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, getInitialContextFactory());

        // Usually a simple new InitialContext() without any parameters is sufficent.
        // return new InitialContext();

        return new InitialContext(env);
    }

    /**
     * Returns a configurable InitialContextFactory classname.<br/>
     * Can be configured with the <code>easybeans.client.initial-context-factory</code> System property.
     * @return Returns a configurable InitialContextFactory classname.
     */
    private static String getInitialContextFactory() {
        String prop = System.getProperty("easybeans.client.initial-context-factory");
        // If not found, use the default
        if (prop == null) {
            prop = DEFAULT_INITIAL_CONTEXT_FACTORY;
        }
        return prop;
    }
}
