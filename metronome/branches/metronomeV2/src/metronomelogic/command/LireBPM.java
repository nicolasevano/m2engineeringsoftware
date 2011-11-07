
package metronomelogic.command;

import metronome.view.View;
import metronomelogic.Molette;
import metronomelogic.moteur.MoteurMetronome;



public class LireBPM implements Command {
	
	public LireBPM(MoteurMetronome currentMoteur){
		
		this.currentMoteur = currentMoteur;
		this.presentation = currentMoteur.getAccede().getPresente();
	
	}

	public void execute() {
		
		//double position = currentMoteur.getAccede().getMoletteBPM();
		//System.out.println("position is:" + position);
		//int bpm = currentMoteur.getAccede().convertInBPM(position);
		//currentMoteur.setBPM( bpm );
		//currentMoteur.getAccede().getAfficheur().afficherTempo( currentMoteur.getBPM() );
		//System.out.println( "bpm is: " + bpm );
		presentation.setBPM();
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
	private View presentation;
	
	private String name = MoteurMetronome.commandName[MoteurMetronome.LIRE_BPM];
	
}
