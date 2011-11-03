package metronomelogic.command.lireclavier;

import metronome.view.View;
import metronomelogic.controler.Controler;
import metronomelogic.moteur.MoteurMetronome;

public class KeyStop implements KeyIsPushed {

	public KeyStop(MoteurMetronome currentMoteur){
		this.currentMoteur = currentMoteur;
		/*this.next = new KeyInc( currentMoteur );*/
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		/*if( isPuched( key ) )*/currentMoteur.stop();
		//else next.execute();
	}

	@Override
	public KeyIsPushed getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public boolean isPuched(int key) {
		// TODO Auto-generated method stub
		return key == View.KEY_STOP;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
		if(next != null) next.setKey( key );
	}
	
	private KeyIsPushed next = null;
	
	private String name = null;
	
	private int key;
	
	private MoteurMetronome currentMoteur;
}
