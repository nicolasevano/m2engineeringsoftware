
package metronomelogic.controler;

import metronome.view.View;
import metronomelogic.Afficheur;
import metronomelogic.EmetteurSonore;
import metronomelogic.Horloge;
import metronomelogic.moteur.MoteurMetronome;


public interface Controler extends Observateur,ObservateurPresentation {

  int convertInBPM(double bpmRatio) ;

  double getMoletteBPM();

  Horloge getHorloge();
  
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

}
