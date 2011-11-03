package metronomelogic.command.lireclavier;

import metronome.view.View;
import metronomelogic.controler.Controler;
import metronomelogic.moteur.MoteurMetronome;

public class KeyStart implements KeyIsPushed {

	public KeyStart( MoteurMetronome currentMoteur ){
		this.currentMoteur = currentMoteur;
		//next = new KeyStop( currentMoteur );
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		/*if( isPuched( key ) )*/ currentMoteur.run();
		//else getNext().execute();
	}

	@Override
	public KeyIsPushed getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public boolean isPuched(int key) {
		// TODO Auto-generated method stub
		return key == View.KEY_START;
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
