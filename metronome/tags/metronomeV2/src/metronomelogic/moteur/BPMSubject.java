
package metronomelogic.moteur;

import metronomelogic.controler.Observateur;


interface BPMSubject {
	
  void addBPMObs(Observateur observer) ;

  void notifyBPM() ;

  void removeBPMObs(Observateur observer) ;

}
