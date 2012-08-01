package com.sodifrance.stage.esb.talend;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@Entity(name = "article")
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * CD entity definition
 * @author nevano_stage
 *
 */
public class Article{

	public long getId() {
		return id;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor( String author ) {
		this.author = author;
	}

	public String getKind() {
		return kind;
	}

	public void setKind( String kind ) {
		this.kind = kind;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate( String releaseDate ) {
		this.releaseDate = releaseDate;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate( String publishDate ) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return ( new StringBuilder() ).
				append( "Article [title=" ).append( title ).
				append( ", author=").append( author ).
				append( ", kind=").append( kind ).
				append( ", editor=").append( editor ).
				append( ", meta=").append( meta ).
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
	@XmlElement
	private String title;

	@XmlElement
	private String kind;

	/**
	 * artists that made this album
	 */
	@XmlElement
	private String author;

	/**
	 * editor of this album
	 */
	@XmlElement
	private String editor;

	/**
	 * number of track of this album
	 */
	@XmlElement
	private String meta;

	/**
	 * release date of this album
	 */
	@XmlElement
	private String releaseDate;

	/**
	 * publish date on referential
	 */
	@XmlElement
	private String publishDate;

}
