package com.sodifrance.referential_book;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
/**
 * book referencial entity definition
 * @author nevano_stage
 *
 */
public class Book {

	
	/**
	 * book empty constructor
	 */
	public Book(){
		
	}
	
	/**
	 * constructor with date parameter under string format in this dd/MM/yyyy format
	 * @param title
	 * @param author
	 * @param editor
	 * @param version
	 * @param descriptif
	 * @param NBPage
	 * @param NBChapitre
	 * @param releaseDate
	 * @param publishDate
	 */
	public Book( String title, String author, String editor, int version, String description, int NBPage, int NBChapitre, String releaseDateStr, String publishDateStr ){
		this.title = title;
		this.author = author;
		this.editor = editor;
		this.version = version;
		this.description = description;
		this.NBPage = NBPage;
		this.NBChapitre = NBChapitre;
		if( releaseDateStr != null && !releaseDateStr.isEmpty() ){
			try {
					SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" );
					ParsePosition pos = new ParsePosition( 0 );
					this.releaseDate = new Date( 
							formatter.parse( releaseDateStr , pos ).getTime() 
							);
			} catch ( RuntimeException e ) {
					e.printStackTrace();
			}
		} else {
			releaseDate = null;
		}
		
		if( publishDateStr != null && !publishDateStr.isEmpty() ){
			try {
					SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" );
					ParsePosition pos = new ParsePosition( 0 );
					this.publishDate = new Date( 
							formatter.parse( publishDateStr , pos ).getTime() 
							);
			} catch ( RuntimeException e ) {
					e.printStackTrace();
			}
		} else {
			publishDate = null;
		}
		
	}
	
	/**
	 * book standard constructor
	 * @param title
	 * @param author
	 * @param editor
	 * @param version
	 * @param descriptif
	 * @param NBPage
	 * @param NBChapitre
	 * @param releaseDateStr
	 * @param publishDateStr
	 */
	public Book( String title, String author, String editor, int version, String descriptif, int NBPage, int NBChapitre, Date releaseDate, Date publishDate ){
		
		this.title = title;
		this.author = author;
		this.editor = editor;
		this.version = version;
		this.description = descriptif;
		this.NBPage = NBPage;
		this.NBChapitre = NBChapitre;
		this.releaseDate = releaseDate;
		this.publishDate = publishDate;
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNBPage() {
		return NBPage;
	}

	public void setNBPage(int nBPage) {
		NBPage = nBPage;
	}

	public int getNBChapitre() {
		return NBChapitre;
	}

	public void setNBChapitre(int nBChapitre) {
		NBChapitre = nBChapitre;
	}
	
	@XmlJavaTypeAdapter(DateXmlFormater.class)
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
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
	
	@XmlJavaTypeAdapter(DateXmlFormater.class)
	public Date getPublishDate() {
		return publishDate;
	}
	
	@DateTimeFormat( pattern="dd/MM/yyyy" )
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@DateTimeFormat( pattern="dd/MM/yyyy" )
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
	
	public long getId() {
		return id;
	}

	
	
	@Override
	public String toString() {
		return ( new StringBuilder() ).append( "Book [id=" ).append( id ).
									   append( ", title=" ).append( title ).
									   append( ", author=" ).append( author ).
									   append( ", editor=" ).append( editor ).
									   append( ", version=" ).append( version ).
									   append( ", description=" ).append( description ).
									   append( ", NBPage=" ).append( NBPage ).
									   append( ", NBChapitre=" ).append( NBChapitre ).
									   append( ", releaseDate=" ).append( releaseDate ).
									   append( ", publishDate=" ).append( publishDate ).
									   append( "]" ).toString();
	}



	@Id @GeneratedValue
	private long id;
	
	@NotNull
	private String title;
	
	@NotNull
	private String author;
	
	@NotNull
	private String editor;
	
	@NotNull
	private int version;
	
	private String description;
	
	@NotNull
	private int NBPage;
	
	@NotNull
	private int NBChapitre;
	
	@NotNull
	@DateTimeFormat( pattern="dd/MM/yyyy" )
	private Date releaseDate;
	
	@NotNull
	@DateTimeFormat( pattern="dd/MM/yyyy" )
	private Date publishDate;
	
}
