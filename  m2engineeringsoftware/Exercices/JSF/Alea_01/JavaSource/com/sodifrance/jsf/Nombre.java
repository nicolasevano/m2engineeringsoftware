package com.sodifrance.jsf;

public class Nombre {
	
	
	public Nombre(){
		valeurListener = new ValeurChangeListener( this );
		init();
	}
	
	public void init(){
		nombreARechercher = ( int ) ( Math.random()*10 ) + 1;
		tentative = 0;
		valeur = 0;
		test = false;
	}
	
	public void setValeur( int valeur ){
		System.out.println( "new valeur = " + valeur );
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
		String result = null;
		if( tentative == 0 ) result = "tentez votre chance";
		else if( test ) result = "bravo vous avez trouvé!";
		else result = "Non, ce n'est pas le bon chiffre, refaites un essai.";
		System.out.println( "result: " + result );
		return result;
	}
	
	public String getProgression(){
		String result = null;
		if( tentative == 0 || test ) result = "";
		else result = "le nombre est plus " + ( ( nombreARechercher > valeur )? "grand" : "petit" );
		return result;
	}
	
	public String fini(){
		System.out.println( "result: " + ( ( ( !test ) && ( tentative < 3 ) )? "finir" : "continuer" ) );
		return ( ( !test ) && ( tentative < 3 ) )? "continuer":"finir";
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
	
	public ValeurChangeListener getValeurListener() {
		return valeurListener;
	}

	public void setValeurListener(ValeurChangeListener valeurListener) {
		this.valeurListener = valeurListener;
	}
	
	private int valeur;
	private int nombreARechercher;
	private int tentative;
	private boolean test;
	private ValeurChangeListener valeurListener;
	
	
}
