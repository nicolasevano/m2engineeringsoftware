package metronome.view;

import metronomelogic.Afficheur;
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
	
}
