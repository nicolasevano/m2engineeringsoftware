
package metronomelogic.moteur;

import metronomelogic.controler.Observateur;


interface TempoSubject {
	
  void notifyTempo() ;

  void addTempoObs( Observateur watcher ) ;

  void removeTempoObs( Observateur watcher ) ;

}
