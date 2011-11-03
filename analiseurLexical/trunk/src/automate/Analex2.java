package automate;

import lexical.*;

public class Analex2 extends Automate {
	
	/**
	 * PETIT ANALYSEUR LEXICAL RECONNAISSNT
	 *    ident :   <lettre><lettre><lettre>*
	 *    entier:   <chiffre><chiffre>*
	 *    inf 	:	<
	 *    inegal:	<=
	 *    egal	:	=
	 */
    
	//	 INITIALISATION DES TABLES 
    // Partie 1  à réaliser pour un automate particulier
	 public Analex2(){
		 
		creertables_vides( 15 ); // rappel : 15 est ici le nombre d'etats (1 etat initial ; 0 etat puit)
		initialiser_tables();
			
	}

	
	 public void initialiser_tables(){
	 	
		 	arcsPourUnionLettres( 1, 2, 7 );
			arcsPourChiffresSans0( 1, 6, 1 );
			unArc( 1, '0', 5, 2 );
			//unArc( 1, '.', 5, 0);
			arcsPourUnionLettres( 2, 3, 7 );
			
			//arcsPourLettres( 2, 3, 0 );
			
			arcsPourUnionLettres( 3, 3, 7 );
			//arcsPourBoolean( 3, 4 );
			unArc( 3, c_charEspace, 0, 8 );
			unArc( 3, c_charRC, 0, 8 );
			//unArc( 3, c_charNL, 15, constlex.lexident );
			//unArc( 3, '.', 1, constlex.lexident );
			
			//arcsPourBoolean( 4, 4 );
			unArc( 4, c_charEspace, 4, 0 );
			arcsPourChiffresSans0( 4, 6, 1 );
			unArc( 4, '0', 5, 0 );
			
			//arcsPourBoolean( 5, 7 );
			unArc( 5, c_charEspace, 7, 0 );
			//arcsPourChiffresSans0( 5, 6, 1);
			
			arcsPourChiffres( 6, 6, 2 );
			//arcsPourBoolean( 6, 7 );
			unArc( 6, c_charEspace, 7, 0 );
			
			unArc( 7, 'h', 8, 3 );
			
			//arcsPourBoolean( 8, 9 );
			unArc( 8, c_charEspace, 9, 0 );
			
			arcsPourChiffresDe0a5( 9, 10, 1 );
			
			arcsPourChiffres( 10, 11, 2 );
			
			//arcsPourBoolean( 11, 12 );
			unArc( 11, c_charEspace, 12, 0 );
			unArc( 11, 'm', 13, 4 );
			
			unArc( 12, 'm', 13, 4 );
			
			unArc( 13, 'n', 14, 5 );
			
			//unArc( 14, '.', 1, 0 );
			unArc( 14, c_charRC, 15, 0 );
			
			unArc( 15, c_charNL, 0, 0 );
			
			//remember it
			put_final( 1 );
			
			
			//unArcPourTemps(1, "LesTemps" , 2 , lexTemps);
			
			
	}
	
	 // ici on redéfini fini()
	 protected boolean fini(){ return ( etatCourant == 0 ) ; };
	 
	 // PROGRAMMATION DES ACTIONS
	 // Partie 2  à réaliser pour un automate particulier

	 int lexlu ; // type de l'unite lue
	 String chainelue;  // valeur de l'unite lue

	 public IUniteLex unitelue ;

	 protected void actionInitiale(){

		 lexlu=constlex.lexerreur;
		 chainelue="";


	 }


	 protected void actionFinale(){
		 actionFinale2();
		 switch (lexlu){
		 	case constlex.lexident:
		 		 if( chainelue.contains( "Plus" ) ){
		 			 lexlu = constlex.lexres;
		 			 unitelue = new UniteLexRes( lexlu, chainelue );
		 		 } else if( chainelue.contains( "Double" ) ){
		 			 lexlu = constlex.lexres;
		 			 unitelue = new UniteLexRes( lexlu, chainelue );
		 		 } else if( chainelue.contains( "Moins" ) ){
		 			 lexlu = constlex.lexres;
		 			 unitelue = new UniteLexRes( lexlu, chainelue );
		 		 } else {
		 			 unitelue = new UniteLexIdent( lexlu, chainelue );
		 		 }
		 		 break;
		 	case constlex.lexduree:
		 		 unitelue = new UniteLexDuree( lexlu, timeTotal );
		 		 timeTotal = 0;
		 		 break;
		 	case constlex.lexerreur:
		 		 unitelue = new UniteLexError();
		 		 break;
		 }
		 chainelue = "";
		 //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 //TODO update it for choose if it is ident or res word.
		 //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	 }


	 protected void executeraction( int A, int tete ){

		 switch ( A ) {
		 case 1 : sum = tete - Automate.c_code0;
		 		  chainelue = chainelue + ( char ) tete;
		 		  break;
		 case 2 : sum = sum*10 + tete - Automate.c_code0;
		 		  chainelue = chainelue + ( char ) tete;
		 		  break;
		 case 3 : h = sum + " h" /*cumul = cumul + 3600*valent*/;
		 		  sum = 0;
		 		  chainelue = chainelue + ( char ) tete;
		 		  break;
		 case 4 : m = sum + " min";
		 		  sum = 0;
		 		  chainelue = chainelue + ( char ) tete;
		 		  lexlu = constlex.lexduree;
		 		  break;
		 case 5 : timeTotal = cumulMinute( h + m, timeTotal );
		 		  chainelue = chainelue + ( char ) tete;  
		 		  break;
		 case 7 : chainelue = chainelue + ( char ) tete;
		 		  break;
		 case 8 : lexlu = constlex.lexident;
		  	      break;
		 default : break;
		 }
	 }

	 private int cumulMinute( String hourLine, int minTotal ){

		 int result;
		 int hourL;
		 int minL;
		 System.out.println( "hourLine = " + hourLine + " ,minTotal = " + minTotal );
		 //TODO parsing
		 hourL = Integer.valueOf( hourLine.substring(0, hourLine.indexOf('h') - 1).trim() );
		 minL  = Integer.valueOf( 
				 hourLine.substring( ( hourLine.indexOf( 'h' ) + 1 ), 
						 ( hourLine.indexOf( 'm' ) - 1 ) ).trim() );
		 minTotal += hourL * 60;
		 minTotal += minL;
		 result = minTotal;
		 return result;

	 }

	 private int sum;
	 private String h;
	 private String m;
	 private int timeTotal;
	 private String chaineLu;

}
