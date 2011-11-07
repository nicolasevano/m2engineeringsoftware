package metronome.view;

import metronomelogic.Afficheur;
import metronomelogic.Clavier;
import metronomelogic.EmetteurSonore;
import metronomelogic.Horloge;
import metronomelogic.Molette;
import metronomelogic.controler.Controler;


public interface View extends BPMViewSubject{
	
	public void allumerLED1();
	public void allumerLED2();
	public void eteindreLED1();
	public void eteindreLED2();
	public void emettreSon();
	public void notifyBPM();
	public void displayBPM(int bpm);
	public Horloge getHorloge();
	public EmetteurSonore getEmetteurSonore();
	public Controler getControler();
	public Afficheur getAfficheur();
	public Molette getMolette();
	public void setBPM();
	public Clavier getClavier();
	public int getTouchePressé();
	
	static final int KEY_NONE = 0;
	  
	static final int KEY_START = 1;
	  
	static final int KEY_STOP = 2;
	  
	static final int KEY_INC = 3;
	  
	static final int KEY_DEC = 4;
	  
	static final int [] key = new int[]{
		  KEY_NONE,
		  KEY_START,
		  KEY_STOP,
		  KEY_INC,
		  KEY_DEC
	};
	
}
