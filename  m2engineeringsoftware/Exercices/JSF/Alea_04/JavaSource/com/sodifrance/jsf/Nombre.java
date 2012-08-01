package com.sodifrance.jsf;

import java.util.Date;

public class Nombre {
	
	
	public Nombre(){
		init();
	}
	
	public String init(){
		nombreARechercher = ( int ) ( Math.random()*15 ) + 1;
		tentative = 0;
		valeur = 0;
		test = false;
		date = new Date();
		return OK;
	}
	
	public void setValeur( int valeur ){
		//System.out.println( "new valeur = " + valeur );
		if(this.valeur != valeur){
			this.valeur = valeur;
			tentative++;
			test = ( nombreARechercher == valeur );
		}
	}
	
	public int getValeur(){
		return this.valeur;
	}
	
	public String getResultat(){
		StringBuilder result = new StringBuilder();
		if( tentative == 0 ) result.append( beLuky );
		else if( test ) result.append( wheelDone );
		else result = result.append( tryAgain );
		//System.out.println( "result: " + result );
		return result.toString();
	}
	
	public String getProgression(){
		StringBuilder result = new StringBuilder();
		if(tentative == 0 || test) result.append("");
		else result.append( numberIsMore ).append( ( nombreARechercher > valeur )? great : little );
		return result.toString();
	}
	
	public String fini(){
		//System.out.println( "result: " + ( ( ( !test ) && ( tentative < 3 ) )? "finir" : "continuer" ) );
		return ( ( !test ) && ( tentative < 3 ) )? goOn:finish;
	}
	
	public int getTentative() {
		return tentative;
	}

	public void setTentative(int tentative) {
		this.tentative = tentative;
	}
	
	public int getNombreARechercher() {
		return nombreARechercher;
	}

	public void setNombreARechercher(int nombreARechercher) {
		this.nombreARechercher = nombreARechercher;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	private int valeur;
	private int nombreARechercher;
	private int tentative;
	private boolean test;
	
	private String beLuky = "Tentez votre chance";
	private String wheelDone = "Bravo, vous avez trouvé!";
	private String tryAgain = "Non, ce n'est pas le bon chiffre, refaites un essai.";
	private String finish = "finir";
	private String goOn = "continuer";
	private String numberIsMore = "le nombre est plus ";
	private String great = "grand";
	private String little = "petit";
	private String OK = "OK";
	private Date date;
	
}
