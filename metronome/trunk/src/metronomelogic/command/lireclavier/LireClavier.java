
package metronomelogic.command.lireclavier;

import metronome.view.View;
import metronomelogic.Clavier;
import metronomelogic.command.Command;
import metronomelogic.moteur.MoteurMetronome;



public class LireClavier implements Command {
  
	public LireClavier( MoteurMetronome currentMoteur ){
		
		//this.currentMoteur = currentMoteur;
		//this.view = currentMoteur.getAccede().getPresente();
		//chaineDeResponsabilité = new KeyStart( currentMoteur );
		view = currentMoteur.getAccede().getPresente();
		keyStart = new KeyStart( currentMoteur );
		keyStop = new KeyStop( currentMoteur );
		keyInc = new KeyInc( currentMoteur );
		keyDec = new KeyDec( currentMoteur );
		
		
	}

	public void execute() {
		
		//int key = currentMoteur.getAccede().getTouchePressé();
		int key = view.getTouchePressé();
		for(int i =0;i < 5;i++){
			if(i == key){
				if( keyPresseds[i] ){
					//state has no changed
				} else {
					//state has changed
					if( key == View.KEY_NONE ){
					//nothing todo in this case
					} else if( key == View.KEY_START ){
						keyStart.execute();
					} else if( key == View.KEY_STOP ){
						keyStop.execute();
					} else if( key == View.KEY_INC ){
						keyInc.execute();
					} else if( key == View.KEY_DEC ){
						keyDec.execute();
					}
					keyPresseds[i] = true;
				}
			} else {
				//all other preceding key state has to be false 
				keyPresseds[i] = false;
			}
		}
		/*
		chaineDeResponsabilité.setKey(key);
		chaineDeResponsabilité.execute();
		*/
		
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
	
	
	
	private String name = MoteurMetronome.commandName[ MoteurMetronome.LIRE_CLAVIER ];
	
	private Command keyStart;
	private Command keyStop;
	private Command keyInc;
	private Command keyDec;
	//private KeyIsPushed chaineDeResponsabilité;
	private View view;
	
	//No use in this implementation
	private boolean [] keyPresseds = new boolean[]{
			false,
			false,
			false,
			false,
			false,
	};
}
