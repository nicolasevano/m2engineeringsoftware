package test;
import automate.*;

import es.*;

public class testauto {

	/**
	 * @param args
	 */
	
	public void executeAutomate1(){
		Automate1 monauto;
		
		monauto = new Automate1();
		monauto.trace_on();   // demande la trace des transitions
		
		//monauto.affiche_tables();   // afficher le contenu des tables
		
		monauto.initTete("test1.txt");
		
		monauto.lancer(); // arret sur '.' ici
		monauto.forcerTete(); // pour paser le point
		monauto.lancer();
	}
	
	public void executeAutomate2(){
		Automate2 monauto;
		
		monauto = new Automate2();
		monauto.trace_on();   // demande la trace des transitions
		
		//monauto.affiche_tables();   // afficher le contenu des tables
		
		monauto.initTete("test2.txt");
		
		monauto.lancer(); // arret sur '.' ici
		monauto.forcerTete(); // pour paser le point
		monauto.lancer();
		monauto.forcerTete();
		monauto.lancer();
		monauto.forcerTete();
		monauto.lancer();
	}
	
	
	public static void main(String[] args) {
		testauto executor = new testauto();
		//executor.executeAutomate1(); 
		executor.executeAutomate2();

		
		
		

	}

}
