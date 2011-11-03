package metronome.view;

import metronomelogic.controler.ObservateurPresentation;

public interface BPMViewSubject {
	  void addBPMObs( ObservateurPresentation observer ) ;

	  void notifyViewBPM() ;

	  void removeBPMObs( ObservateurPresentation observer ) ;
}
