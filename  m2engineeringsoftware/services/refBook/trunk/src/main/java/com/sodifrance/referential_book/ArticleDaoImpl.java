package com.sodifrance.referential_book;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sodifrance.referential_book.ArticleDao;
import com.sodifrance.referential_book.Book;
@Component( "articleDaoImpl" )
public class ArticleDaoImpl implements ArticleDao< Book > {

	@Transactional
	public void persist( final Book article ) {
		// TODO Auto-generated method stub
		em.persist( article );
	}

	@Transactional( propagation = Propagation.REQUIRED )
	public void commit( final Book article ) {
		
		// TODO Auto-generated method stub
		Book toUpdate = em.find( Book.class, article.getId() );
		toUpdate.setTitle( article.getTitle() );
		toUpdate.setAuthor( article.getAuthor() );
		toUpdate.setEditor( article.getEditor() );
		toUpdate.setDescription( article.getDescription() );
		toUpdate.setNBPage( article.getNBPage() );
		toUpdate.setNBChapitre( article.getNBChapitre() );
		toUpdate.setPublishDate( article.getPublishDate() );
		toUpdate.setReleaseDate( article.getReleaseDate() );
		toUpdate.setVersion( article.getVersion() );
		
	}

	public List< Book > findArticle( final String title, final Date publishDate ) {
		// TODO Auto-generated method stub
		System.out.println( ( new StringBuilder() ).append( "try to find Book with: title=" ).append( title ).append( " and publish date = " ).append( publishDate ).append( "." ) );
		TypedQuery<Book> queryResult = em.createQuery(
				/*query.toString()*/queryFindOneBook, Book.class );

		queryResult.setParameter( "title", title  );
		queryResult.setParameter( "publishDate", publishDate, TemporalType.DATE );
		//System.out.println( "result size = " + queryResult.getResultList().size() );
		return queryResult.getResultList();
	}

	public List< Book > findArticle( final String ID ) {
		System.out.println( ( new StringBuilder() ).append( "try to find book with id=" ).append( ID ).append( "." ) );
		TypedQuery<Book> queryResult = em.createQuery( queryFindBookbyID, Book.class );
		queryResult.setParameter( "id", ID  );
		// TODO Auto-generated method stub
		return queryResult.getResultList();
	}

	public List< Book > findArticle( final Book article ) {
		System.out.println( ( new StringBuilder() ).append( "try to find book with: " ).append( article ).append( "." ) );
		TypedQuery<Book> queryResult = em.createQuery( queryFindOneBook, Book.class );
		queryResult.setParameter( "title", article.getTitle() );
		queryResult.setParameter( "publishDate", article.getPublishDate(), TemporalType.DATE );
		return queryResult.getResultList();
	}

	public List< Book > getAllArticles() {
		TypedQuery<Book> queryResult = em.createQuery( queryFindAllBook, Book.class );
		return queryResult.getResultList();
	}

	@Transactional( propagation = Propagation.REQUIRED )
	public void removeOneClient( final Book toRemove ) {
		// TODO Auto-generated method stub
		System.out.println( ( new StringBuilder() ).append( "try to remove book with: " ).append( toRemove ).append( "." ) );
		Book toRemoveAttach = em.find( Book.class, toRemove.getId() );
		em.remove( toRemoveAttach );
	}

	@Transactional( propagation = Propagation.REQUIRED )
	public void removeAll() {
		// TODO Auto-generated method stub
		System.out.println( "Deleting all book." );
		List< Book > cds = getAllArticles();
		int nbIteration = cds.size();
		for( int i = 0; i < nbIteration; i++ ){
			removeOneClient( cds.get( i ) );
		}
		System.out.println( "All book record deleted." );
	}
	
	//Injected database connection
	@PersistenceContext( unitName="referentialBookPU" )
	private EntityManager em;
	private String queryFindOneBook = "SELECT g FROM Book g WHERE g.title LIKE :title AND g.publishDate = :publishDate ORDER BY g.id";
	private String queryFindBookbyID = "SELECT g FROM Book g WHERE g.id = :id";
	private String queryFindAllBook = "SELECT g FROM Book g ORDER BY g.id";
	
}

