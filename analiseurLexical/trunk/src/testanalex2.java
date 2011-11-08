import automate.Analex2;


public class testanalex2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 
		Analex2 monauto;
		
		monauto = new Analex2();
		/*monauto.trace_on();*/   // demande la trace des transitions
		monauto.trace_off();
		//monauto.affiche_tables();   // afficher le contenu des tables
		
		monauto.initTete("testanalexTP2.txt");
		
		do {
			monauto.lancer();
			//System.out.println( "tete apres lancer "+monauto.donne_tete() );
		
			System.out.println( "unite : "+monauto.unitelue.unitelex_to_String());
			monauto.forcerTete();
		} while (!monauto.bande.finDeFichier()/*monauto.unitelue.typelex != constlex.lexerreur*/);
		
	}

}
