package metronomelogic;

import metronomelogic.command.Command;

public interface Horloge {
	void activerPeriodiquement( Command cmd,double p�riodeEnSecondes );
	void activerApr�sD�lai( Command cmd,double p�riodeEnSecondes );
	void d�sactiver( Command cmd );
}
