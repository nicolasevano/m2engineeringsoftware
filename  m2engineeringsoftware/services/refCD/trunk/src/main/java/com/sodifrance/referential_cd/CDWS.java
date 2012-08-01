package com.sodifrance.referential_cd;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.sodifrance.referential_cd.CD;

@WebService
public interface CDWS {
	
	@WebMethod( operationName = "addCD", action = "urn:AddCD" )
	/**
	 * add a new CD record
	 * @param title
	 * @param artist
	 * @param editor
	 * @param numberOfTrack
	 * @param releaseDate
	 * @param publishDate
	 * @return
	 */
	public abstract String addCD( String title, String artist, String editor, int numberOfTrack, String releaseDate, String publishDate );
	
	@WebMethod( operationName = "updateCD", action = "urn:updateCD" )
	/**
	 * update one CD record.
	 * @param article
	 * @return
	 */
	public abstract String updateCD( CD article );
	
	@WebMethod( operationName = "deleteCD", action = "urn:deleteCD" )
	/**
	 * delete one CD record.
	 * @param article
	 * @return
	 */
	public abstract String deleteCD( CD article );
	
	@WebMethod( operationName = "getAllCD", action = "urn:getAllCD" )
	/**
	 * get all CD record. 
	 * @return
	 */
	public abstract List< CD > getAllCD(); 
}
