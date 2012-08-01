package com.sodifrance.referential_cd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sodifrance.referential_cd.ArticleDao;
import com.sodifrance.referential_cd.CD;
@Component( "articleDaoImpl" )
public class ArticleDaoImpl implements ArticleDao< CD > {

	@Transactional
	public void persist( final CD article ) {
		// TODO Auto-generated method stub
		em.persist( article );
	}

	@Transactional( propagation = Propagation.REQUIRED )
	public void commit( final CD article ) {
		
		// TODO Auto-generated method stub
		CD toUpdate = em.find( CD.class, article.getId() );
		toUpdate.setTitle( article.getTitle() );
		toUpdate.setArtist( article.getArtist() );
		toUpdate.setEditor( article.getEditor() );
		toUpdate.setNumberOfTrack( article.getNumberOfTrack() );
		toUpdate.setPublishDate( article.getPublishDate() );
		toUpdate.setReleaseDate( article.getReleaseDate() );
		
	}

	public List< CD > findArticle( final String title, final Date publishDate ) {
		// TODO Auto-generated method stub
		System.out.println( ( new StringBuilder() ).append( "try to find CD with: title=" ).append( title ).append( " and publish date = " ).append( publishDate ).append( "." ) );
		TypedQuery<CD> queryResult = em.createQuery(
				/*query.toString()*/queryFindOnesCD, CD.class );

		queryResult.setParameter( "title", title  );
		queryResult.setParameter( "publishDate", publishDate, TemporalType.DATE );
		//System.out.println( "result size = " + queryResult.getResultList().size() );
		return queryResult.getResultList();
	}

	public List< CD > findArticle( final String ID ) {
		List< CD > result = new ArrayList< CD >();
		System.out.println( ( new StringBuilder() ).append( "try to find CD with id=" ).append( ID ).append( "." ) );
		CD toAddOnResult = em.find( CD.class, Long.valueOf( ID ) );
		if( toAddOnResult != null ) result.add( toAddOnResult );
		return result;
	}

	public List< CD > findArticle( final CD article ) {
		System.out.println( ( new StringBuilder() ).append( "try to find CD with: " ).append( article ).append( "." ) );
		TypedQuery<CD> queryResult = em.createQuery( queryFindOnesCD, CD.class );
		queryResult.setParameter( "title", article.getTitle() );
		queryResult.setParameter( "publishDate", article.getPublishDate(), TemporalType.DATE );
		return queryResult.getResultList();
	}

	public List< CD > getAllArticles() {
		TypedQuery<CD> queryResult = em.createQuery( queryFindAllCD, CD.class );
		return queryResult.getResultList();
	}
	
	@Transactional( propagation = Propagation.REQUIRED )
	public void removeOneClient( final CD toRemove ) {
		// TODO Auto-generated method stub
		System.out.println( ( new StringBuilder() ).append( "try to remove CD with: " ).append( toRemove ).append( "." ) );
		CD toRemoveAttach = em.find( CD.class, toRemove.getId() );
		em.remove( toRemoveAttach );
	}

	@Transactional( propagation = Propagation.REQUIRED )
	public void removeAll() {
		// TODO Auto-generated method stub
		System.out.println( "Deleting all cd." );
		List< CD > cds = getAllArticles();
		int nbIteration = cds.size();
		for(int i = 0; i < nbIteration; i++){
			removeOneClient( cds.get( i ) );
		}
		System.out.println( "All cd record deleted." );
	}
	
	//Injected database connection
	@PersistenceContext( unitName="referentialCDPU" )
	private EntityManager em;
	private String queryFindOnesCD = "SELECT g FROM CD g WHERE g.title LIKE :title AND g.publishDate = :publishDate ORDER BY g.id";
	private String queryFindAllCD = "SELECT g FROM CD g ORDER BY g.id";
	
}
