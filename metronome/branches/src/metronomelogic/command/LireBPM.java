
package metronomelogic.command;

import metronomelogic.moteur.MoteurMetronome;



public class LireBPM implements Command {
	
	public LireBPM(MoteurMetronome currentMoteur){
		
		this.currentMoteur = currentMoteur;
	
	}

	public void execute() {
		
		double position = currentMoteur.getAccede().getMoletteBPM();
		//System.out.println("position is:" + position);
		int bpm = currentMoteur.getAccede().convertInBPM(position);
		currentMoteur.setBPM( bpm );
		currentMoteur.getAccede().getAfficheur().afficherTempo( currentMoteur.getBPM() );
		//System.out.println( "bpm is: " + bpm );
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
	
	private String name = MoteurMetronome.commandName[MoteurMetronome.LIRE_BPM];
	
}
