package com.sodifrance.stage.esb.talend;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class AggregateCache implements AggregationStrategy{

	public Exchange aggregate( Exchange oldExchange, Exchange newExchange ) {
		if ( oldExchange == null ) {
			return newExchange;
		}

		String articlesPrevious = oldExchange.getIn().getBody( String.class );
		String articlesNext = newExchange.getIn().getBody( String.class );

		// just avoid bad inputs by assuming its a 0 value
		StringBuilder articles = new StringBuilder(); 
		articles.append("<?xml version='1.0' encoding='ISO-8859-1'?>").
		append("<all>").
		append("<request>").
		append( ( articlesPrevious != null ? articlesPrevious : "" ) ).
		append("</request>").
		append("<response>").
		append( ( articlesNext != null ? articlesNext : "" ) ).
		append("</response>").
		append("</all>");
		oldExchange.getIn().setBody( articles.toString() );

		return oldExchange;
	}

}
