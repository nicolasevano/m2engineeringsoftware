package com.sodifrance.stage.esb.servicemix;

import java.util.List;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.util.CastUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.JpaTemplate;

/**
 * A Message Transformer of an XML document to a Customer entity bean
 * 
 * @version 
 */
// START SNIPPET: example
@Converter
public class ItemTransformer {

    private static final transient Logger LOG = LoggerFactory.getLogger(ItemTransformer.class);

    /**
     * A transformation method to convert a person document into a customer
     * entity
     * @throws Exception 
     */
    @Converter
    public Article toCustomer(PossibleArticle doc, Exchange exchange) throws Exception {
        JpaTemplate template = exchange.getIn().getHeader("CamelJpaTemplate", JpaTemplate.class);

        
        String title = doc.getTitle();
        Article article = findArticleByName(template, title);

        // let's convert information from the document into the entity bean
        article.setTitle(title);
        article.setEditor(doc.getEditor());
        article.setKind(doc.getKind());
        article.setMeta(doc.getMeta());
        article.setPublishDate(doc.getPublishDate());
        article.setReleaseDate(doc.getReleaseDate());

        LOG.debug("Created object customer: " + article);
        return article;
    }

    /**
     * Finds a customer for the given username
     */
    protected Article findArticleByName(JpaTemplate template, String title) throws Exception {
        List<Article> list = CastUtils.cast(template.find("select x from article"
                                                                 + " x where x.title = ?1", title));
        if (list.isEmpty()) {
            Article answer = new Article();
            answer.setTitle( title );
            return answer;
        } else {
            return list.get( 0 );
        }
    }

}
// END SNIPPET: example

