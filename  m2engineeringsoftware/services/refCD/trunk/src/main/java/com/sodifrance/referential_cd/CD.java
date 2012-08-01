package com.sodifrance.referential_cd;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
/**
 * CD entity definition
 * @author nevano_stage
 *
 */
public class CD implements Serializable{

	/**
	 * empty constructor
	 */
	public CD(){
		
	}
	
	/**
	 * public constructor with date type parameter
	 * @param title
	 * @param artist
	 * @param editor
	 * @param numberOfTrack
	 * @param releaseDate
	 * @param publishDate
	 */
	public CD( String title, String artist, String editor,int numberOfTrack,Date releaseDate, Date publishDate ){
		this.title = title;
		this.artist = artist;
		this.editor = editor;
		this.numberOfTrack = numberOfTrack;
		this.releaseDate = releaseDate;
		this.publishDate = publishDate;
	}
	
	/**
	 * public constructor with string type parameter instead of date
	 * @param title
	 * @param artist
	 * @param editor
	 * @param numberOfTrack
	 * @param releaseDate
	 * @param publishDate
	 */
	public CD( String title, String artist, String editor, int numberOfTrack, String releaseDate, String publishDate ){
		
		this.title = title;
		this.artist = artist;
		this.editor = editor;
		this.numberOfTrack = numberOfTrack;
		
		if( releaseDate != null && !releaseDate.isEmpty() ){
			try {
				System.out.println( "release date: " + releaseDate );
				SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" );
				ParsePosition pos = new ParsePosition( 0 );
				this.releaseDate = new Date( 
							formatter.parse( releaseDate , pos ).getTime() 
							);
			} catch ( RuntimeException e ) {
				System.out.println( "Exception message: " + e.getMessage() );
				e.printStackTrace();
			}
		} else {
			this.releaseDate = null;
		}
		
		if( publishDate != null && !publishDate.isEmpty() ){
			try {
				SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" );
				ParsePosition pos = new ParsePosition( 0 );
				this.publishDate = new Date( 
							formatter.parse( publishDate , pos ).getTime() 
							);
			} catch ( RuntimeException e ) {
				System.out.println( "Exception message: " + e.getMessage() );
				e.printStackTrace();
			}
		} else {
			this.publishDate = null;
		}
		
	}
	
    public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle( String title ) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist( String artist ) {
		this.artist = artist;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getNumberOfTrack() {
		return numberOfTrack;
	}

	public void setNumberOfTrack(int numberOfTrack) {
		this.numberOfTrack = numberOfTrack;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate( Date releaseDate ) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseDateStr(){
		SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" );
		return formatter.format( this.releaseDate );
	}
	
	@DateTimeFormat( pattern="dd/MM/yyyy" )
	public void setReleaseDate( String releaseDateStr ) {
		if( releaseDateStr != null ){
			try {
					SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" );
					ParsePosition pos = new ParsePosition( 0 );
					this.releaseDate = new Date( 
							formatter.parse( releaseDateStr , pos ).getTime() 
							);
			} catch ( RuntimeException e ) {
					//e.printStackTrace();
				this.publishDate = null;
			}
		}
	}
	
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate( Date publishDate ) {
		this.publishDate = publishDate;
	}
	
	public String getPublishDateStr(){
		SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" );
		return formatter.format( this.publishDate );
	}
	
	@DateTimeFormat( pattern="dd/MM/yyyy" )
	public void setPublishDate( String publishDateStr ) {
		if( publishDateStr != null ){
			try {
					SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" );
					ParsePosition pos = new ParsePosition( 0 );
					this.publishDate = new Date( 
							formatter.parse( publishDateStr , pos ).getTime() 
							);
			} catch ( RuntimeException e ) {
					//e.printStackTrace();
				this.publishDate = null;
			}
		}
	}	
	
	@Override
	public String toString() {
		return ( new StringBuilder() ).
				append( "CD [title=" ).append( title ).
				append( ", artist=").append( artist ).
				append( ", editor=").append( editor ).
				append( ", numberOfTrack=").append( numberOfTrack ).
				append( ", releaseDate=").append( releaseDate ).
				append( ", publishDate=").append( publishDate ).append( "]" ).
				toString();
	}
	// Persistent Fields:
	/**
	 * primary key
	 */
    @Id @GeneratedValue
	long id;
    /**
     * CD title
     */
    @NotNull
	private String title;
    
    /**
     * artists that made this album
     */
	@NotNull
    private String artist;
	
	/**
	 * editor of this album
	 */
    @NotNull
    private String editor;
    
    /**
     * number of track of this album
     */
    @NotNull
    @Pattern( regexp="[0-9]+" )
	private int numberOfTrack;
    
    /**
     * release date of this album
     */
    @NotNull
	@DateTimeFormat( pattern="dd/MM/yyyy" )
	private Date releaseDate;
    
    /**
     * publish date on referential
     */
    @NotNull
    @DateTimeFormat( pattern="dd/MM/yyyy" )
	private Date publishDate;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2354152442581587273L;
}
