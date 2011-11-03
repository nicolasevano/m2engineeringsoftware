
package metronomelogic.command;

import metronomelogic.moteur.MoteurMetronome;



public class GenererEclairSurLED2 implements Command {
	
	public GenererEclairSurLED2( MoteurMetronome currentMoteur ){
		this.currentMoteur = currentMoteur;
	}
	
	public void execute() {
		currentMoteur.getAccede().getAfficheur().afficherLED( 2 );
		currentMoteur.getAccede().getHorloge().activerAprésDélai(
				new EtteindreLED2(currentMoteur),0.2);
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	private MoteurMetronome currentMoteur;
	
	private String name = MoteurMetronome.commandName[MoteurMetronome.GENERER_ECLAIR_LED2];
}
