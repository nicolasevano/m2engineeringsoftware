package automate;

public class Automate1 extends Automate{
	
    
	//	 INITIALISATION DES TABLES 
    // Partie 1  à  réaliser pour un automate particulier
	 public Automate1(){
		creertables_vides(4); // rappel : 4 est ici le nombre d'etats (1 etat initial ; 0 etat puit)
		initialiser_tables();
			
	}

	
	
	 public void initialiser_tables(){
			
			unArc(1,c_charEspace,1,0);
			unArc(1,c_charNL,1,0);
			unArc(1,c_charRC,1,0);
			
			unArc(2,c_charEspace,4,0);
			unArc(2,c_charNL,4,0);
			unArc(2,c_charRC,4,0);
			
			unArc(4,c_charEspace,4,0);
			unArc(4,c_charNL,4,0);
			unArc(4,c_charRC,4,0);
			
			
			arcsPourChiffres(1,2,1);
			arcsPourChiffres(2,2,2);
			
			unArc(2,'h',1,3);
			unArc(4,'h',1,3);
			
			unArc(2,'s',1,4);
			unArc(4,'s',1,4);
			
			unArc(2,'m',3,0);
			unArc(4,'m',3,0);
			
			unArc(3,'n',1,5);
			
			//don't forget it!!!
			put_final(1);
	}
	
	 // ici on redéfini fini()
	 	protected boolean fini(){return ((char)tete == '.' ) ;};
	 
	 	// PROGRAMMATION DES ACTIONS
	    // Partie 2  A  réaliser pour un automate particulier
	 
	 	int valent ; // valeur de l'entier courant
	 	int cumul;  // cumul des durees en seconde
	 	
	 	protected void actionInitiale(){

	 		cumul = 0;
	 	}
	 	
	 	
	 	protected void actionFinale(){
	 		actionFinale2();
	 		System.out.println("Cumul en secondes : "+cumul);
	 	}
	 	
	 	protected void executeraction(int A, int tete){
			switch (A) {
			case 1 : valent=tete- c_code0; break;
			case 2 : valent =  valent*10 + tete - c_code0; break;
			case 3 : cumul=cumul +3600*valent; break;
			case 4 : cumul=cumul +valent; break;
			case 5 : cumul=cumul +60*valent; break; 
			default :   break;
			
			}
	
			
		}
	 	
	 	
	 	

}
