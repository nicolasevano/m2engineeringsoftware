
package metronomelogic.command;

import metronomelogic.moteur.MoteurMetronome;



public class GenererEclairSurLED1 implements Command {
	
	public GenererEclairSurLED1(MoteurMetronome currentMoteur){
		this.currentMoteur = currentMoteur;
	}

	public void execute() {
		currentMoteur.getAccede().getAfficheur().afficherLED( 1 );
		currentMoteur.getAccede().getHorloge().activerAprésDélai(
				new EtteindreLED1(currentMoteur),0.5);
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
	
	private String name = MoteurMetronome.commandName[MoteurMetronome.GENERER_ECLAIR_LED1];
}
