package com.sodifrance.stage.esb.servicemix.cache;

import java.io.InputStream;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.Topic;
import javax.jms.TopicConnection;

import org.apache.camel.component.cache.CacheManagerFactory;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.distribution.jms.AcknowledgementMode;
import net.sf.ehcache.distribution.jms.JMSCacheManagerPeerProvider;

public class ArticleCacheManagerFactory extends CacheManagerFactory {
	//This constructor is very useful when using Camel with Spring/Blueprint
    public ArticleCacheManagerFactory(String xmlName, 
            TopicConnection replicationTopicConnection, Topic replicationTopic, 
            QueueConnection getQueueConnection, Queue getQueue) {
        this.xmlName = xmlName;
        this.replicationTopicConnection = replicationTopicConnection;
        this.replicationTopic = replicationTopic;
        this.getQueue = getQueue;
        this.getQueueConnection = getQueueConnection;
    }

    @Override
    protected synchronized CacheManager createCacheManagerInstance() {
        //Singleton
        if (cacheManager == null) {
            cacheManager = new WrappedCacheManager(getClass().getResourceAsStream(xmlName));
        }

        return cacheManager;
    }

    //Wrapping Ehcache's CacheManager to be able to add JMSCacheManagerPeerProvider
    public class WrappedCacheManager extends CacheManager {
        public WrappedCacheManager(InputStream xmlConfig) {
            super(xmlConfig);
            JMSCacheManagerPeerProvider jmsCMPP = new JMSCacheManagerPeerProvider(this,
                            replicationTopicConnection,
                            replicationTopic,
                            getQueueConnection,
                            getQueue,
                            AcknowledgementMode.AUTO_ACKNOWLEDGE,
                            true);
            cacheManagerPeerProviders.put(jmsCMPP.getScheme(), jmsCMPP);
            jmsCMPP.init();
        }
    }
    
    private String xmlName;

    //Only for testing purpose, normally not needed
    private CacheManager cacheManager;

    private Topic replicationTopic;

    private Queue getQueue;

    private TopicConnection replicationTopicConnection;

    private QueueConnection getQueueConnection;
}
