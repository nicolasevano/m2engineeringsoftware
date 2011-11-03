
package metronomelogic.command;

import metronomelogic.moteur.MoteurMetronome;



public class GenererSon implements Command {

	public GenererSon( MoteurMetronome currentMoteur ){
		this.currentMoteur = currentMoteur;
	}
	
	public void execute() {
		currentMoteur.getAccede().getEmetteurSonore().emettreClic();
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
	
	private String name = MoteurMetronome.commandName[MoteurMetronome.GENERER_CLIC];
  
}
