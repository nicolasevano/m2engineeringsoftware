package com.sodifrance.referential_book;

import java.util.Date;
import java.util.List;

public interface ArticleDao<Article> {
	/**
	 * persist add a new customer on data store.
	 * @param client
	 */
	public abstract void persist( Article article );

	/**
	 * Commit on data store an update on a client reccord.
	 * @param client
	 */
	public abstract void commit( final Article article );

	/**
	 * Find one article record on data store by the given title and publish date parameter
	 * @param firstName first customer name
	 * @param lastName last customer name
	 * @param birthDate birth of the customer
	 * @return customer list, the size of returned list is one if a customer has been find otherwise 0. 
	 */
	public abstract List< Article > findArticle( final String title, final Date publishDate );

	/**
	 * Find a article on base by the given id parameter
	 * @param ID
	 * @return
	 */
	public abstract List< Article > findArticle( final String ID );
	
	/**
	 * Find one customer record on data store
	 * @param client Client
	 */
	public abstract List< Article > findArticle( final Article article );

	/**
	 * Find all customer on the data store
	 * @return customer list
	 */
	public abstract List< Article > getAllArticles();

	/**
	 * remove one customer reccord from the data store
	 * @param toRemove
	 */
	public abstract void removeOneClient( final Article toRemove );
	
	/**
	 * removeAll client stored on base
	 */
	public abstract void removeAll();
}
