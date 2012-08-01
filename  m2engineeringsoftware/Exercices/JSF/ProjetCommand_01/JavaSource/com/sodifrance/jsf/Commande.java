package com.sodifrance.jsf;

import java.util.Date;

public class Commande {
	
	public String getArticle() {
		return article;
	}
	
	public String command(){
		return "commander";
	}
	
	public String annuler(){
		return "annuler";
	}
	
	public String init(){
		article = "";
		prix = 0.00;
		quantite = 1;
		total = 0.00;
		addresse = "";
		zipCode = 0;
		city = "";
		mail = "";
		creditCart = "";
		date = null;
		return "OK";
	}
	
	public void setArticle(String article) {
		this.article = article;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public int getQuantite() {
		return quantite;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getAddresse() {
		return addresse;
	}
	
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getCreditCart() {
		return creditCart;
	}
	
	public void setCreditCart(String creditCart) {
		this.creditCart = creditCart;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	private String article;
	private double prix;
	private int quantite;
	private double total;
	private String addresse;
	private int zipCode;
	private String city;
	private String mail;
	private String creditCart;
	private Date date;
}
