package com.sodifrance.stage.esb.talend.cache;

import java.util.Collection;
import java.util.Map;

import javax.jms.Queue;
import javax.jms.QueueConnection;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Status;
import net.sf.ehcache.distribution.jms.AcknowledgementMode;
import net.sf.ehcache.loader.CacheLoader;
import net.sf.ehcache.distribution.jms.JMSCacheLoader;

import org.apache.camel.component.cache.CacheLoaderWrapper;

public class WrappedJMSCacheLoader implements CacheLoaderWrapper {

	//This constructor is very useful when using Camel with Spring/Blueprint
	public WrappedJMSCacheLoader(QueueConnection getQueueConnection,
			Queue getQueue, AcknowledgementMode acknowledgementMode,
			int timeoutMillis) {
		this.getQueueConnection = getQueueConnection;
		this.getQueue = getQueue;
		this.acknowledgementMode = acknowledgementMode;
		this.timeoutMillis = timeoutMillis;
	}

	@Override
	public CacheLoader clone(Ehcache arg0) throws CloneNotSupportedException {
		return jmsCacheLoader.clone(arg0);
	}

	@Override
	public void dispose() throws CacheException {
		jmsCacheLoader.dispose();
	}

	@Override
	public String getName() {
		return jmsCacheLoader.getName();
	}

	@Override
	public Status getStatus() {
		return jmsCacheLoader.getStatus();
	}

	@Override
	public void init() {
		jmsCacheLoader.init();
	}

	@Override
	public Object load(Object arg0) throws CacheException {
		return jmsCacheLoader.load(arg0);
	}

	@Override
	public Object load(Object arg0, Object arg1) {
		return jmsCacheLoader.load(arg0, arg1);
	}

	@Override
	public Map loadAll(Collection arg0) {
		return jmsCacheLoader.loadAll(arg0);
	}

	@Override
	public Map loadAll(Collection arg0, Object arg1) {
		return jmsCacheLoader.loadAll(arg0, arg1);
	}

	@Override
	public void init(Ehcache cache) {
		jmsCacheLoader = new JMSCacheLoader(cache, defaultLoaderArgument,
				getQueueConnection, getQueue, acknowledgementMode,
				timeoutMillis);
	}

	private JMSCacheLoader jmsCacheLoader;
	private String defaultLoaderArgument = "";
	private QueueConnection getQueueConnection;
	private Queue getQueue;
	private AcknowledgementMode acknowledgementMode;
	private int timeoutMillis;

}
