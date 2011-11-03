package automate;

public class Automate2 extends Automate {
	
	public Automate2(){
		
		creertables_vides( 15 ); // rappel : 4 est ici le nombre d'etats (1 etat initial ; 0 etat puit)
		initialiser_tables();
			
	}
	
	public void initialiser_tables(){
		
		arcsPourLettres( 1, 2, 0 );
		arcsPourChiffresSans0( 1, 6, 1 );
		unArc( 1, '0', 5, 2 );
		unArc( 1, '.', 5, 0);
		
		arcsPourLettres( 2, 3, 0 );
		
		arcsPourLettres( 3, 3, 0 );
		//arcsPourBoolean( 3, 4 );
		unArc( 3, c_charEspace, 4, 0 );
		unArc( 3, c_charRC, 15, 0 );
		unArc( 3, '.', 1, 0 );
		
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
		
		unArc( 12, 'm', 13, 4 );
		
		unArc( 13, 'n', 14, 5 );
		
		unArc( 14, '.', 1, 0 );
		unArc( 14, c_charRC, 15, 0 );
		
		unArc( 15, c_charNL, 1, 0 );
		
		//remember it
		put_final( 1 );
	}	
	
	protected boolean fini(){
		
		return ( ( char ) tete == '.' );
		
	};
	
	protected void actionFinale(){
		
 		actionFinale2();
 		System.out.println( "Cumul hour : " + timeTotal );
 		
 	}
	
	protected void executeraction( int A, int tete ){
		
		switch ( A ) {
		
			case 1 : sum = tete - Automate.c_code0; break;
			case 2 : sum = sum*10 + tete - Automate.c_code0; break;
			case 3 : h = sum + " h" /*cumul = cumul + 3600*valent*/;
					 sum = 0;
					 break;
			case 4 : m = sum + " min";
					 sum = 0;
					 break;
			case 5 : timeTotal = cumulHour( h + m, timeTotal )/*cumul = cumul + 60*valent*/; break; 
			default : break;
			
		}
		
	}
	
	private String cumulHour( String hourLine, String hourTotal ){
		
		String result = null;
		int hourL = 0;
		int hourT = 0;
		int minL = 0;
		int minT = 0;
		System.out.println( "hourLine = " + hourLine + " ,hourTotal = " + hourTotal );
		if( hourTotal == null ){
			result = hourLine;
		} else {
			//TODO parsing
			hourL = Integer.valueOf( hourLine.substring(0, hourLine.indexOf('h') - 1).trim() );
			hourT = Integer.valueOf( hourTotal.substring(0, hourTotal.indexOf('h') - 1).trim() );
			minL  = Integer.valueOf( 
						hourLine.substring( ( hourLine.indexOf( 'h' ) + 1 ), 
							( hourLine.indexOf( 'm' ) - 1 ) ).trim() );
			minT  =	Integer.valueOf( 
						hourTotal.substring( ( hourTotal.indexOf( 'h' ) + 1 ), 
							( hourTotal.indexOf( 'm' ) - 1 ) ).trim() );
			hourT += hourL;
			minT += minL;
			System.out.println();
			if(minT >= 60){
				minT -= 60;
				hourT += 1; 
			}
			result = hourT + " h " + minT + " min";
		}
		return result;
		
	}
	
	private int sum;
	private String h;
	private String m;
	private String timeTotal;
	
	//private String valent;
	//private String cumul;
}
