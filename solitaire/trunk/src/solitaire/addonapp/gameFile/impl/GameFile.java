package solitaire.addonapp.gameFile.impl;

import solitaire.controler.ICSolitaire;
import solitaire.controler.impl.CCarte;
import solitaire.controler.impl.CTasDeCarteColorees;
import solitaire.controler.impl.CTasDeCartes;
import solitaire.controler.impl.CTasDeCartesAlterne;
import solitaire.controler.impl.CUsine;

public abstract class GameFile {
	
	protected CTasDeCartes convertCacheeToVisible( CTasDeCartes toConvert, CUsine usine){
		CTasDeCartes result = (CTasDeCartes) usine.newTasDeCartes("recop", usine);
		CTasDeCartes tmp = (CTasDeCartes) usine.newTasDeCartes("tmp", usine);
		CCarte current = null;
		CCarte currentVisible;
		do{		
			try {
				current = (CCarte) toConvert.getSommet();
				currentVisible = (CCarte) usine.newCarte( current.getValeur(), current.getCouleur() );
				toConvert.depiler();
				currentVisible.setFaceVisible( true );
				tmp.empiler( current );
				result.empiler( currentVisible );
			} catch (Exception e) {
			}
		}while( !toConvert.isVide() );
		do{
			try {
				current = (CCarte) tmp.getSommet();
				tmp.depiler();
				toConvert.empiler( current );
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}while( !tmp.isVide() );
		return result;
	}
	
	protected CTasDeCartes convertVisibleToCache( CTasDeCartes toConvert, CUsine usine){
		CTasDeCartes result = (CTasDeCartes) usine.newTasDeCartes("recop", usine);
		CTasDeCartes tmp = (CTasDeCartes) usine.newTasDeCartes("tmp", usine);
		CCarte currentCache;
		CCarte current = null;
		do{		
			try {
				current = (CCarte) toConvert.getSommet();
				currentCache = (CCarte) usine.newCarte( current.getValeur(), current.getCouleur() );
				toConvert.depiler();
				currentCache.setFaceVisible( false );
				tmp.empiler( current );
				result.empiler( currentCache );
			} catch (Exception e) {
			}
		}while( !toConvert.isVide() );
		do{
			try {
				current = (CCarte) tmp.getSommet();
				tmp.depiler();
				toConvert.empiler( current );
			} catch (Exception e) {
			}
		}while( !tmp.isVide() );
		return result;
	}
	
	protected CTasDeCartes copieTas( CTasDeCartes toConvert, CUsine usine ){
		CTasDeCartes result = (CTasDeCartes) usine.newTasDeCartes("recop", usine);
		CTasDeCartes tmp = (CTasDeCartes) usine.newTasDeCartes("tmp", usine);
		CCarte current = null;
		do{		
			try {
				current = (CCarte) toConvert.getSommet();
				toConvert.depiler();
				tmp.empiler( current );
				result.empiler( current );
			} catch (Exception e) {
			}
		}while( !toConvert.isVide() );
		do{
			try {
				current = (CCarte) tmp.getSommet();
				tmp.depiler();
				toConvert.empiler( current );
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}while( !tmp.isVide() );
		return result;
	}
	
	protected CTasDeCartes copieTas( CTasDeCartesAlterne toConvert, CUsine usine ){
		CTasDeCartes result = (CTasDeCartes) usine.newTasDeCartes("recop", usine);
		CTasDeCartes tmp = (CTasDeCartes) usine.newTasDeCartes("tmp", usine);
		CCarte current = null;
		while( !toConvert.isVide() ){		
			try {
				current = (CCarte) toConvert.getSommet();
				toConvert.depiler();
				tmp.empiler( current );
				result.empiler( current );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		while( !tmp.isVide() ){
			try {
				current = (CCarte) tmp.getSommet();
				tmp.depiler();
				toConvert.empiler( current );
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		return result;
	}
	
	protected CTasDeCartes copieTas( CTasDeCarteColorees toConvert, CUsine usine ){
		CTasDeCartes result = (CTasDeCartes) usine.newTasDeCartes("recop", usine);
		CTasDeCartes tmp = (CTasDeCartes) usine.newTasDeCartes("tmp", usine);
		CCarte current = null;
		do{		
			try {
				current = (CCarte) toConvert.getSommet();
				toConvert.depiler();
				tmp.empiler( current );
				result.empiler( current );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while( !toConvert.isVide() );
		do{
			try {
				current = (CCarte) tmp.getSommet();
				tmp.depiler();
				toConvert.empiler( current );
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}while( !tmp.isVide() );
		return result;
	}

	protected CTasDeCartes parseALineConfigFile( String line, CUsine usine ){
		CTasDeCartes result = ( CTasDeCartes ) usine.newTasDeCartes("recop", usine);
		CTasDeCartes tmp = ( CTasDeCartes ) usine.newTasDeCartes("recop", usine);
		CCarte current = null;
		String data = line.substring( line.indexOf( ":" ) + 1, line.length()-1 ).trim();
		String [] cartes;
		String color;
		String valeur;
		int valeurCarte;
		int couleurCarte;
		if(data != null && !data.isEmpty()){
			//System.out.println("data: " + data);
			cartes = data.split("\\]\\[");
			cartes[0] = cartes[0].substring( cartes[0].indexOf( "[" ) + 1,cartes[0].length() );
			cartes[ cartes.length - 1 ] = cartes[ cartes.length - 1 ].substring( 0, cartes[cartes.length - 1].indexOf( "]" ) );
			for( int i = 0; i < cartes.length; i++ ){
				//System.out.println("try to create carte with data:" + cartes[i]);
				couleurCarte = 0;
				valeurCarte = 0;
				//D=carreau(1) S=pic(2) H=coeur(3) C=treffle(4)
				color = cartes[i].substring( cartes[i].length() - 1, cartes[i].length() );
				if( "D".equals( color ) )couleurCarte = 1;
				else if( "S".equals( color ) )couleurCarte = 2;
				else if( "H".equals( color ) )couleurCarte = 3;
				else if( "C".equals( color ) )couleurCarte = 4;
				//J=valet(11), Q=reine(12), K=roi(13)
				valeur = cartes[i].substring( 0, cartes[i].length() - 1 );
				if( "J".equals( valeur ) )valeur = "11";
				else if( "Q".equals( valeur ) )valeur = "12";
				else if( "K".equals( valeur ) )valeur = "13";
				valeurCarte = Integer.valueOf( valeur );
				current = (CCarte) usine.newCarte( valeurCarte, couleurCarte );
				tmp.empiler( current );
			}
			do{
				try {
					result.empiler( tmp.getSommet() );
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
				tmp.depiler();
			}while( !tmp.isVide() );
		}
		return result;
	}
	
	protected void viderTas( CTasDeCartes toVide ){
		
		try{
			while( !toVide.isVide() ){
				toVide.depiler();
			}
		}catch(Exception e){

		}
		
	}
	
	protected void viderTas( CTasDeCartesAlterne toVide ){
		try{
			while( !toVide.isVide() ){
				toVide.depiler();
			}
		}catch(Exception e){

		}
		
	}
	
	protected void viderTas( CTasDeCarteColorees toVide ){
		try{
			while( !toVide.isVide() ){
				toVide.depiler();
			}
		}catch(Exception e){
			
		}
		
	}
	
	protected ICSolitaire main;
}
