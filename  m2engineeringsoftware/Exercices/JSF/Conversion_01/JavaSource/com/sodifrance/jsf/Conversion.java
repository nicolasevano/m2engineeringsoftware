package com.sodifrance.jsf;

import java.util.Date;

public class Conversion {
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getResultat() {
		return resultat;
	}
	
	public void setResultat(double resultat) {
		
		this.resultat = resultat;
		if(this.isFrancEuro())setFrancs(this.resultat);
		else setEuros(this.resultat);
		
	}
	
	public double getEuros() {
		return euros;
	}
	
	public void setEuros(double euros) {
		this.euros = euros;
		this.francs = this.euros * this.TAUX;
	}
	
	public double getFrancs() {
		return francs;
	}
	
	public void setFrancs(double francs) {
		this.francs = francs;
		this.euros = this.francs / this.TAUX;
	}
	
	public double getQuantité() {
		return quantité;
	}
	
	public void setQuantité(double quantité) {
		this.quantité = quantité;
	}
	
	public final double getTAUX() {
		return TAUX;
	}
	
	public String setFrancToEuro(){
		this.francEuro = true;
		return "OK";
	}
	
	public String setEuroToFranc(){
		this.francEuro = false;
		return "OK";
	}
	
	public boolean isFrancEuro() {
		return francEuro;
	}
	
	public void setFrancEuro( boolean francEuro ) {
		this.francEuro = francEuro;
	}
	
	public String convertEuroToFranc(){
		this.francEuro = false;
		setResultat( getResultat() );
		return "OK";
	}
	
	public String convertFrancToEuro(){
		this.francEuro = true;
		setResultat( getResultat() );
		return "OK";
	}
	
	private boolean francEuro;
	private Date date = new Date();
	private final double TAUX = 6.55957;
	private double resultat;
	private double euros;
	private double francs;
	private double quantité = 1;
	
}
