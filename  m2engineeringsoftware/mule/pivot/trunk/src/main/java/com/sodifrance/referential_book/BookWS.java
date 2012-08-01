package com.sodifrance.referential_book;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.sodifrance.referential_book.Book;

@WebService
public interface BookWS {

	@WebMethod( operationName = "addBook", action = "urn:AddBook" )
	/**
	 * add a new Book record
	 * @param title
	 * @param artist
	 * @param editor
	 * @param version
	 * @param numberOfTrack
	 * @param releaseDate
	 * @param publishDate
	 * @return
	 */
	public abstract String addBook( String title, 
			                        String arthor, 
			                        String editor, 
			                        String descriptif, 
			                        int nbPage, 
			                        int nbChapitre, 
			                        int version, 
			                        String releaseDate, 
			                        String publishDate );

	@WebMethod( operationName = "updateBook", action = "urn:updateBook" )
	/**
	 * update one Book record.
	 * @param article
	 * @return
	 */
	public abstract String updateBook( Book article );

	@WebMethod( operationName = "deleteBook", action = "urn:deleteBook" )
	/**
	 * delete one Book record.
	 * @param article
	 * @return
	 */
	public abstract String deleteBook( Book article );

	@WebMethod( operationName = "getAllBook", action = "urn:getAllBook" )
	/**
	 * get all Book record. 
	 * @return
	 */
	public abstract List< Book > getAllBook(); 

}
