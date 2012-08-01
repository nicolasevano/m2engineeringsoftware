package com.sodifrance.referential_book;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

import com.sodifrance.referential_book.ArticleDao;
import com.sodifrance.referential_book.Book;

@WebService( endpointInterface = "com.sodifrance.referential_book.BookWS" )
public class BookWSImpl implements BookWS {

	@Override
	public String addBook( String title, 
						   String author, 
						   String editor,
						   String descriptif, 
						   int nbPage, 
						   int nbChapitre, 
						   int version,
						   String releaseDate, 
						   String publishDate ) {
		// TODO Auto-generated method stub
		String result = null;
		Book toAdd = new Book( title, author, editor, version, descriptif, nbPage, nbChapitre, releaseDate, publishDate );
		List<Book> toUpdate = articleDao.findArticle( toAdd );
		if( toUpdate.size() == 0 ) {
			
			articleDao.persist( toAdd );
			result = OKResult;
			
		} else {
			result = NOKResult;
		}
		return result;
	}

	@Override
	public String updateBook( Book article ) {
		// TODO Auto-generated method stub
		String result = null;
		List<Book> toUpdate = articleDao.findArticle( article );
		if( toUpdate.size() == 1 ) {
			
			articleDao.commit( toUpdate.get( 0 ) );
			result = OKResult;
			
		} else {
			result = NOKResult;
		}
		return result;
	}

	@Override
	public String deleteBook( Book article ) {
		// TODO Auto-generated method stub
		String result = null;
		List<Book> toRemove = articleDao.findArticle( article );
		if( toRemove.size() == 1 ){
			
			articleDao.removeOneClient( toRemove.get( 0 ) );
			result = OKResult;
			
		} else {
			
			result = NOKResult;
		}
		return result;
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return articleDao.getAllArticles();
	}
	
	private String OKResult = "OK";
	private String NOKResult = "NOK";
	
	@Inject
	private ArticleDao< Book > articleDao;
}
