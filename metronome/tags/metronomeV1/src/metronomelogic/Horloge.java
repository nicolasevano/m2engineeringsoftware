package metronomelogic;

import metronomelogic.command.Command;

public interface Horloge {
	void activerPeriodiquement( Command cmd,double périodeEnSecondes );
	void activerAprésDélai( Command cmd,double périodeEnSecondes );
	void désactiver( Command cmd );
}
