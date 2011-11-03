
package metronomelogic.controler;

import metronome.view.View;
import metronomelogic.Afficheur;
import metronomelogic.EmetteurSonore;
import metronomelogic.Horloge;
import metronomelogic.moteur.MoteurMetronome;


public interface Controler extends Observateur,ObservateurPresentation {
  int getTouchePressé() ;

  int convertInBPM(double bpmRatio) ;

  double getMoletteBPM() ;

  Horloge getHorloge() ;
  
  Afficheur getAfficheur();
  
  EmetteurSonore getEmetteurSonore();
  
  MoteurMetronome getManage();
  
  void setManage( MoteurMetronome moteurMetronome );

  public View getPresente();
  
  public void setPresente(View presente);
  
  void start();
  
  void stop();
  
  void incTempo();
  
  void decTempo();

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
