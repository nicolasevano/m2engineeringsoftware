package metronomelogic.command;

import metronomelogic.moteur.MoteurMetronome;

public class EtteindreLED1 implements Command{

	public EtteindreLED1( MoteurMetronome moteurMetronome ){
		this.currentMoteur = moteurMetronome; 
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		currentMoteur.getAccede().getAfficheur().etteindreLED( 1 );
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
