package com.sodifrance.referential_cd;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

import com.sodifrance.referential_cd.ArticleDao;
import com.sodifrance.referential_cd.CD;
import com.sodifrance.referential_cd.CDWS;


@WebService( endpointInterface = "com.sodifrance.referential_cd.CDWS" )
public class CDWSImpl implements CDWS {

	public String addCD( String title, 
						 String artist, 
						 String editor,
						 int numberOfTrack, 
						 String releaseDate, 
						 String publishDate ) {
		// TODO Auto-generated method stub
		String result = null;
		CD toAdd = new CD( title,artist,editor,numberOfTrack,releaseDate,publishDate );
		List<CD> toUpdate = articleDao.findArticle( toAdd );
		if( toUpdate.size() == 0 ) {
			
			articleDao.persist( toAdd );
			result = OKResult;
			
		} else {
			result = NOKResult;
		}
		return result;
	}

	public String updateCD( CD article ) {
		// TODO Auto-generated method stub
		String result = null;
		List<CD> toUpdate = articleDao.findArticle( article );
		if( toUpdate.size() == 1 ) {
			
			articleDao.commit( toUpdate.get( 0 ) );
			result = OKResult;
			
		} else {
			result = NOKResult;
		}
		return result;
	}

	public String deleteCD( CD article ) {
		// TODO Auto-generated method stub
		String result = null;
		List<CD> toRemove = articleDao.findArticle( article );
		if( toRemove.size() == 1 ){
			
			articleDao.removeOneClient( toRemove.get( 0 ) );
			result = OKResult;
			
		} else {
			
			result = NOKResult;
		}
		return result;
	}

	public List< CD > getAllCD() {
		// TODO Auto-generated method stub
		return articleDao.getAllArticles();
	}
	
	
	private String OKResult = "OK";
	private String NOKResult = "NOK";
	
	@Inject
	private ArticleDao< CD > articleDao;

	
}
