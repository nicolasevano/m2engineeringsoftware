package metronomelogic.command;

import metronomelogic.moteur.MoteurMetronome;

public class EtteindreLED2 implements Command {

	public EtteindreLED2(MoteurMetronome moteurMetronome){
		this.currentMoteur = moteurMetronome;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		currentMoteur.getAccede().getAfficheur().etteindreLED( 2 );
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
	
	private String name = null;
}
