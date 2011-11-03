package metronomelogic.command.lireclavier;

import metronome.view.View;
import metronomelogic.controler.Controler;
import metronomelogic.moteur.MoteurMetronome;

public class KeyDec implements KeyIsPushed {

	public KeyDec(MoteurMetronome currentMoteur){
		this.currentMoteur = currentMoteur;
	}
	
	@Override
	public KeyIsPushed getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPuched(int key) {
		// TODO Auto-generated method stub
		return key == View.KEY_DEC;
	}

	@Override
	public void execute() {
		int tempo;
		//if( isPuched( key ) ){
		tempo = currentMoteur.getTempo();
		currentMoteur.setTempo( ( ( tempo - 1 ) > 1 )? tempo - 1: tempo );
		//} else {
			
		//}
	}
	
	@Override
	public int getKey() {
		return key;
	}

	@Override
	public void setKey(int key) {
		this.key = key;
		if(next != null)next.setKey( key );
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
	
	private int key;
	
	private KeyIsPushed next = null;

	
	private String name = null;

}
