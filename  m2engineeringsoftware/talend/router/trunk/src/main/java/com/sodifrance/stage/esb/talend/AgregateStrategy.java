/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sodifrance.stage.esb.talend;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * Aggregate two numbers
 *
 * @version 
 */
// START SNIPPET: e1
public class AgregateStrategy implements AggregationStrategy {

    public Exchange aggregate( Exchange oldExchange, Exchange newExchange ) {
    	
        if ( oldExchange == null ) {
            return newExchange;
        }

        String articlesPrevious = oldExchange.getIn().getBody( String.class );
        String articlesNext = newExchange.getIn().getBody( String.class );

        // just avoid bad inputs by assuming its a 0 value
        StringBuilder articles = new StringBuilder(); 
        articles.append("<?xml version='1.0' encoding='UTF-8'?>").
        		 append("<all>").
        		 append( ( articlesPrevious != null ? articlesPrevious : "" ) ).
        		 append( ( articlesNext != null ? articlesNext : "" ) ).
        		 append("</all>");
        oldExchange.getIn().setBody( articles.toString() );

        return oldExchange;
    }

}
// END SNIPPET: e1
